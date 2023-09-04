package asset_master.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import asset_master.model.master.AssetMaster;

@Repository("assetMasterAdminRepo")
public interface AssetMasterAdmin_Repo extends CrudRepository<AssetMaster, Long> {

	@Query(value = "SELECT * FROM ASSET_MASTER a WHERE a.resource_seq_no in :ids order by asset_seq_no", nativeQuery = true)
	ArrayList<AssetMaster> getSelectAssetsByResources(@Param("ids") ArrayList<Long> ids);

	@Query(value = "SELECT doneflag FROM ASSET_MASTER a WHERE a.asset_seq_no = :id", nativeQuery = true)
	Character getAssetDoneStatus(@Param("id") Long id);

	@Query(value = "update ASSET_MASTER set doneflag = :st WHERE a.asset_seq_no = :id", nativeQuery = true)
	void setAssetDone(@Param("id") Long id, @Param("st") Character st);

	@Query(value = "delete FROM ASSET_MASTER a WHERE a.resource_seq_no in :ids", nativeQuery = true)
	void delSelectAssetsByResources(@Param("ids") ArrayList<Long> ids);

}
