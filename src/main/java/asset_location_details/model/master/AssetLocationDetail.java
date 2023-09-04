package asset_location_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_LOCATION_DETAILS database table.
 * 
 */
@Entity
@Table(name = "ASSET_LOCATION_DETAILS")
public class AssetLocationDetail implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetLocationDetailPK id;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	public AssetLocationDetail() {
	}

	public AssetLocationDetailPK getId() {
		return this.id;
	}

	public void setId(AssetLocationDetailPK id) {
		this.id = id;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public AssetLocationDetail(AssetLocationDetailPK id, java.lang.Long partySeqNo) {
		super();
		this.id = id;
		this.partySeqNo = partySeqNo;
	}

}