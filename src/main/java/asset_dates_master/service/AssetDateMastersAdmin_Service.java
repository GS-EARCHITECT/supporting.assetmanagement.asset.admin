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
import asset_dates_master.model.dto.AssetDateMaster_DTO;
import asset_dates_master.model.master.AssetDateMaster;
import asset_dates_master.model.repo.AssetDateMastersAdmin_Repo;

@Service("assetDateMastersAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetDateMastersAdmin_Service implements I_AssetDateMastersAdmin_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetDateMastersService.class);

	@Autowired
	private AssetDateMastersAdmin_Repo assetDateMastersAdminRepo;

	public AssetDateMaster_DTO newAssetDateMaster(AssetDateMaster_DTO lMaster) {
		AssetDateMaster_DTO assetDateMasters2 = null;

		if (!assetDateMastersAdminRepo.existsById(lMaster.getDateSeqNo())) {
			assetDateMasters2 = getAssetDateMaster_DTO(assetDateMastersAdminRepo.save(setAssetDateMaster(lMaster)));
			lMaster = (assetDateMasters2);
		}
		return lMaster;
	}

	public ArrayList<AssetDateMaster_DTO> getAllAssetDateMasters() {
		ArrayList<AssetDateMaster> assetDateMasters = (ArrayList<AssetDateMaster>) assetDateMastersAdminRepo
				.findAll();
		ArrayList<AssetDateMaster_DTO> lMasterss = assetDateMasters != null
				? this.getAssetDateMasterDtos(assetDateMasters)
				: null;
		return lMasterss;
	}

	public ArrayList<AssetDateMaster_DTO> getSelectAssetDateMasters(ArrayList<Long> ids) {
		ArrayList<AssetDateMaster> assetDateMasters = (ArrayList<AssetDateMaster>) assetDateMastersAdminRepo
				.findAllById(ids);
		ArrayList<AssetDateMaster_DTO> lMasterss = assetDateMasters != null
				? this.getAssetDateMasterDtos(assetDateMasters)
				: null;
		return lMasterss;
	}

	public void updAssetDateMaster(AssetDateMaster_DTO lMaster) {
		AssetDateMaster assetPriceMaster = null;

		if (lMaster != null) {
			if (assetDateMastersAdminRepo.existsById(lMaster.getDateSeqNo())) {
				assetPriceMaster = setAssetDateMaster(lMaster);
				assetPriceMaster.setDateSeqNo(lMaster.getDateSeqNo());
				assetDateMastersAdminRepo.save(assetPriceMaster);
			}
		}
	}

	public void delAllAssetDateMasters() {
		assetDateMastersAdminRepo.deleteAll();
	}

	public void delSelectAssetDateMasters(ArrayList<Long> seqNos) {

		if (seqNos != null) {
			assetDateMastersAdminRepo.deleteAllById(seqNos);

		}

	}

	private ArrayList<AssetDateMaster_DTO> getAssetDateMasterDtos(ArrayList<AssetDateMaster> lMasters) {
		AssetDateMaster_DTO lDTO = null;
		ArrayList<AssetDateMaster_DTO> lMasterDTOs = new ArrayList<AssetDateMaster_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getAssetDateMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetDateMaster_DTO getAssetDateMaster_DTO(AssetDateMaster lMaster) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetDateMaster_DTO lDTO = new AssetDateMaster_DTO();
		lDTO.setDateSeqNo(lMaster.getDateSeqNo());
		lDTO.setDateType(lMaster.getDateType());
		return lDTO;
	}

	private AssetDateMaster setAssetDateMaster(AssetDateMaster_DTO lDTO) {
		AssetDateMaster lMaster = new AssetDateMaster();
		lMaster.setDateType(lDTO.getDateType());
		return lMaster;
	}

}