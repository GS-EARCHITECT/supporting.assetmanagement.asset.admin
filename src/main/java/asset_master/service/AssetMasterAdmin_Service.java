package asset_master.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_master.model.dto.AssetMaster_DTO;
import asset_master.model.master.AssetMaster;
import asset_master.model.repo.AssetMasterAdmin_Repo;

@Service("assetMasterAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMasterAdmin_Service implements I_AssetMasterAdmin_Service 
{

	@Autowired
	private AssetMasterAdmin_Repo assetMasterAdminRepo;

	public AssetMaster_DTO newAssetMaster(AssetMaster_DTO lMasters) 
	{
		AssetMaster AssetMaster = assetMasterAdminRepo.save(this.setAssetMaster(lMasters));
		lMasters = getAssetMaster_DTO(AssetMaster);
		return lMasters;
	}

	public ArrayList<AssetMaster_DTO> getAllAssetMasters() 
	{
		ArrayList<AssetMaster> assetList = (ArrayList<AssetMaster>) assetMasterAdminRepo.findAll();
		ArrayList<AssetMaster_DTO> lMasterss = assetList != null ? this.getAssetMaster_DTOs(assetList) : null;
		return lMasterss;
	}

	public ArrayList<AssetMaster_DTO> getSelectAssets(ArrayList<Long> ids)
	{
		ArrayList<AssetMaster> lMasters = (ArrayList<AssetMaster>) assetMasterAdminRepo.findAllById(ids);
		ArrayList<AssetMaster_DTO> assetMaster_DTOs = lMasters != null ? this.getAssetMaster_DTOs(lMasters) : null;
		return assetMaster_DTOs;
	}
   
	public ArrayList<AssetMaster_DTO> getSelectAssetsByResources(ArrayList<Long> resSeqNos)
	{
		ArrayList<AssetMaster> lMasters = assetMasterAdminRepo.getSelectAssetsByResources(resSeqNos);
		ArrayList<AssetMaster_DTO> assetMaster_DTOs = lMasters != null ? this.getAssetMaster_DTOs(lMasters) : null;
		return assetMaster_DTOs;	
	}
	
	public Character getAssetDoneStatus(Long id)
	{
		Character assetStatus = assetMasterAdminRepo.getAssetDoneStatus(id);
		return assetStatus;
	}

	
	public void setAssetDoneStatus(Long id, Character st)
	{
		if(assetMasterAdminRepo.existsById(id))
		{
		assetMasterAdminRepo.setAssetDone(id, st);		
		}
		return;
	}
	
	public void updAssetMaster(AssetMaster_DTO lMaster) 
	{
		AssetMaster assetMaster = this.setAssetMaster(lMaster);
		if (assetMasterAdminRepo.existsById(lMaster.getAssetSeqNo())) 
				{		
			assetMaster.setAssetSeqNo(lMaster.getAssetSeqNo());			
			assetMasterAdminRepo.save(assetMaster);			
		}
		return;
	}

	public void delAllAssetMasters() {
		assetMasterAdminRepo.deleteAll();
	}

	public void delSelectAssets(ArrayList<Long> assetSeqNos) {
		if (assetSeqNos != null) {
			assetMasterAdminRepo.deleteAllById(assetSeqNos);
		}
	}

	public void delSelectAssetsByResources(ArrayList<Long> ids)
	{
		if (ids != null) 
		{
			assetMasterAdminRepo.delSelectAssetsByResources(ids);
		}
	}
	
	private ArrayList<AssetMaster_DTO> getAssetMaster_DTOs(ArrayList<AssetMaster> lMasters) {
		AssetMaster_DTO lDTO = null;
		ArrayList<AssetMaster_DTO> lMasterDTOs = new ArrayList<AssetMaster_DTO>();		
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getAssetMaster_DTO(lMasters.get(i));			
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetMaster_DTO getAssetMaster_DTO(AssetMaster lMaster) 
	{		
		AssetMaster_DTO lDTO = new AssetMaster_DTO();
		lDTO.setDoneFlag(lMaster.getDoneFlag());
		lDTO.setAssetSeqNo(lMaster.getAssetSeqNo());
		lDTO.setAsset(lMaster.getAsset());
		lDTO.setAssetId(lMaster.getAssetId());
		lDTO.setResourceSeqNo(lMaster.getResourceSeqNo());
		lDTO.setSpecSeqNo(lMaster.getSpecSeqNo());
		return lDTO;
	}

	private AssetMaster setAssetMaster(AssetMaster_DTO lDTO) {
		AssetMaster lMaster = new AssetMaster();				
		lMaster.setDoneFlag(lDTO.getDoneFlag());		
		lMaster.setAsset(lDTO.getAsset());
		lMaster.setAssetId(lDTO.getAssetId());
		lMaster.setResourceSeqNo(lDTO.getResourceSeqNo());
		lMaster.setSpecSeqNo(lDTO.getSpecSeqNo());		
		return lMaster;
	}
}