package asset_structure_details.service;

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
import asset_structure_details.model.dto.AssetStructureDetail_DTO;
import asset_structure_details.model.master.AssetStructureDetail;
import asset_structure_details.model.master.AssetStructureDetailPK;
import asset_structure_details.model.repo.AssetStructureDetailsAdmin_Repo;

@Service("assetStructureDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetStructureDetailsAdmin_Service implements I_AssetStructureDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetStructureDetailsService.class);
	
	
	@Autowired
    private AssetStructureDetailsAdmin_Repo assetStructureDetailsAdminRepo;
	
	public AssetStructureDetail_DTO newAssetStructureDetail(AssetStructureDetail_DTO lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		AssetStructureDetail assetStructureDetails2 = null;
		AssetStructureDetailPK assetStructureDetailPK = new AssetStructureDetailPK();  		
		assetStructureDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		assetStructureDetailPK.setFrDttm(ts_Fr);
		assetStructureDetailPK.setToDttm(ts_To);
		
		if(!assetStructureDetailsAdminRepo.existsById(assetStructureDetailPK))
		{			
		assetStructureDetails2 = setAssetStructureDetail(lMaster);	
		assetStructureDetails2.setId(assetStructureDetailPK);
		assetStructureDetails2 = assetStructureDetailsAdminRepo.save(assetStructureDetails2);
		lMaster = getAssetStructureDetail_DTO(assetStructureDetails2);
		}
		return lMaster;
	}

	public ArrayList<AssetStructureDetail_DTO> getAllAssetStructureDetails() 
	{
		ArrayList<AssetStructureDetail> assetStructureList =  (ArrayList<AssetStructureDetail>) assetStructureDetailsAdminRepo.findAll();
		ArrayList<AssetStructureDetail_DTO> lMasterss = assetStructureList != null ? this.getAssetStructureDetailDtos(assetStructureList) : null;
		return lMasterss;
	}

	public ArrayList<AssetStructureDetail_DTO> getSelectDetails(ArrayList<AssetStructureDetailPK> seqNos) 
	{
		ArrayList<AssetStructureDetail> assetStructureList =  (ArrayList<AssetStructureDetail>) assetStructureDetailsAdminRepo.findAllById(seqNos);
		ArrayList<AssetStructureDetail_DTO> lMasterss = assetStructureList != null ? this.getAssetStructureDetailDtos(assetStructureList) : null;
		return lMasterss;
	}

	public ArrayList<AssetStructureDetail_DTO> getDetailsBetweenTimes(String fr, String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		Optional<AssetStructureDetail> assetStructureDetails = null;
		AssetStructureDetail assetStructureDetails2 = null;
		ArrayList<AssetStructureDetail> lMasters2 = assetStructureDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetStructureDetail> assetStructureList =  (ArrayList<AssetStructureDetail>) assetStructureDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetStructureDetail_DTO> lMasterss = assetStructureList != null ? this.getAssetStructureDetailDtos(assetStructureList) : null;
		return lMasterss;		
	}
	
	public void updAssetStructureDetail(AssetStructureDetail_DTO lMaster) 
	{
		AssetStructureDetail assetStructureMaster = null;
		
		if(lMaster!=null)
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");	
		AssetStructureDetailPK assetStructureDetailPK = null;	
		assetStructureDetailPK = new AssetStructureDetailPK();
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		assetStructureDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		assetStructureDetailPK.setFrDttm(ts_Fr);
		assetStructureDetailPK.setToDttm(ts_To);		
		
		if (assetStructureDetailsAdminRepo.existsById(assetStructureDetailPK))
		{
			assetStructureMaster = setAssetStructureDetail(lMaster); 
			assetStructureMaster.setId(assetStructureDetailPK);
			assetStructureDetailsAdminRepo.save(assetStructureMaster);
		}
		}
	}

	public void delAllAssetStructureDetails()
	{
		assetStructureDetailsAdminRepo.deleteAll();
	}

	public void delSelectDetails(ArrayList<AssetStructureDetailPK> seqNos) 
	{
		
		if(seqNos!=null)
		{			
		assetStructureDetailsAdminRepo.deleteAllById(seqNos);
		
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
		assetStructureDetailsAdminRepo.delDetailsBetweenTimes(ts_Fr, ts_To);		
		return;		
	}


	private ArrayList<AssetStructureDetail_DTO> getAssetStructureDetailDtos(ArrayList<AssetStructureDetail> lMasters) {
		AssetStructureDetail_DTO lDTO = null;		
		ArrayList<AssetStructureDetail_DTO> lMasterDTOs = new ArrayList<AssetStructureDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = getAssetStructureDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetStructureDetail_DTO getAssetStructureDetail_DTO(AssetStructureDetail lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetStructureDetail_DTO lDTO = new AssetStructureDetail_DTO();		
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setFrDttm(formatter.format(lMaster.getId().getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getId().getToDttm().toLocalDateTime()));
		lDTO.setParAssetSeqNo(lMaster.getId().getParAssetSeqNo());		
		return lDTO;
	}

	private AssetStructureDetail setAssetStructureDetail(AssetStructureDetail_DTO lDTO) {
		AssetStructureDetail lMaster = new AssetStructureDetail();
		AssetStructureDetailPK assetStructureDetailPK = new AssetStructureDetailPK();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;	
		dateFr = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		dateTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetStructureDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetStructureDetailPK.setFrDttm(ts_Fr);
		assetStructureDetailPK.setToDttm(ts_To);
		assetStructureDetailPK.setParAssetSeqNo(lDTO.getParAssetSeqNo());		
		lMaster.setId(assetStructureDetailPK);
		return lMaster;
	}
	
}