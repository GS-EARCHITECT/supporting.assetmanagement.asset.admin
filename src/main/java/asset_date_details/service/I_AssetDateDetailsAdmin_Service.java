package asset_date_details.service;

import java.util.ArrayList;

import asset_date_details.model.dto.AssetDateDetail_DTO;
import asset_date_details.model.master.AssetDateDetailPK;

public interface I_AssetDateDetailsAdmin_Service
{
    public AssetDateDetail_DTO newAssetDateDetail(AssetDateDetail_DTO asssetMaintDetailsDTO);
    public ArrayList<AssetDateDetail_DTO> getAllAssetDateDetails();
    public ArrayList<AssetDateDetail_DTO> getSelectAssetDateDetails(ArrayList<AssetDateDetailPK> seqNos); 
    public void updAssetDateDetail(AssetDateDetail_DTO lDetails);
    public void delAllAssetDateDetails();
    public void delSelectAssetDateDetails(ArrayList<AssetDateDetailPK> seqNos);    
}