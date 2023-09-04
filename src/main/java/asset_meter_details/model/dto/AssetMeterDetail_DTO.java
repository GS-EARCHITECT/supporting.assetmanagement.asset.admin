package asset_meter_details.model.dto;

import java.io.Serializable;

public class AssetMeterDetail_DTO implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7446824332924442171L;
	private long assetSeqNo;
	private String onDttm;
	private Float reading;
	
	public long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public String getOnDttm() {
		return onDttm;
	}

	public void setOnDttm(String onDttm) {
		this.onDttm = onDttm;
	}

	public Float getReading() {
		return reading;
	}

	public void setReading(Float reading) {
		this.reading = reading;
	}

		public AssetMeterDetail_DTO(long assetSeqNo, String onDttm, Float reading)
	{
		super();
		this.assetSeqNo = assetSeqNo;
		this.onDttm = onDttm;
		this.reading = reading;	
	}

	public AssetMeterDetail_DTO() {
		super();
	}
}