package asset_structure_details.model.dto;

import java.io.Serializable;

public class AssetStructureDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3303829174481726596L;
	private Long assetSeqNo;
	private String frDttm;
	private String toDttm;
	private Long parAssetSeqNo;

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

	public Long getParAssetSeqNo() {
		return parAssetSeqNo;
	}

	public void setParAssetSeqNo(Long parAssetSeqNo) {
		this.parAssetSeqNo = parAssetSeqNo;
	}

	public AssetStructureDetail_DTO() {
		super();
	}

	public AssetStructureDetail_DTO(Long assetSeqNo, String frDttm, String toDttm, Long parAssetSeqNo) {
		super();
		this.assetSeqNo = assetSeqNo;
		this.frDttm = frDttm;
		this.toDttm = toDttm;
		this.parAssetSeqNo = parAssetSeqNo;
	}

}