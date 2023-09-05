package asset_date_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ASSET_DATES_DETAILS database table.
 * 
 */
@Embeddable
public class AssetDateDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "DATE_SEQ_NO")
	private Long dateSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	public AssetDateDetailPK() {
	}

	public Long getDateSeqNo() {
		return this.dateSeqNo;
	}

	public void setDateSeqNo(Long dateSeqNo) {
		this.dateSeqNo = dateSeqNo;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetDateDetailPK)) {
			return false;
		}
		AssetDateDetailPK castOther = (AssetDateDetailPK) other;
		return (this.dateSeqNo == castOther.dateSeqNo) && (this.assetSeqNo == castOther.assetSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.dateSeqNo ^ (this.dateSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));

		return hash;
	}

	public AssetDateDetailPK(Long dateSeqNo, Long assetSeqNo) {
		super();
		this.dateSeqNo = dateSeqNo;
		this.assetSeqNo = assetSeqNo;
	}

}