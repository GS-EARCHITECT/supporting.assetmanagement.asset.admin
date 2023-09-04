package asset_users_details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_users_details.model.dto.AssetUsersDetail_DTO;
import asset_users_details.model.master.AssetUsersDetail;
import asset_users_details.model.master.AssetUsersDetailPK;
import asset_users_details.model.repo.AssetUsersDetailsAdmin_Repo;

@Service("assetUsersDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetUsersDetailsAdmin_Service implements I_AssetUsersDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetUsersDetailsService.class);
	
	
	@Autowired
    private AssetUsersDetailsAdmin_Repo assetUsersDetailsAdminRepo;
	
	public AssetUsersDetail_DTO newAssetUsersDetail(AssetUsersDetail_DTO lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		Optional<AssetUsersDetail> assetUsersDetails = null;
		AssetUsersDetail assetUsersDetails2 = null;
		AssetUsersDetailPK assetUsersDetailPK = new AssetUsersDetailPK();  		
		assetUsersDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		assetUsersDetailPK.setFrDttm(ts_Fr);
		assetUsersDetailPK.setToDttm(ts_To);
		assetUsersDetails = assetUsersDetailsAdminRepo.findById(assetUsersDetailPK); 
		
		if(!assetUsersDetails.isPresent())
		{			
		assetUsersDetails2 = setAssetUsersDetail(lMaster);	
		assetUsersDetails2.setId(assetUsersDetailPK);
		assetUsersDetails2 = assetUsersDetailsAdminRepo.save(assetUsersDetails2);
		lMaster = getAssetUsersDetail_DTO(assetUsersDetails2);
		}
		return lMaster;
	}

	public ArrayList<AssetUsersDetail_DTO> getAllAssetUsersDetails() 
	{
		ArrayList<AssetUsersDetail> assetUsersList =  (ArrayList<AssetUsersDetail>) assetUsersDetailsAdminRepo.findAll();
		ArrayList<AssetUsersDetail_DTO> lMasterss = assetUsersList != null ? this.getAssetUsersDetailDtos(assetUsersList) : null;
		return lMasterss;
	}

	public ArrayList<AssetUsersDetail_DTO> getSelectDetails(ArrayList<AssetUsersDetailPK> seqNos) 
	{
		ArrayList<AssetUsersDetail> assetUsersList =  (ArrayList<AssetUsersDetail>) assetUsersDetailsAdminRepo.findAllById(seqNos);
		ArrayList<AssetUsersDetail_DTO> lMasterss = assetUsersList != null ? this.getAssetUsersDetailDtos(assetUsersList) : null;
		return lMasterss;
	}

	public ArrayList<AssetUsersDetail_DTO> getDetailsBetweenTimes(String fr, String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		Optional<AssetUsersDetail> assetUsersDetails = null;
		AssetUsersDetail assetUsersDetails2 = null;
		ArrayList<AssetUsersDetail> lMasters2 = assetUsersDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetUsersDetail> assetUsersList =  (ArrayList<AssetUsersDetail>) assetUsersDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetUsersDetail_DTO> lMasterss = assetUsersList != null ? this.getAssetUsersDetailDtos(assetUsersList) : null;
		return lMasterss;		
	}
	
	public void updAssetUsersDetail(AssetUsersDetail_DTO lMaster) 
	{
		AssetUsersDetail assetUsersMaster = null;
		
		if(lMaster!=null)
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");	
		AssetUsersDetailPK assetUsersDetailPK = null;	
		assetUsersDetailPK = new AssetUsersDetailPK();
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		assetUsersDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		assetUsersDetailPK.setFrDttm(ts_Fr);
		assetUsersDetailPK.setToDttm(ts_To);		
		
		if (assetUsersDetailsAdminRepo.existsById(assetUsersDetailPK))
		{
			assetUsersMaster = setAssetUsersDetail(lMaster); 
			assetUsersMaster.setId(assetUsersDetailPK);
			assetUsersDetailsAdminRepo.save(assetUsersMaster);
		}
		}
	}

	public void delAllAssetUsersDetails()
	{
		assetUsersDetailsAdminRepo.deleteAll();
	}

	public void delSelectDetails(ArrayList<AssetUsersDetailPK> seqNos) 
	{
		
		if(seqNos!=null)
		{			
		assetUsersDetailsAdminRepo.deleteAllById(seqNos);
		
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
		assetUsersDetailsAdminRepo.delDetailsBetweenTimes(ts_Fr, ts_To);		
		return;		
	}


	private ArrayList<AssetUsersDetail_DTO> getAssetUsersDetailDtos(ArrayList<AssetUsersDetail> lMasters) {
		AssetUsersDetail_DTO lDTO = null;		
		ArrayList<AssetUsersDetail_DTO> lMasterDTOs = new ArrayList<AssetUsersDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = getAssetUsersDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetUsersDetail_DTO getAssetUsersDetail_DTO(AssetUsersDetail lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetUsersDetail_DTO lDTO = new AssetUsersDetail_DTO();		
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setFrDttm(formatter.format(lMaster.getId().getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getId().getToDttm().toLocalDateTime()));
		lDTO.setPartySeqNo(lMaster.getId().getPartySeqNo());		
		return lDTO;
	}

	private AssetUsersDetail setAssetUsersDetail(AssetUsersDetail_DTO lDTO) {
		AssetUsersDetail lMaster = new AssetUsersDetail();
		AssetUsersDetailPK assetUsersDetailPK = new AssetUsersDetailPK();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;	
		dateFr = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		dateTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetUsersDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetUsersDetailPK.setFrDttm(ts_Fr);
		assetUsersDetailPK.setToDttm(ts_To);
		assetUsersDetailPK.setPartySeqNo(lDTO.getPartySeqNo());		
		lMaster.setId(assetUsersDetailPK);
		return lMaster;
	}
	
}