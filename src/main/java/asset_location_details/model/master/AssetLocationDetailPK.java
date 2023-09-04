package asset_location_details.model.master;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The primary key class for the ASSET_LOCATION_DETAILS database table.
 * 
 */
@Embeddable
public class AssetLocationDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "FR_DTTM")
	private Timestamp frDttm;

	@Column(name = "TO_DTTM")
	private Timestamp toDttm;

	public AssetLocationDetailPK() {
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getLocationSeqNo() {
		return this.locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetLocationDetailPK other = (AssetLocationDetailPK) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		return true;
	}

	public AssetLocationDetailPK(Long assetSeqNo, Long locationSeqNo, Timestamp frDttm, Timestamp toDttm) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

}