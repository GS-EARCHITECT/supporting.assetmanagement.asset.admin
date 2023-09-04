package asset_meter_details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_meter_details.model.dto.AssetMeterDetail_DTO;
import asset_meter_details.model.master.AssetMeterDetail;
import asset_meter_details.model.master.AssetMeterDetailPK;
import asset_meter_details.model.repo.AssetMeterDetailsAdmin_Repo;

@Service("assetMeterDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetMeterDetailsAdmin_Service implements I_AssetMeterDetailsAdmin_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetMeterDetailsService.class);

	@Autowired
	private AssetMeterDetailsAdmin_Repo assetMeterDetailsAdminRepo;

	public AssetMeterDetail_DTO newAssetMeterDetail(AssetMeterDetail_DTO lMaster) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getOnDttm(), formatter);
		Timestamp ts_On = Timestamp.valueOf(dateOn);
		Optional<AssetMeterDetail> assetMeterDetails = null;
		AssetMeterDetail assetMeterDetails2 = null;
		AssetMeterDetailPK assetMeterDetailsPK = new AssetMeterDetailPK();
		assetMeterDetailsPK.setAssetSeqNo(lMaster.getAssetSeqNo());
		assetMeterDetailsPK.setOnDttm(ts_On);
		assetMeterDetails = assetMeterDetailsAdminRepo.findById(assetMeterDetailsPK);

		if (!assetMeterDetails.isPresent()) {
			assetMeterDetails2 = setAssetMeterDetail(lMaster);
			assetMeterDetails2.setId(assetMeterDetailsPK);
			assetMeterDetails2 = assetMeterDetailsAdminRepo.save(assetMeterDetails2);
			lMaster = getAssetMeterDetail_DTO(assetMeterDetails2);
		}
		return lMaster;
	}

	public ArrayList<AssetMeterDetail_DTO> getAllAssetMeterDetails() {
		ArrayList<AssetMeterDetail> assetMeterList = (ArrayList<AssetMeterDetail>) assetMeterDetailsAdminRepo.findAll();
		ArrayList<AssetMeterDetail_DTO> lMasterss = assetMeterList != null
				? this.getAssetMeterDetailDtos(assetMeterList)
				: null;
		return lMasterss;
	}

	public ArrayList<AssetMeterDetail_DTO> getSelectDetails(ArrayList<AssetMeterDetailPK> seqNos) {
		ArrayList<AssetMeterDetail> assetMeterList = (ArrayList<AssetMeterDetail>) assetMeterDetailsAdminRepo
				.findAllById(seqNos);
		ArrayList<AssetMeterDetail_DTO> lMasterss = assetMeterList != null
				? this.getAssetMeterDetailDtos(assetMeterList)
				: null;
		return lMasterss;
	}

	public ArrayList<AssetMeterDetail_DTO> getDetailsBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;
		dateFr = LocalDateTime.parse(fr, formatter);
		dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		ArrayList<AssetMeterDetail> lMasters2 = assetMeterDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetMeterDetail> assetMeterList = (ArrayList<AssetMeterDetail>) assetMeterDetailsAdminRepo
				.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetMeterDetail_DTO> lMasterss = assetMeterList != null
				? this.getAssetMeterDetailDtos(assetMeterList)
				: null;
		return lMasterss;
	}

	public void updAssetMeterDetail(AssetMeterDetail_DTO lMaster) {
		AssetMeterDetail assetMeterMaster = null;
		AssetMeterDetailPK assetMeterDetailsPK = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = null;
		Timestamp ts_On = null;

		if (lMaster != null) {
			assetMeterDetailsPK = new AssetMeterDetailPK();
			assetMeterDetailsPK.setAssetSeqNo(lMaster.getAssetSeqNo());
			dateOn = LocalDateTime.parse(lMaster.getOnDttm(), formatter);
			ts_On = Timestamp.valueOf(dateOn);
			assetMeterDetailsPK.setAssetSeqNo(lMaster.getAssetSeqNo());
			assetMeterDetailsPK.setOnDttm(ts_On);

			if (assetMeterDetailsAdminRepo.existsById(assetMeterDetailsPK)) {
				assetMeterMaster = setAssetMeterDetail(lMaster);
				assetMeterMaster.setId(assetMeterDetailsPK);
				assetMeterDetailsAdminRepo.save(assetMeterMaster);
			}
		}
	}

	public void delAllAssetMeterDetails() {
		assetMeterDetailsAdminRepo.deleteAll();
	}

	public void delSelectDetails(ArrayList<AssetMeterDetailPK> seqNos) {

		if (seqNos != null) {
			assetMeterDetailsAdminRepo.deleteAllById(seqNos);

		}

	}

	public void delSelectDetailsBetweenTimes(String fr, String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;
		dateFr = LocalDateTime.parse(fr, formatter);
		dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetMeterDetailsAdminRepo.delDetailsBetweenTimes(ts_Fr, ts_To);
		return;
	}

	private ArrayList<AssetMeterDetail_DTO> getAssetMeterDetailDtos(ArrayList<AssetMeterDetail> lMasters) {
		AssetMeterDetail_DTO lDTO = null;
		ArrayList<AssetMeterDetail_DTO> lMasterDTOs = new ArrayList<AssetMeterDetail_DTO>();

		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getAssetMeterDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetMeterDetail_DTO getAssetMeterDetail_DTO(AssetMeterDetail lMaster) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetMeterDetail_DTO lDTO = new AssetMeterDetail_DTO();
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setOnDttm(formatter.format(lMaster.getId().getOnDttm().toLocalDateTime()));
		lDTO.setReading(lMaster.getReading());
		return lDTO;
	}

	private AssetMeterDetail setAssetMeterDetail(AssetMeterDetail_DTO lDTO) {
		AssetMeterDetail lMaster = new AssetMeterDetail();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(lDTO.getOnDttm(), formatter);
		Timestamp ts_On = Timestamp.valueOf(dateOn);
		AssetMeterDetailPK assetMeterDetailPK = new AssetMeterDetailPK();
		assetMeterDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetMeterDetailPK.setOnDttm(ts_On);
		lMaster.setId(assetMeterDetailPK);
		lMaster.setReading(lDTO.getReading());
		return lMaster;
	}

}