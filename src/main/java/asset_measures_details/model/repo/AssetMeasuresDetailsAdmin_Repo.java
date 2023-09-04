package asset_measures_details.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asset_measures_details.model.master.AssetMeasuresDetail;
import asset_measures_details.model.master.AssetMeasuresDetailPK;

@Repository("assetMeasuresDetailsAdminRepo")
public interface AssetMeasuresDetailsAdmin_Repo extends JpaRepository<AssetMeasuresDetail, AssetMeasuresDetailPK> 
{}