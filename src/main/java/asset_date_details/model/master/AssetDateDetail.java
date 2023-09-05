package asset_date_details.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the ASSET_DATES_DETAILS database table.
 * 
 */
@Entity
@Table(name = "ASSET_DATE_DETAILS")
public class AssetDateDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetDateDetailPK id;

	@Column(name = "DTTM")
	private Timestamp dttm;

	public AssetDateDetail() {
	}

	public AssetDateDetailPK getId() {
		return this.id;
	}

	public void setId(AssetDateDetailPK id) {
		this.id = id;
	}

	public Timestamp getDttm() {
		return this.dttm;
	}

	public void setDttm(Timestamp dttm) {
		this.dttm = dttm;
	}

	public AssetDateDetail(AssetDateDetailPK id, Timestamp dttm) {
		super();
		this.id = id;
		this.dttm = dttm;
	}

}