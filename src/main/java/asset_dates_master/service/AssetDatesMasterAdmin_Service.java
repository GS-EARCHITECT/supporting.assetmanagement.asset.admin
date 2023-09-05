package asset_dates_master.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_dates_master.model.dto.AssetDatesMaster_DTO;
import asset_dates_master.model.master.AssetDatesMaster;
import asset_dates_master.model.repo.AssetDatesMasterAdmin_Repo;

@Service("assetDatesMastersAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetDatesMasterAdmin_Service implements I_AssetDatesMasterAdmin_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetDatesMastersService.class);

	@Autowired
	private AssetDatesMasterAdmin_Repo assetDatesMasterAdminRepo;

	public AssetDatesMaster_DTO newAssetDatesMaster(AssetDatesMaster_DTO lMaster) {
		AssetDatesMaster_DTO assetDatesMasters2 = null;

		if (!assetDatesMasterAdminRepo.existsById(lMaster.getDateSeqNo())) {
			assetDatesMasters2 = getAssetDatesMaster_DTO(assetDatesMasterAdminRepo.save(setAssetDatesMaster(lMaster)));
			lMaster = (assetDatesMasters2);
		}
		return lMaster;
	}

	public ArrayList<AssetDatesMaster_DTO> getAllAssetDatesMasters() {
		ArrayList<AssetDatesMaster> assetDatesMasters = (ArrayList<AssetDatesMaster>) assetDatesMasterAdminRepo
				.findAll();
		ArrayList<AssetDatesMaster_DTO> lMasterss = assetDatesMasters != null
				? this.getAssetDatesMasterDtos(assetDatesMasters)
				: null;
		return lMasterss;
	}

	public ArrayList<AssetDatesMaster_DTO> getSelectAssetDatesMasters(ArrayList<Long> ids) {
		ArrayList<AssetDatesMaster> assetDatesMasters = (ArrayList<AssetDatesMaster>) assetDatesMasterAdminRepo
				.findAllById(ids);
		ArrayList<AssetDatesMaster_DTO> lMasterss = assetDatesMasters != null
				? this.getAssetDatesMasterDtos(assetDatesMasters)
				: null;
		return lMasterss;
	}

	public void updAssetDatesMaster(AssetDatesMaster_DTO lMaster) {
		AssetDatesMaster assetPriceMaster = null;

		if (lMaster != null) {
			if (assetDatesMasterAdminRepo.existsById(lMaster.getDateSeqNo())) {
				assetPriceMaster = setAssetDatesMaster(lMaster);
				assetPriceMaster.setDateSeqNo(lMaster.getDateSeqNo());
				assetDatesMasterAdminRepo.save(assetPriceMaster);
			}
		}
	}

	public void delAllAssetDatesMasters() {
		assetDatesMasterAdminRepo.deleteAll();
	}

	public void delSelectAssetDatesMasters(ArrayList<Long> seqNos) {

		if (seqNos != null) {
			assetDatesMasterAdminRepo.deleteAllById(seqNos);

		}

	}

	private ArrayList<AssetDatesMaster_DTO> getAssetDatesMasterDtos(ArrayList<AssetDatesMaster> lMasters) {
		AssetDatesMaster_DTO lDTO = null;
		ArrayList<AssetDatesMaster_DTO> lMasterDTOs = new ArrayList<AssetDatesMaster_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getAssetDatesMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetDatesMaster_DTO getAssetDatesMaster_DTO(AssetDatesMaster lMaster) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetDatesMaster_DTO lDTO = new AssetDatesMaster_DTO();
		lDTO.setDateSeqNo(lMaster.getDateSeqNo());
		lDTO.setDateType(lMaster.getDateType());
		return lDTO;
	}

	private AssetDatesMaster setAssetDatesMaster(AssetDatesMaster_DTO lDTO) {
		AssetDatesMaster lMaster = new AssetDatesMaster();
		lMaster.setDateType(lDTO.getDateType());
		return lMaster;
	}

}