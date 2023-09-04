package asset_meter_details.service;

import java.util.ArrayList;
import asset_meter_details.model.dto.AssetMeterDetail_DTO;
import asset_meter_details.model.master.AssetMeterDetailPK;

public interface I_AssetMeterDetailsAdmin_Service
{
    public AssetMeterDetail_DTO newAssetMeterDetail(AssetMeterDetail_DTO asssetMaintMasterDTO);
    public ArrayList<AssetMeterDetail_DTO> getAllAssetMeterDetails();
    public ArrayList<AssetMeterDetail_DTO> getSelectDetails(ArrayList<AssetMeterDetailPK> seqNos);
    public ArrayList<AssetMeterDetail_DTO> getDetailsBetweenTimes(String fr, String to);
    public void updAssetMeterDetail(AssetMeterDetail_DTO lMaster);
    public void delAllAssetMeterDetails();
    public void delSelectDetails(ArrayList<AssetMeterDetailPK> seqNos);
    public void delSelectDetailsBetweenTimes(String fr, String to);
}