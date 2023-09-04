package asset_users_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the ASSET_USER_DETAILS database table.
 * 
 */
@Embeddable
public class AssetUsersDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public AssetUsersDetailPK() {
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Timestamp getFrDttm() {
		return this.frDttm;
	}

	public void setFrDttm(Timestamp frDttm) {
		this.frDttm = frDttm;
	}

	public Timestamp getToDttm() {
		return this.toDttm;
	}

	public void setToDttm(Timestamp toDttm) {
		this.toDttm = toDttm;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetUsersDetailPK)) {
			return false;
		}
		AssetUsersDetailPK castOther = (AssetUsersDetailPK) other;
		return (this.assetSeqNo == castOther.assetSeqNo) && (this.partySeqNo == castOther.partySeqNo)
				&& this.frDttm.equals(castOther.frDttm) && this.toDttm.equals(castOther.toDttm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.partySeqNo ^ (this.partySeqNo >>> 32)));
		hash = hash * prime + this.frDttm.hashCode();
		hash = hash * prime + this.toDttm.hashCode();

		return hash;
	}

	public AssetUsersDetailPK(Long assetSeqNo, Long partySeqNo, Timestamp frDttm, Timestamp toDttm) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.partySeqNo = partySeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

}