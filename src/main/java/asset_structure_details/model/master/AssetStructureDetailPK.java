package asset_structure_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the ASSET_STRUCTURE_DETAILS database table.
 * 
 */
@Embeddable
public class AssetStructureDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	@Column(name = "PAR_ASSET_SEQ_NO")
	private Long parAssetSeqNo;

	public AssetStructureDetailPK() {
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
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

	public Long getParAssetSeqNo() {
		return this.parAssetSeqNo;
	}

	public void setParAssetSeqNo(Long parAssetSeqNo) {
		this.parAssetSeqNo = parAssetSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetStructureDetailPK)) {
			return false;
		}
		AssetStructureDetailPK castOther = (AssetStructureDetailPK) other;
		return (this.assetSeqNo == castOther.assetSeqNo) && this.frDttm.equals(castOther.frDttm)
				&& this.toDttm.equals(castOther.toDttm) && (this.parAssetSeqNo == castOther.parAssetSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		hash = hash * prime + this.frDttm.hashCode();
		hash = hash * prime + this.toDttm.hashCode();
		hash = hash * prime + ((int) (this.parAssetSeqNo ^ (this.parAssetSeqNo >>> 32)));

		return hash;
	}

	public AssetStructureDetailPK(Long assetSeqNo, Timestamp frDttm, Timestamp toDttm, Long parAssetSeqNo) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
		this.parAssetSeqNo = parAssetSeqNo;
	}

}