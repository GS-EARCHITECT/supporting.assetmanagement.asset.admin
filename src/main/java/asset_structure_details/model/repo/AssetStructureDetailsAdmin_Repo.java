package asset_structure_details.model.repo;

import java.sql.Timestamp;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import asset_structure_details.model.master.AssetStructureDetail;
import asset_structure_details.model.master.AssetStructureDetailPK;

@Repository("assetStructureDetailsAdminRepo")
public interface AssetStructureDetailsAdmin_Repo extends JpaRepository<AssetStructureDetail, AssetStructureDetailPK> 
{

	@Query(value = "SELECT * FROM ASSET_Structure_DETAILS a WHERE ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM))  order by ASSET_SEQ_NO", nativeQuery = true)
	ArrayList<AssetStructureDetail> getDetailsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);
	
	@Query(value = "SELECT * FROM ASSET_Structure_DETAILS a WHERE ((:fr BETWEEN FR_DTTM and TO_DTTM) and (:to BETWEEN FR_DTTM and TO_DTTM))", nativeQuery = true)
	void delDetailsBetweenTimes(@Param("fr") Timestamp fr, @Param("to") Timestamp to);

}