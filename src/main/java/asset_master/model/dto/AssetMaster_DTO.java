package asset_master.model.dto;

import java.io.Serializable;

import javax.persistence.Column;

public class AssetMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7763570984911035648L;
	private Long assetSeqNo;
	private String asset;
	private String assetId;
	private Long resourceSeqNo;
	private Long specSeqNo;
	private Character doneFlag;
	private Long partySeqNo;
	
	
	public Character getDoneFlag() {
		return doneFlag;
	}

	public void setDoneFlag(Character doneFlag) {
		this.doneFlag = doneFlag;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
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

	public AssetMaster_DTO() {
		super();
	}


	
}