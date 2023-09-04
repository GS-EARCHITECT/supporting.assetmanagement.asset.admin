package asset_location_details.service;

import java.util.ArrayList;
import asset_location_details.model.dto.AssetLocationDetail_DTO;
import asset_location_details.model.master.AssetLocationDetailPK;

public interface I_AssetLocationDetailsAdmin_Service
{
    public AssetLocationDetail_DTO newAssetLocationDetail(AssetLocationDetail_DTO asssetMaintMasterDTO);
    public ArrayList<AssetLocationDetail_DTO> getAllAssetLocationDetails();
    public ArrayList<AssetLocationDetail_DTO> getSelectDetails(ArrayList<AssetLocationDetailPK> seqNos);
    public ArrayList<AssetLocationDetail_DTO> getDetailsBetweenTimes(String fr, String to);
    public void updAssetLocationDetail(AssetLocationDetail_DTO lMaster);
    public void delAllAssetLocationDetails();
    public void delSelectDetails(ArrayList<AssetLocationDetailPK> seqNos);
    public void delSelectDetailsBetweenTimes(String fr, String to);
}