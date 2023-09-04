package asset_measures_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_MEASURES_DETAILS database table.
 * 
 */
@Entity
@Table(name = "ASSET_MEASURES_DETAILS")
public class AssetMeasuresDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetMeasuresDetailPK id;

	@Column(name = "QTY")
	private Float qty;

	public AssetMeasuresDetail() {
	}

	public AssetMeasuresDetailPK getId() {
		return this.id;
	}

	public void setId(AssetMeasuresDetailPK id) {
		this.id = id;
	}

	public Float getQty() {
		return this.qty;
	}

	public void setQty(Float qty) {
		this.qty = qty;
	}

	public AssetMeasuresDetail(AssetMeasuresDetailPK id, Float qty) {
		super();
		this.id = id;
		this.qty = qty;
	}

}