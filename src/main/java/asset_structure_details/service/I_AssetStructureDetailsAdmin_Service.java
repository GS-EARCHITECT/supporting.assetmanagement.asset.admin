package asset_structure_details.service;

import java.util.ArrayList;
import asset_structure_details.model.dto.AssetStructureDetail_DTO;
import asset_structure_details.model.master.AssetStructureDetailPK;

public interface I_AssetStructureDetailsAdmin_Service
{
    public AssetStructureDetail_DTO newAssetStructureDetail(AssetStructureDetail_DTO assetStructureDetail_DTO);
    public ArrayList<AssetStructureDetail_DTO> getAllAssetStructureDetails();
    public ArrayList<AssetStructureDetail_DTO> getSelectDetails(ArrayList<AssetStructureDetailPK> seqNos);
    public ArrayList<AssetStructureDetail_DTO> getDetailsBetweenTimes(String fr, String to);
    public void updAssetStructureDetail(AssetStructureDetail_DTO lMaster);
    public void delAllAssetStructureDetails();
    public void delSelectDetails(ArrayList<AssetStructureDetailPK> seqNos);
    public void delSelectDetailsBetweenTimes(String fr, String to);
}