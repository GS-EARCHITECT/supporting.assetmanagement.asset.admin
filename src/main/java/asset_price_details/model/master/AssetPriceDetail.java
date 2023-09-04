package asset_price_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_PRICE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "ASSET_PRICE_DETAILS")
public class AssetPriceDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetPriceDetailPK id;

	@Column(name = "PRICE")
	private Float price;

	@Column(name = "PRICE_UNIT_SEQ_NO")
	private Long priceUnitSeqNo;

	public AssetPriceDetail() {
	}

	public AssetPriceDetailPK getId() {
		return this.id;
	}

	public void setId(AssetPriceDetailPK id) {
		this.id = id;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getPriceUnitSeqNo() {
		return this.priceUnitSeqNo;
	}

	public void setPriceUnitSeqNo(Long priceUnitSeqNo) {
		this.priceUnitSeqNo = priceUnitSeqNo;
	}

	public AssetPriceDetail(AssetPriceDetailPK id, Float price, Long priceUnitSeqNo) {
		super();
		this.id = id;
		this.price = price;
		this.priceUnitSeqNo = priceUnitSeqNo;
	}

}