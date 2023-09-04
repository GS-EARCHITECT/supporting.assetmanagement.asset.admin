package asset_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_MASTER database table.
 * 
 */
@Entity
@Table(name = "ASSET_MASTER")
public class AssetMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSET_SEQ_NO")
	@SequenceGenerator(name = "ASSET_SEQUENCE_NO", sequenceName = "ASSET_SEQUENCE_NO", allocationSize = 1)
	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "DONEFLAG")
	private Character doneFlag;

	@Column(name = "ASSET")
	private String asset;

	@Column(name = "ASSET_ID")
	private String assetId;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "SPECIFICATION_SEQ_NO")
	private Long specSeqNo;

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getSpecSeqNo() {
		return specSeqNo;
	}

	public void setSpecSeqNo(Long specSeqNo) {
		this.specSeqNo = specSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
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
		AssetMaster other = (AssetMaster) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		return true;
	}

	public AssetMaster() {
		super();
	}

	public AssetMaster(Long assetSeqNo, Character doneFlag, String asset, String assetId, Long resourceSeqNo,
			Long specSeqNo) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.doneFlag = doneFlag;
		this.asset = asset;
		this.assetId = assetId;
		this.resourceSeqNo = resourceSeqNo;
		this.specSeqNo = specSeqNo;
	}

}