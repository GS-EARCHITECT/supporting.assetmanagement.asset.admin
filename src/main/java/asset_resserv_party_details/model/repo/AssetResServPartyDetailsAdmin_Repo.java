package asset_resserv_party_details.model.repo;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import asset_resserv_party_details.model.master.AssetResServPartyDetail;

@Repository("assetResServPartyDetailsAdminRepo")
public interface AssetResServPartyDetailsAdmin_Repo extends JpaRepository<AssetResServPartyDetail, Long> 
{
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE party_seq_no in :ids  order by party_SEQ_NO", nativeQuery = true)
	ArrayList<AssetResServPartyDetail> getDetailsForParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE resource_seq_no in :ids  order by resource_SEQ_NO", nativeQuery = true)
	ArrayList<AssetResServPartyDetail> getDetailsForResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "SELECT * FROM ASSET_ResServ_Party_DETAILS a WHERE service_seq_no in :ids  order by service_SEQ_NO", nativeQuery = true)
	ArrayList<AssetResServPartyDetail> getDetailsForServices(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM ASSET_ResServ_Party_DETAILS a WHERE party_seq_no in :ids", nativeQuery = true)
	void delDetailsForParties(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM ASSET_ResServ_Party_DETAILS a WHERE resource_seq_no in :ids", nativeQuery = true)
	void delDetailsForResources(@Param("ids") ArrayList<Long> ids);
	
	@Query(value = "delete FROM ASSET_ResServ_Party_DETAILS a WHERE service_seq_no in :ids", nativeQuery = true)
	void delDetailsForServices(@Param("ids") ArrayList<Long> ids);
	
	
}