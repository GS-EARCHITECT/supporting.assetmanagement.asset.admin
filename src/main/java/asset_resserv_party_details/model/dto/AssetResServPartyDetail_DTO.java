package asset_resserv_party_details.model.dto;

import java.io.Serializable;
import javax.persistence.*;

public class AssetResServPartyDetail_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1874588629450476005L;
	private Long ressrvprdSeqNo;
	private Long partySeqNo;
	private Long resourceSeqNo;
	private Long serviceSeqNo;

	public Long getRessrvprdSeqNo() {
		return ressrvprdSeqNo;
	}

	public void setRessrvprdSeqNo(Long ressrvprdSeqNo) {
		this.ressrvprdSeqNo = ressrvprdSeqNo;
	}

	public Long getPartySeqNo() {
		return partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getServiceSeqNo() {
		return serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	public AssetResServPartyDetail_DTO(Long ressrvprdSeqNo, Long partySeqNo, Long resourceSeqNo, Long serviceSeqNo) {
		super();
		this.ressrvprdSeqNo = ressrvprdSeqNo;
		this.partySeqNo = partySeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.serviceSeqNo = serviceSeqNo;
	}

	public AssetResServPartyDetail_DTO() {
		super();
	}

}