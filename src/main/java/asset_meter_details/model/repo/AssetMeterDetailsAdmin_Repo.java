package asset_meter_details.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import asset_meter_details.model.master.AssetMeterDetail;
import asset_meter_details.model.master.AssetMeterDetailPK;

@Repository("assetMeterDetailsAdminRepo")
public interface AssetMeterDetailsAdmin_Repo extends JpaRepository<AssetMeterDetail, AssetMeterDetailPK> 
{

	@Query(value = "SELECT * FROM ASSET_UTILITY_DETAILS a WHERE ON_DTTM >= :fr and ON_DTTM <= :to  order by ASSET_SEQ_NO", nativeQuery = true)
	ArrayList<AssetMeterDetail> getDetailsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);

	@Query(value = "delete FROM ASSET_UTILITY_DETAILS a WHERE ON_DTTM >= :fr and ON_DTTM <= :to", nativeQuery = true)
	void delDetailsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);

}