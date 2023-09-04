package asset_location_details.model.dto;

import java.io.Serializable;

public class AssetLocationDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5399694616875189790L;
	private Long assetSeqNo;
	private Long locationSeqNo;
	private Long partySeqNo;
	private String frDttm;
	private String toDttm;

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public String getFrDttm() {
		return frDttm;
	}

	public void setFrDttm(String frDttm) {
		this.frDttm = frDttm;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public AssetLocationDetail_DTO() {
		super();
	}

	public AssetLocationDetail_DTO(Long assetSeqNo, Long locationSeqNo, Long partySeqNo, String frDttm, String toDttm) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.partySeqNo = partySeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

}