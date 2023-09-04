package asset_price_details.service;

import java.util.ArrayList;

import asset_price_details.model.dto.AssetPriceDetail_DTO;
import asset_price_details.model.master.AssetPriceDetailPK;

public interface I_AssetPriceDetailsAdmin_Service
{
    public AssetPriceDetail_DTO newAssetPriceDetail(AssetPriceDetail_DTO asssetMaintMasterDTO);
    public ArrayList<AssetPriceDetail_DTO> getAllAssetPriceDetails();
    public ArrayList<AssetPriceDetail_DTO> getSelectDetails(ArrayList<AssetPriceDetailPK> seqNos);
    public ArrayList<AssetPriceDetail_DTO> getDetailsBetweenTimes(String fr, String to);
    public void updAssetPriceDetail(AssetPriceDetail_DTO lMaster);
    public void delAllAssetPriceDetails();
    public void delSelectDetails(ArrayList<AssetPriceDetailPK> seqNos);
    public void delSelectDetailsBetweenTimes(String fr, String to);
}