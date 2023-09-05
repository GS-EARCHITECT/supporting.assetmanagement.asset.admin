package asset_resserv_party_details.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_resserv_party_details.model.dto.AssetResServPartyDetail_DTO;
import asset_resserv_party_details.model.master.AssetResServPartyDetail;
import asset_resserv_party_details.model.repo.AssetResServPartyDetailsAdmin_Repo;

@Service("assetResServPartyDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetResServPartyDetailsAdmin_Service implements I_AssetResServPartyDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetResServPartyDetailsService.class);
	
	
	@Autowired
    private AssetResServPartyDetailsAdmin_Repo assetResServPartyDetailsAdminRepo;
	
	public AssetResServPartyDetail_DTO newAssetResServPartyDetail(AssetResServPartyDetail_DTO lMaster) 
	{
		if(!assetResServPartyDetailsAdminRepo.existsById(lMaster.getRessrvprdSeqNo()))
		{			
		lMaster = getAssetResServPartyDetail_DTO(assetResServPartyDetailsAdminRepo.save(this.setAssetResServPartyDetail(lMaster)));
		}
		return lMaster;
	}

	public ArrayList<AssetResServPartyDetail_DTO> getAllAssetResServPartyDetails() 
	{
		ArrayList<AssetResServPartyDetail> assetResServPartyList =  (ArrayList<AssetResServPartyDetail>) assetResServPartyDetailsAdminRepo.findAll();
		ArrayList<AssetResServPartyDetail_DTO> lMasterss = assetResServPartyList != null ? this.getAssetResServPartyDetailDtos(assetResServPartyList) : null;
		return lMasterss;
	}

	public ArrayList<AssetResServPartyDetail_DTO> getSelectDetails(ArrayList<Long> seqNos) 
	{
		ArrayList<AssetResServPartyDetail> assetResServPartyList =  (ArrayList<AssetResServPartyDetail>) assetResServPartyDetailsAdminRepo.findAllById(seqNos);
		ArrayList<AssetResServPartyDetail_DTO> lMasterss = assetResServPartyList != null ? this.getAssetResServPartyDetailDtos(assetResServPartyList) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetResServPartyDetail_DTO> getDetailsForParties(ArrayList<Long> ids) 
	{
		ArrayList<AssetResServPartyDetail> assetResServPartyList =  assetResServPartyDetailsAdminRepo.getDetailsForParties(ids);
		ArrayList<AssetResServPartyDetail_DTO> lMasterss = assetResServPartyList != null ? this.getAssetResServPartyDetailDtos(assetResServPartyList) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetResServPartyDetail_DTO> getDetailsForResources(ArrayList<Long> ids) 
	{
		ArrayList<AssetResServPartyDetail> assetResServPartyList =  assetResServPartyDetailsAdminRepo.getDetailsForResources(ids);
		ArrayList<AssetResServPartyDetail_DTO> lMasterss = assetResServPartyList != null ? this.getAssetResServPartyDetailDtos(assetResServPartyList) : null;
		return lMasterss;
	}
	
	public ArrayList<AssetResServPartyDetail_DTO> getDetailsForServices(ArrayList<Long> ids) 
	{
		ArrayList<AssetResServPartyDetail> assetResServPartyList =  assetResServPartyDetailsAdminRepo.getDetailsForServices(ids);
		ArrayList<AssetResServPartyDetail_DTO> lMasterss = assetResServPartyList != null ? this.getAssetResServPartyDetailDtos(assetResServPartyList) : null;
		return lMasterss;
	}
	
	public void updAssetResServPartyDetail(AssetResServPartyDetail_DTO lMaster) 
	{
		if(lMaster!=null)
		{		
		if (assetResServPartyDetailsAdminRepo.existsById(lMaster.getRessrvprdSeqNo()))
		{
		assetResServPartyDetailsAdminRepo.save(this.setAssetResServPartyDetail(lMaster)); 
		}
		}
	}
	
	public void delSelectDetails(ArrayList<Long> seqNos) 
	{		
		if(seqNos!=null)
		{			
		assetResServPartyDetailsAdminRepo.deleteAllById(seqNos);		
		}
	}
	
	public void delDetailsForParties(ArrayList<Long> ids) 
	{		
		if(ids!=null)
		{			
		assetResServPartyDetailsAdminRepo.delDetailsForParties(ids);		
		}
	}
	
	public void delDetailsForResources(ArrayList<Long> ids) 
	{		
		if(ids!=null)
		{			
		assetResServPartyDetailsAdminRepo.delDetailsForResources(ids);		
		}
	}

	public void delDetailsForServices(ArrayList<Long> ids) 
	{		
		if(ids!=null)
		{			
		assetResServPartyDetailsAdminRepo.delDetailsForServices(ids);		
		}
	}
	
	public void delAllAssetResServPartyDetails()
	{
		assetResServPartyDetailsAdminRepo.deleteAll();
	}


	private ArrayList<AssetResServPartyDetail_DTO> getAssetResServPartyDetailDtos(ArrayList<AssetResServPartyDetail> lMasters) {
		AssetResServPartyDetail_DTO lDTO = null;		
		ArrayList<AssetResServPartyDetail_DTO> lMasterDTOs = new ArrayList<AssetResServPartyDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = getAssetResServPartyDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetResServPartyDetail_DTO getAssetResServPartyDetail_DTO(AssetResServPartyDetail lMaster) 
	{
		AssetResServPartyDetail_DTO lDTO = new AssetResServPartyDetail_DTO();		
		lDTO.setPartySeqNo(lMaster.getPartySeqNo());
		lDTO.setResourceSeqNo(lMaster.getResourceSeqNo());
		lDTO.setServiceSeqNo(lMaster.getServiceSeqNo());
		lDTO.setRessrvprdSeqNo(lMaster.getRessrvprdSeqNo());
		return lDTO;
	}

	private AssetResServPartyDetail setAssetResServPartyDetail(AssetResServPartyDetail_DTO lDTO) 
	{
		AssetResServPartyDetail lMaster = new AssetResServPartyDetail();
		lMaster.setPartySeqNo(lDTO.getPartySeqNo());
		lMaster.setResourceSeqNo(lDTO.getResourceSeqNo());
		lMaster.setServiceSeqNo(lDTO.getServiceSeqNo());
		return lMaster;
	}
	
}