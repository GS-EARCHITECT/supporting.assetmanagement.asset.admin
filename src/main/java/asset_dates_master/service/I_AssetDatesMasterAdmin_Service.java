package asset_dates_master.service;

import java.util.ArrayList;

import asset_dates_master.model.dto.AssetDatesMaster_DTO;

public interface I_AssetDatesMasterAdmin_Service
{
    public AssetDatesMaster_DTO newAssetDatesMaster(AssetDatesMaster_DTO asssetMaintMasterDTO);
    public ArrayList<AssetDatesMaster_DTO> getAllAssetDatesMasters();
    public ArrayList<AssetDatesMaster_DTO> getSelectAssetDatesMasters(ArrayList<Long> seqNos); 
    public void updAssetDatesMaster(AssetDatesMaster_DTO lMaster);
    public void delAllAssetDatesMasters();
    public void delSelectAssetDatesMasters(ArrayList<Long> seqNos);    
}