package asset_users_details.model.master;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ASSET_USER_DETAILS database table.
 * 
 */
@Entity
@Table(name="ASSET_USER_DETAILS")
public class AssetUsersDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AssetUsersDetailPK id;

	public AssetUsersDetail() {
	}

	public AssetUsersDetailPK getId() {
		return this.id;
	}

	public void setId(AssetUsersDetailPK id) {
		this.id = id;
	}

}