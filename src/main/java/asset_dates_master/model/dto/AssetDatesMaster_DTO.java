package asset_dates_master.model.dto;

import java.io.Serializable;

public class AssetDatesMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6787014570829111290L;
	private Long dateSeqNo;
	private String dateType;

	public Long getDateSeqNo() {
		return dateSeqNo;
	}

	public void setDateSeqNo(Long dateSeqNo) {
		this.dateSeqNo = dateSeqNo;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public AssetDatesMaster_DTO(Long dateSeqNo, String dateType) {
		super();
		this.dateSeqNo = dateSeqNo;
		this.dateType = dateType;
	}

	public AssetDatesMaster_DTO() {
		super();
	}

}