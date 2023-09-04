package asset_users_details.model.dto;

import java.io.Serializable;

public class AssetUsersDetail_DTO implements Serializable 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7767594477989782594L;
	private Long assetSeqNo;	
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
	
	public AssetUsersDetail_DTO() {
		super();
	}

	public AssetUsersDetail_DTO(Long assetSeqNo, Long partySeqNo, String frDttm, String toDttm) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.partySeqNo = partySeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
	}

}