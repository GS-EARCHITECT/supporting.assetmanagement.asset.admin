package asset_dates_master.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import asset_dates_master.model.master.AssetDatesMaster;

@Repository("assetDatesMasterAdminRepo")
public interface AssetDatesMasterAdmin_Repo extends JpaRepository<AssetDatesMaster, Long> 
{}