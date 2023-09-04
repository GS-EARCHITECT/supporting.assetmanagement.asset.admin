package asset_master.service;

import java.util.ArrayList;
import asset_master.model.dto.AssetMaster_DTO;

public interface I_AssetMasterAdmin_Service
{
    public AssetMaster_DTO newAssetMaster(AssetMaster_DTO resourceCategoryMasterDTO);
    public ArrayList<AssetMaster_DTO> getAllAssetMasters();    
    public Character getAssetDoneStatus(Long id);;
    public ArrayList<AssetMaster_DTO> getSelectAssetsByResources(ArrayList<Long> ids);    
    public ArrayList<AssetMaster_DTO> getSelectAssets(ArrayList<Long> ids);
    public void updAssetMaster(AssetMaster_DTO AssetMaster_DTO);
    public void setAssetDoneStatus(Long id, Character st);;
    public void delAllAssetMasters();    
    public void delSelectAssets(ArrayList<Long> ids);
    public void delSelectAssetsByResources(ArrayList<Long> ids);
}