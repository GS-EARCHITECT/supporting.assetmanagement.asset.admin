package asset_dates_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asset_dates_master.model.master.AssetDateMaster;

@Repository("assetDateMastersAdminRepo")
public interface AssetDateMastersAdmin_Repo extends JpaRepository<AssetDateMaster, Long> 
{}