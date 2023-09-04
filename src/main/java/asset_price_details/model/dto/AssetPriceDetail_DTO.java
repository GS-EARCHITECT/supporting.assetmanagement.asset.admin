package asset_price_details.model.dto;

import java.io.Serializable;

public class AssetPriceDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2111523276988745373L;
	private Long assetSeqNo;
	private String frDttm;
	private String toDttm;
	private Float price;
	private Long priceUnitSeqNo;

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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getPriceUnitSeqNo() {
		return priceUnitSeqNo;
	}

	public void setPriceUnitSeqNo(Long priceUnitSeqNo) {
		this.priceUnitSeqNo = priceUnitSeqNo;
	}

	public AssetPriceDetail_DTO(Long assetSeqNo, String frDttm, String toDttm, Float price, Long priceUnitSeqNo) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
		this.price = price;
		this.priceUnitSeqNo = priceUnitSeqNo;
	}

	public AssetPriceDetail_DTO() {
		super();
	}

}