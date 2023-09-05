package asset_resserv_party_details.service;

import java.util.ArrayList;
import asset_resserv_party_details.model.dto.AssetResServPartyDetail_DTO;

public interface I_AssetResServPartyDetailsAdmin_Service
{
    public AssetResServPartyDetail_DTO newAssetResServPartyDetail(AssetResServPartyDetail_DTO assetResServPartyDetail_DTO);
    public ArrayList<AssetResServPartyDetail_DTO> getAllAssetResServPartyDetails();
    public ArrayList<AssetResServPartyDetail_DTO> getSelectDetails(ArrayList<Long> seqNos);
    public ArrayList<AssetResServPartyDetail_DTO> getDetailsForParties(ArrayList<Long> ids);
    public ArrayList<AssetResServPartyDetail_DTO> getDetailsForResources(ArrayList<Long> ids);
    public ArrayList<AssetResServPartyDetail_DTO> getDetailsForServices(ArrayList<Long> ids);
	public void updAssetResServPartyDetail(AssetResServPartyDetail_DTO lMaster);
    public void delSelectDetails(ArrayList<Long> seqNos);
    public void delDetailsForParties(ArrayList<Long> ids);
    public void delDetailsForResources(ArrayList<Long> ids);
    public void delDetailsForServices(ArrayList<Long> ids);
    public void delAllAssetResServPartyDetails();
}