package asset_meter_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_UTILITY_DETAILS database table.
 * 
 */
@Entity
@Table(name="ASSET_METER_DETAILS")
public class AssetMeterDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetMeterDetailPK id;

	@Column(name="READING")
	private Float reading;

	public AssetMeterDetail() {
	}

	public AssetMeterDetailPK getId() {
		return this.id;
	}

	public void setId(AssetMeterDetailPK id) {
		this.id = id;
	}

	public Float getReading() {
		return this.reading;
	}

	public void setReading(Float reading) {
		this.reading = reading;
	}

	public AssetMeterDetail(AssetMeterDetailPK id, Float reading) {
		super();
		this.id = id;
		this.reading = reading;
	}

}