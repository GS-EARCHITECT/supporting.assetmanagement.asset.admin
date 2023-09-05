package asset_dates_master.service;

import java.util.ArrayList;

import asset_dates_master.model.dto.AssetDateMaster_DTO;

public interface I_AssetDateMastersAdmin_Service
{
    public AssetDateMaster_DTO newAssetDateMaster(AssetDateMaster_DTO asssetMaintMasterDTO);
    public ArrayList<AssetDateMaster_DTO> getAllAssetDateMasters();
    public ArrayList<AssetDateMaster_DTO> getSelectAssetDateMasters(ArrayList<Long> seqNos); 
    public void updAssetDateMaster(AssetDateMaster_DTO lMaster);
    public void delAllAssetDateMasters();
    public void delSelectAssetDateMasters(ArrayList<Long> seqNos);    
}