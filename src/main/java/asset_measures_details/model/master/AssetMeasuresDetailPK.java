package asset_measures_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ASSET_MEASURES_DETAILS database table.
 * 
 */
@Embeddable
public class AssetMeasuresDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	public AssetMeasuresDetailPK() {
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getQtyUnitSeqNo() {
		return this.qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetMeasuresDetailPK)) {
			return false;
		}
		AssetMeasuresDetailPK castOther = (AssetMeasuresDetailPK) other;
		return (this.assetSeqNo == castOther.assetSeqNo) && (this.qtyUnitSeqNo == castOther.qtyUnitSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.qtyUnitSeqNo ^ (this.qtyUnitSeqNo >>> 32)));

		return hash;
	}

	public AssetMeasuresDetailPK(Long assetSeqNo, Long qtyUnitSeqNo) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

}