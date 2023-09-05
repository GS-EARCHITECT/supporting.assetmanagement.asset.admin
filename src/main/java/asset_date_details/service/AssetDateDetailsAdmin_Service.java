package asset_date_details.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import asset_date_details.model.dto.AssetDateDetail_DTO;
import asset_date_details.model.master.AssetDateDetail;
import asset_date_details.model.master.AssetDateDetailPK;
import asset_date_details.model.repo.AssetDateDetailsAdmin_Repo;

@Service("assetDateDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetDateDetailsAdmin_Service implements I_AssetDateDetailsAdmin_Service {
	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetDateDetailsService.class);

	@Autowired
	private AssetDateDetailsAdmin_Repo assetDateDetailsAdminRepo;

	public AssetDateDetail_DTO newAssetDateDetail(AssetDateDetail_DTO lDetail) {
		AssetDateDetail_DTO assetDateDetails2 = null;
		AssetDateDetailPK assetDateDetailPK = new AssetDateDetailPK();
		assetDateDetailPK.setAssetSeqNo(lDetail.getAssetSeqNo());
		assetDateDetailPK.setDateSeqNo(lDetail.getDateSeqNo());

		if (!assetDateDetailsAdminRepo.existsById(assetDateDetailPK)) {
			assetDateDetails2 = getAssetDateDetail_DTO(assetDateDetailsAdminRepo.save(setAssetDateDetail(lDetail)));
			lDetail = (assetDateDetails2);
		}
		return lDetail;
	}

	public ArrayList<AssetDateDetail_DTO> getAllAssetDateDetails() {
		ArrayList<AssetDateDetail> assetDateDetails = (ArrayList<AssetDateDetail>) assetDateDetailsAdminRepo.findAll();
		ArrayList<AssetDateDetail_DTO> lDetailss = assetDateDetails != null
				? this.getAssetDateDetailDtos(assetDateDetails)
				: null;
		return lDetailss;
	}

	public ArrayList<AssetDateDetail_DTO> getSelectAssetDateDetails(ArrayList<AssetDateDetailPK> ids) {
		ArrayList<AssetDateDetail> assetDateDetails = (ArrayList<AssetDateDetail>) assetDateDetailsAdminRepo
				.findAllById(ids);
		ArrayList<AssetDateDetail_DTO> lDetailss = assetDateDetails != null
				? this.getAssetDateDetailDtos(assetDateDetails)
				: null;
		return lDetailss;
	}

	public void updAssetDateDetail(AssetDateDetail_DTO lDetail) {
		AssetDateDetail assetPriceDetail = null;
		AssetDateDetailPK assetDateDetailPK = new AssetDateDetailPK();
		assetDateDetailPK.setAssetSeqNo(lDetail.getAssetSeqNo());
		assetDateDetailPK.setDateSeqNo(lDetail.getDateSeqNo());

		if (lDetail != null) {
			if (assetDateDetailsAdminRepo.existsById(assetDateDetailPK)) {
				assetDateDetailsAdminRepo.save(assetPriceDetail);
			}
		}
	}

	public void delAllAssetDateDetails() {
		assetDateDetailsAdminRepo.deleteAll();
	}

	public void delSelectAssetDateDetails(ArrayList<AssetDateDetailPK> seqNos) {

		if (seqNos != null) {
			assetDateDetailsAdminRepo.deleteAllById(seqNos);
		}

	}

	private ArrayList<AssetDateDetail_DTO> getAssetDateDetailDtos(ArrayList<AssetDateDetail> lDetails) {
		AssetDateDetail_DTO lDTO = null;
		ArrayList<AssetDateDetail_DTO> lDetailDTOs = new ArrayList<AssetDateDetail_DTO>();

		for (int i = 0; i < lDetails.size(); i++) {
			lDTO = getAssetDateDetail_DTO(lDetails.get(i));
			lDetailDTOs.add(lDTO);
		}
		return lDetailDTOs;
	}

	private AssetDateDetail_DTO getAssetDateDetail_DTO(AssetDateDetail lDetail) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetDateDetail_DTO lDTO = new AssetDateDetail_DTO();
		lDTO.setDateSeqNo(lDetail.getId().getDateSeqNo());
		lDTO.setAssetSeqNo(lDetail.getId().getAssetSeqNo());
		lDTO.setDttm(formatter.format(lDetail.getDttm().toLocalDateTime()));
		return lDTO;
	}

	private AssetDateDetail setAssetDateDetail(AssetDateDetail_DTO lDTO) {
		AssetDateDetail lDetail = new AssetDateDetail();
		AssetDateDetailPK assetDateDetailPK = new AssetDateDetailPK();
		assetDateDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetDateDetailPK.setDateSeqNo(lDTO.getDateSeqNo());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dtTm = LocalDateTime.parse(lDTO.getDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dtTm);
		lDetail.setId(assetDateDetailPK);
		lDetail.setDttm(ts_Fr);
		return lDetail;
	}

}