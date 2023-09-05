package asset_date_details.model.dto;

import java.io.Serializable;

public class AssetDateDetail_DTO implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8440525546438405733L;
	private Long dateSeqNo;
	private Long assetSeqNo;
	private String dttm;

	public Long getDateSeqNo() {
		return dateSeqNo;
	}

	public void setDateSeqNo(Long dateSeqNo) {
		this.dateSeqNo = dateSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public String getDttm() {
		return dttm;
	}

	public void setDttm(String dttm) {
		this.dttm = dttm;
	}

	public AssetDateDetail_DTO(Long dateSeqNo, Long assetSeqNo, String dttm) {
		super();
		this.dateSeqNo = dateSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.dttm = dttm;
	}

	public AssetDateDetail_DTO() {
		super();
	}

}