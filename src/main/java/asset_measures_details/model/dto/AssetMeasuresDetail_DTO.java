package asset_measures_details.model.dto;

import java.io.Serializable;

public class AssetMeasuresDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3876205650391963189L;

	private Long assetSeqNo;
	private Long qtyUnitSeqNo;
	private Float qty;

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Float getQty() {
		return qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public AssetMeasuresDetail_DTO(Long assetSeqNo, Long qtyUnitSeqNo, Float qty) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.qty = qty;
	}

	public AssetMeasuresDetail_DTO() {
		super();
	}

}