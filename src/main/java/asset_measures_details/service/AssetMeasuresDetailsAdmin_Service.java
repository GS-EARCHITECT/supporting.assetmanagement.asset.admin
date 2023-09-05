package asset_measures_details.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_measures_details.model.dto.AssetMeasuresDetail_DTO;
import asset_measures_details.model.master.AssetMeasuresDetail;
import asset_measures_details.model.master.AssetMeasuresDetailPK;
import asset_measures_details.model.repo.AssetMeasuresDetailsAdmin_Repo;

@Service("assetMeasuresDetailsAdminServ")
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMeasuresDetailsAdmin_Service implements I_AssetMeasuresDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetMeasuresDetailsService.class);
	
	
	@Autowired
    private AssetMeasuresDetailsAdmin_Repo assetMeasuresDetailsAdminRepo;
	
	public AssetMeasuresDetail_DTO newAssetMeasuresDetail(AssetMeasuresDetail_DTO lMaster) 
	{
		AssetMeasuresDetail assetMeasuresDetails2 = null;
		AssetMeasuresDetailPK assetMeasuresDetailPK = new AssetMeasuresDetailPK();  		
		assetMeasuresDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		assetMeasuresDetailPK.setQtyUnitSeqNo(lMaster.getQtyUnitSeqNo());		
		
		if(!assetMeasuresDetailsAdminRepo.existsById(assetMeasuresDetailPK))
		{			
		assetMeasuresDetails2 = setAssetMeasuresDetail(lMaster);	
		assetMeasuresDetails2.setId(assetMeasuresDetailPK);
		assetMeasuresDetails2 = assetMeasuresDetailsAdminRepo.save(assetMeasuresDetails2);
		lMaster = getAssetMeasuresDetail_DTO(assetMeasuresDetails2);
		}
		return lMaster;
	}

	public ArrayList<AssetMeasuresDetail_DTO> getAllAssetMeasuresDetails() 
	{
		ArrayList<AssetMeasuresDetail> assetMeasuresList =  (ArrayList<AssetMeasuresDetail>) assetMeasuresDetailsAdminRepo.findAll();
		ArrayList<AssetMeasuresDetail_DTO> lMasterss = assetMeasuresList != null ? this.getAssetMeasuresDetailDtos(assetMeasuresList) : null;
		return lMasterss;
	}

	public ArrayList<AssetMeasuresDetail_DTO> getSelectDetails(ArrayList<AssetMeasuresDetailPK> seqNos) 
	{
		ArrayList<AssetMeasuresDetail> assetMeasuresList =  (ArrayList<AssetMeasuresDetail>) assetMeasuresDetailsAdminRepo.findAllById(seqNos);
		ArrayList<AssetMeasuresDetail_DTO> lMasterss = assetMeasuresList != null ? this.getAssetMeasuresDetailDtos(assetMeasuresList) : null;
		return lMasterss;
	}
	
	public void updAssetMeasuresDetail(AssetMeasuresDetail_DTO lMaster) 
	{
		AssetMeasuresDetail assetMeasuresMaster = null;
		
		if(lMaster!=null)
		{
		AssetMeasuresDetailPK assetMeasuresDetailPK = null;	
		assetMeasuresDetailPK = new AssetMeasuresDetailPK();
		assetMeasuresDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		assetMeasuresDetailPK.setQtyUnitSeqNo(lMaster.getQtyUnitSeqNo());
		
		if (assetMeasuresDetailsAdminRepo.existsById(assetMeasuresDetailPK))
		{
			assetMeasuresMaster = setAssetMeasuresDetail(lMaster); 
			assetMeasuresMaster.setId(assetMeasuresDetailPK);
			assetMeasuresDetailsAdminRepo.save(assetMeasuresMaster);
		}
		}
	}

	public void delAllAssetMeasuresDetails()
	{
		assetMeasuresDetailsAdminRepo.deleteAll();
	}

	public void delSelectDetails(ArrayList<AssetMeasuresDetailPK> seqNos) 
	{
		
		if(seqNos!=null)
		{			
		assetMeasuresDetailsAdminRepo.deleteAllById(seqNos);
		
		}

	}

	private ArrayList<AssetMeasuresDetail_DTO> getAssetMeasuresDetailDtos(ArrayList<AssetMeasuresDetail> lMasters) {
		AssetMeasuresDetail_DTO lDTO = null;		
		ArrayList<AssetMeasuresDetail_DTO> lMasterDTOs = new ArrayList<AssetMeasuresDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = getAssetMeasuresDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetMeasuresDetail_DTO getAssetMeasuresDetail_DTO(AssetMeasuresDetail lMaster) 
	{
		AssetMeasuresDetail_DTO lDTO = new AssetMeasuresDetail_DTO();		
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setQtyUnitSeqNo(lMaster.getId().getQtyUnitSeqNo());
		lDTO.setQty(lMaster.getQty());				
		return lDTO;
	}

	private AssetMeasuresDetail setAssetMeasuresDetail(AssetMeasuresDetail_DTO lDTO) {
		AssetMeasuresDetail lMaster = new AssetMeasuresDetail();
		AssetMeasuresDetailPK assetMeasuresDetailPK = new AssetMeasuresDetailPK();
		assetMeasuresDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetMeasuresDetailPK.setQtyUnitSeqNo(lDTO.getQtyUnitSeqNo());
		lMaster.setId(assetMeasuresDetailPK);
		lMaster.setQty(lDTO.getQty());
		return lMaster;
	}
	
}