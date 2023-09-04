package asset_users_details.service;

import java.util.ArrayList;

import asset_users_details.model.dto.AssetUsersDetail_DTO;
import asset_users_details.model.master.AssetUsersDetailPK;

public interface I_AssetUsersDetailsAdmin_Service
{
    public AssetUsersDetail_DTO newAssetUsersDetail(AssetUsersDetail_DTO asssetMaintMasterDTO);
    public ArrayList<AssetUsersDetail_DTO> getAllAssetUsersDetails();
    public ArrayList<AssetUsersDetail_DTO> getSelectDetails(ArrayList<AssetUsersDetailPK> seqNos);
    public ArrayList<AssetUsersDetail_DTO> getDetailsBetweenTimes(String fr, String to);
    public void updAssetUsersDetail(AssetUsersDetail_DTO lMaster);
    public void delAllAssetUsersDetails();
    public void delSelectDetails(ArrayList<AssetUsersDetailPK> seqNos);
    public void delSelectDetailsBetweenTimes(String fr, String to);
}