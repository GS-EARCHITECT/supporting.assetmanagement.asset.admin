package asset_structure_details.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the ASSET_STRUCTURE_DETAILS database table.
 * 
 */
@Entity
@Table(name = "ASSET_STRUCTURE_DETAILS")
public class AssetStructureDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetStructureDetailPK id;

	public AssetStructureDetail() {
	}

	public AssetStructureDetailPK getId() {
		return this.id;
	}

	public void setId(AssetStructureDetailPK id) {
		this.id = id;
	}

	public AssetStructureDetail(AssetStructureDetailPK id) {
		super();
		this.id = id;
	}

}