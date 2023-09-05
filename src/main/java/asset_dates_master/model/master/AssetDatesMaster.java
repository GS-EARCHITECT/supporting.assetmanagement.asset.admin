package asset_dates_master.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_DATES_MASTER database table.
 * 
 */
@Entity
@Table(name = "ASSET_DATES_MASTER")
public class AssetDatesMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSET_date_SEQUENCE")
	@SequenceGenerator(name = "ASSET_date_SEQUENCE", sequenceName = "ASSET_date_SEQUENCE", allocationSize = 1)
	@Column(name = "DATE_SEQ_NO")
	private Long dateSeqNo;

	@Column(name = "DATE_TYPE")
	private String dateType;

	public AssetDatesMaster() {
	}

	public Long getDateSeqNo() {
		return this.dateSeqNo;
	}

	public void setDateSeqNo(Long dateSeqNo) {
		this.dateSeqNo = dateSeqNo;
	}

	public String getDateType() {
		return this.dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateSeqNo == null) ? 0 : dateSeqNo.hashCode());
		result = prime * result + ((dateType == null) ? 0 : dateType.hashCode());
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
		AssetDatesMaster other = (AssetDatesMaster) obj;
		if (dateSeqNo == null) {
			if (other.dateSeqNo != null)
				return false;
		} else if (!dateSeqNo.equals(other.dateSeqNo))
			return false;
		if (dateType == null) {
			if (other.dateType != null)
				return false;
		} else if (!dateType.equals(other.dateType))
			return false;
		return true;
	}

	public AssetDatesMaster(Long dateSeqNo, String dateType) {
		super();
		this.dateSeqNo = dateSeqNo;
		this.dateType = dateType;
	}

}