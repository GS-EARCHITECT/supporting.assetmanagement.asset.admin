package asset_resserv_party_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_RESSERV_PARTY_DETAILS database table.
 * 
 */
@Entity
@Table(name = "ASSET_RESSERV_PARTY_DETAILS")
public class AssetResServPartyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSET_RESSERV_SEQUENCE")
	@SequenceGenerator(name = "ASSET_RESSERV_SEQUENCE", sequenceName = "ASSET_RESSERV_SEQUENCE", allocationSize = 1)
	@Column(name = "RESSRVPRD_SEQ_NO")
	private Long ressrvprdSeqNo;

	@Column(name = "PARTY_SEQ_NO")
	private Long partySeqNo;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "SERVICE_SEQ_NO")
	private Long serviceSeqNo;

	public AssetResServPartyDetail() {
	}

	public Long getRessrvprdSeqNo() {
		return this.ressrvprdSeqNo;
	}

	public void setRessrvprdSeqNo(Long ressrvprdSeqNo) {
		this.ressrvprdSeqNo = ressrvprdSeqNo;
	}

	public Long getPartySeqNo() {
		return this.partySeqNo;
	}

	public void setPartySeqNo(Long partySeqNo) {
		this.partySeqNo = partySeqNo;
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getServiceSeqNo() {
		return this.serviceSeqNo;
	}

	public void setServiceSeqNo(Long serviceSeqNo) {
		this.serviceSeqNo = serviceSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partySeqNo == null) ? 0 : partySeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((serviceSeqNo == null) ? 0 : serviceSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetResServPartyDetail other = (AssetResServPartyDetail) obj;
		if (partySeqNo == null) {
			if (other.partySeqNo != null)
				return false;
		} else if (!partySeqNo.equals(other.partySeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (serviceSeqNo == null) {
			if (other.serviceSeqNo != null)
				return false;
		} else if (!serviceSeqNo.equals(other.serviceSeqNo))
			return false;
		return true;
	}

	public AssetResServPartyDetail(Long ressrvprdSeqNo, Long partySeqNo, Long resourceSeqNo, Long serviceSeqNo) {
		super();
		this.ressrvprdSeqNo = ressrvprdSeqNo;
		this.partySeqNo = partySeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.serviceSeqNo = serviceSeqNo;
	}

}