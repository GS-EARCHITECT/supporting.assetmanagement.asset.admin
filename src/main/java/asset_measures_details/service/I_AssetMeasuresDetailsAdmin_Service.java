package asset_measures_details.service;

import java.util.ArrayList;
import asset_measures_details.model.dto.AssetMeasuresDetail_DTO;
import asset_measures_details.model.master.AssetMeasuresDetailPK;

public interface I_AssetMeasuresDetailsAdmin_Service
{
    public AssetMeasuresDetail_DTO newAssetMeasuresDetail(AssetMeasuresDetail_DTO assetMeasuresDetail_DTO);
    public ArrayList<AssetMeasuresDetail_DTO> getAllAssetMeasuresDetails();
    public ArrayList<AssetMeasuresDetail_DTO> getSelectDetails(ArrayList<AssetMeasuresDetailPK> seqNos);
    public void updAssetMeasuresDetail(AssetMeasuresDetail_DTO lMaster);
    public void delAllAssetMeasuresDetails();
    public void delSelectDetails(ArrayList<AssetMeasuresDetailPK> seqNos); 
}