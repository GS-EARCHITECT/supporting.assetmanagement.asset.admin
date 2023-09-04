package asset_meter_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the ASSET_UTILITY_DETAILS database table.
 * 
 */
@Embeddable
public class AssetMeterDetailPK implements Serializable 
{
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "ON_DTTM")
	private Timestamp onDttm;

	public AssetMeterDetailPK() {
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Timestamp getOnDttm() {
		return this.onDttm;
	}

	public void setOnDttm(Timestamp onDttm) {
		this.onDttm = onDttm;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AssetMeterDetailPK)) {
			return false;
		}
		AssetMeterDetailPK castOther = (AssetMeterDetailPK) other;
		return (this.assetSeqNo == castOther.assetSeqNo) && this.onDttm.equals(castOther.onDttm);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));
		hash = hash * prime + this.onDttm.hashCode();

		return hash;
	}

	public AssetMeterDetailPK(Long assetSeqNo, Timestamp onDttm) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.onDttm = onDttm;
	}

}