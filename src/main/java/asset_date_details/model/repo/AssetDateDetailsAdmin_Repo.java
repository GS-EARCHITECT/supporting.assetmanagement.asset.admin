package asset_date_details.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asset_date_details.model.master.AssetDateDetail;
import asset_date_details.model.master.AssetDateDetailPK;

@Repository("assetDateDetailsAdminRepo")
public interface AssetDateDetailsAdmin_Repo extends JpaRepository<AssetDateDetail, AssetDateDetailPK> 
{}