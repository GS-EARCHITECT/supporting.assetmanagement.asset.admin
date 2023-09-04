package asset_price_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 * The primary key class for the ASSET_PRICE_DETAILS database table.
 * 
 */
@Embeddable
public class AssetPriceDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public AssetPriceDetailPK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetPriceDetailPK)) {
			return false;
		}
		AssetPriceDetailPK castOther = (AssetPriceDetailPK) other;
		return (this.assetSeqNo == castOther.assetSeqNo) && this.frDttm.equals(castOther.frDttm)
				&& this.toDttm.equals(castOther.toDttm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		hash = hash * prime + this.frDttm.hashCode();
		hash = hash * prime + this.toDttm.hashCode();

		return hash;
	}

	public AssetPriceDetailPK(Long assetSeqNo, Timestamp frDttm, Timestamp toDttm) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

}