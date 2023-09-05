package asset_location_details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_location_details.model.dto.AssetLocationDetail_DTO;
import asset_location_details.model.master.AssetLocationDetail;
import asset_location_details.model.master.AssetLocationDetailPK;
import asset_location_details.model.repo.AssetLocationDetailsAdmin_Repo;

@Service("assetLocationDetailsAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetLocationDetailsAdmin_Service implements I_AssetLocationDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetLocationDetailsService.class);
	
	
	@Autowired
    private AssetLocationDetailsAdmin_Repo assetLocationDetailsAdminRepo;
	
	public AssetLocationDetail_DTO newAssetLocationDetail(AssetLocationDetail_DTO lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		Optional<AssetLocationDetail> assetLocationDetails = null;
		AssetLocationDetail assetLocationDetails2 = null;
		AssetLocationDetailPK assetLocationDetailPK = new AssetLocationDetailPK();  		
		assetLocationDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		assetLocationDetailPK.setFrDttm(ts_Fr);
		assetLocationDetailPK.setToDttm(ts_To);
		assetLocationDetails = assetLocationDetailsAdminRepo.findById(assetLocationDetailPK); 
		
		if(!assetLocationDetails.isPresent())
		{			
		assetLocationDetails2 = setAssetLocationDetail(lMaster);	
		assetLocationDetails2.setId(assetLocationDetailPK);
		assetLocationDetails2 = assetLocationDetailsAdminRepo.save(assetLocationDetails2);
		lMaster = getAssetLocationDetail_DTO(assetLocationDetails2);
		}
		return lMaster;
	}

	public ArrayList<AssetLocationDetail_DTO> getAllAssetLocationDetails() 
	{
		ArrayList<AssetLocationDetail> assetLocationList =  (ArrayList<AssetLocationDetail>) assetLocationDetailsAdminRepo.findAll();
		ArrayList<AssetLocationDetail_DTO> lMasterss = assetLocationList != null ? this.getAssetLocationDetailDtos(assetLocationList) : null;
		return lMasterss;
	}

	public ArrayList<AssetLocationDetail_DTO> getSelectDetails(ArrayList<AssetLocationDetailPK> seqNos) 
	{
		ArrayList<AssetLocationDetail> assetLocationList =  (ArrayList<AssetLocationDetail>) assetLocationDetailsAdminRepo.findAllById(seqNos);
		ArrayList<AssetLocationDetail_DTO> lMasterss = assetLocationList != null ? this.getAssetLocationDetailDtos(assetLocationList) : null;
		return lMasterss;
	}

	public ArrayList<AssetLocationDetail_DTO> getDetailsBetweenTimes(String fr, String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		Optional<AssetLocationDetail> assetLocationDetails = null;
		AssetLocationDetail assetLocationDetails2 = null;
		ArrayList<AssetLocationDetail> lMasters2 = assetLocationDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetLocationDetail> assetLocationList =  (ArrayList<AssetLocationDetail>) assetLocationDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetLocationDetail_DTO> lMasterss = assetLocationList != null ? this.getAssetLocationDetailDtos(assetLocationList) : null;
		return lMasterss;		
	}
	
	public void updAssetLocationDetail(AssetLocationDetail_DTO lMaster) 
	{
		AssetLocationDetail assetLocationMaster = null;
		
		if(lMaster!=null)
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");	
		AssetLocationDetailPK assetLocationDetailPK = null;	
		assetLocationDetailPK = new AssetLocationDetailPK();
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		assetLocationDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		assetLocationDetailPK.setFrDttm(ts_Fr);
		assetLocationDetailPK.setToDttm(ts_To);		
		
		if (assetLocationDetailsAdminRepo.existsById(assetLocationDetailPK))
		{
			assetLocationMaster = setAssetLocationDetail(lMaster); 
			assetLocationMaster.setId(assetLocationDetailPK);
			assetLocationDetailsAdminRepo.save(assetLocationMaster);
		}
		}
	}

	public void delAllAssetLocationDetails()
	{
		assetLocationDetailsAdminRepo.deleteAll();
	}

	public void delSelectDetails(ArrayList<AssetLocationDetailPK> seqNos) 
	{
		
		if(seqNos!=null)
		{			
		assetLocationDetailsAdminRepo.deleteAllById(seqNos);
		
		}

	}
	
	public void delSelectDetailsBetweenTimes(String fr, String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;	
		dateFr = LocalDateTime.parse(fr, formatter);
		dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		assetLocationDetailsAdminRepo.delDetailsBetweenTimes(ts_Fr, ts_To);		
		return;		
	}


	private ArrayList<AssetLocationDetail_DTO> getAssetLocationDetailDtos(ArrayList<AssetLocationDetail> lMasters) {
		AssetLocationDetail_DTO lDTO = null;		
		ArrayList<AssetLocationDetail_DTO> lMasterDTOs = new ArrayList<AssetLocationDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = getAssetLocationDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetLocationDetail_DTO getAssetLocationDetail_DTO(AssetLocationDetail lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetLocationDetail_DTO lDTO = new AssetLocationDetail_DTO();		
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setFrDttm(formatter.format(lMaster.getId().getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getId().getToDttm().toLocalDateTime()));
		lDTO.setPartySeqNo(lMaster.getPartySeqNo());
		lDTO.setLocationSeqNo(lMaster.getId().getLocationSeqNo());		
		return lDTO;
	}

	private AssetLocationDetail setAssetLocationDetail(AssetLocationDetail_DTO lDTO) {
		AssetLocationDetail lMaster = new AssetLocationDetail();
		AssetLocationDetailPK assetLocationDetailPK = new AssetLocationDetailPK();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;	
		dateFr = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		dateTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetLocationDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetLocationDetailPK.setFrDttm(ts_Fr);
		assetLocationDetailPK.setToDttm(ts_To);
		assetLocationDetailPK.setLocationSeqNo(lDTO.getLocationSeqNo());
		lMaster.setPartySeqNo(lDTO.getPartySeqNo());
		lMaster.setId(assetLocationDetailPK);
		return lMaster;
	}
	
}