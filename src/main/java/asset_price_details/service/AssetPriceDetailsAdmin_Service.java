package asset_price_details.service;

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
import asset_price_details.model.dto.AssetPriceDetail_DTO;
import asset_price_details.model.master.AssetPriceDetail;
import asset_price_details.model.master.AssetPriceDetailPK;
import asset_price_details.model.repo.AssetPriceDetailsAdmin_Repo;

@Service("assetPriceDetailsAdminServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class AssetPriceDetailsAdmin_Service implements I_AssetPriceDetailsAdmin_Service 
{
	//private static final Logger logger = LoggerFactory.getLogger(AssetPriceDetailsService.class);
	
	
	@Autowired
    private AssetPriceDetailsAdmin_Repo assetPriceDetailsAdminRepo;
	
	public AssetPriceDetail_DTO newAssetPriceDetail(AssetPriceDetail_DTO lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		AssetPriceDetail assetPriceDetails2 = null;
		AssetPriceDetailPK assetPriceDetailPK = new AssetPriceDetailPK();  		
		assetPriceDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		assetPriceDetailPK.setFrDttm(ts_Fr);
		assetPriceDetailPK.setToDttm(ts_To);
		
		if(!assetPriceDetailsAdminRepo.existsById(assetPriceDetailPK))
		{			
		assetPriceDetails2 = setAssetPriceDetail(lMaster);	
		assetPriceDetails2.setId(assetPriceDetailPK);
		assetPriceDetails2 = assetPriceDetailsAdminRepo.save(assetPriceDetails2);
		lMaster = getAssetPriceDetail_DTO(assetPriceDetails2);
		}
		return lMaster;
	}

	public ArrayList<AssetPriceDetail_DTO> getAllAssetPriceDetails() 
	{
		ArrayList<AssetPriceDetail> assetPriceList =  (ArrayList<AssetPriceDetail>) assetPriceDetailsAdminRepo.findAll();
		ArrayList<AssetPriceDetail_DTO> lMasterss = assetPriceList != null ? this.getAssetPriceDetailDtos(assetPriceList) : null;
		return lMasterss;
	}

	public ArrayList<AssetPriceDetail_DTO> getSelectDetails(ArrayList<AssetPriceDetailPK> seqNos) 
	{
		ArrayList<AssetPriceDetail> assetPriceList =  (ArrayList<AssetPriceDetail>) assetPriceDetailsAdminRepo.findAllById(seqNos);
		ArrayList<AssetPriceDetail_DTO> lMasterss = assetPriceList != null ? this.getAssetPriceDetailDtos(assetPriceList) : null;
		return lMasterss;
	}

	public ArrayList<AssetPriceDetail_DTO> getDetailsBetweenTimes(String fr, String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateOn = LocalDateTime.parse(fr, formatter);
		LocalDateTime dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		Optional<AssetPriceDetail> assetPriceDetails = null;
		AssetPriceDetail assetPriceDetails2 = null;
		ArrayList<AssetPriceDetail> lMasters2 = assetPriceDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetPriceDetail> assetPriceList =  (ArrayList<AssetPriceDetail>) assetPriceDetailsAdminRepo.getDetailsBetweenTimes(ts_Fr, ts_To);
		ArrayList<AssetPriceDetail_DTO> lMasterss = assetPriceList != null ? this.getAssetPriceDetailDtos(assetPriceList) : null;
		return lMasterss;		
	}
	
	public void updAssetPriceDetail(AssetPriceDetail_DTO lMaster) 
	{
		AssetPriceDetail assetPriceMaster = null;
		
		if(lMaster!=null)
		{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");	
		AssetPriceDetailPK assetPriceDetailPK = null;	
		assetPriceDetailPK = new AssetPriceDetailPK();
		LocalDateTime dateOn = LocalDateTime.parse(lMaster.getFrDttm(), formatter);
		LocalDateTime dateTo = LocalDateTime.parse(lMaster.getToDttm(), formatter);
		assetPriceDetailPK.setAssetSeqNo(lMaster.getAssetSeqNo());		
		Timestamp ts_Fr = Timestamp.valueOf(dateOn);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		assetPriceDetailPK.setFrDttm(ts_Fr);
		assetPriceDetailPK.setToDttm(ts_To);		
		
		if (assetPriceDetailsAdminRepo.existsById(assetPriceDetailPK))
		{
			assetPriceMaster = setAssetPriceDetail(lMaster); 
			assetPriceMaster.setId(assetPriceDetailPK);
			assetPriceDetailsAdminRepo.save(assetPriceMaster);
		}
		}
	}

	public void delAllAssetPriceDetails()
	{
		assetPriceDetailsAdminRepo.deleteAll();
	}

	public void delSelectDetails(ArrayList<AssetPriceDetailPK> seqNos) 
	{
		
		if(seqNos!=null)
		{			
		assetPriceDetailsAdminRepo.deleteAllById(seqNos);
		
		}

	}
	
	public void delSelectDetailsBetweenTimes(String fr, String to) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;	
		dateFr = LocalDateTime.parse(fr, formatter);
		dateTo = LocalDateTime.parse(to, formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);		
		assetPriceDetailsAdminRepo.delDetailsBetweenTimes(ts_Fr, ts_To);		
		return;		
	}


	private ArrayList<AssetPriceDetail_DTO> getAssetPriceDetailDtos(ArrayList<AssetPriceDetail> lMasters) {
		AssetPriceDetail_DTO lDTO = null;		
		ArrayList<AssetPriceDetail_DTO> lMasterDTOs = new ArrayList<AssetPriceDetail_DTO>();
		
		for (int i = 0; i < lMasters.size(); i++)
		{
			lDTO = getAssetPriceDetail_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetPriceDetail_DTO getAssetPriceDetail_DTO(AssetPriceDetail lMaster) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		AssetPriceDetail_DTO lDTO = new AssetPriceDetail_DTO();		
		lDTO.setAssetSeqNo(lMaster.getId().getAssetSeqNo());
		lDTO.setFrDttm(formatter.format(lMaster.getId().getFrDttm().toLocalDateTime()));
		lDTO.setToDttm(formatter.format(lMaster.getId().getToDttm().toLocalDateTime()));
		lDTO.setPrice(lMaster.getPrice());
		lDTO.setPriceUnitSeqNo(lMaster.getPriceUnitSeqNo());
		return lDTO;
	}

	private AssetPriceDetail setAssetPriceDetail(AssetPriceDetail_DTO lDTO) {
		AssetPriceDetail lMaster = new AssetPriceDetail();
		AssetPriceDetailPK assetPriceDetailPK = new AssetPriceDetailPK();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime dateFr = null;
		LocalDateTime dateTo = null;	
		dateFr = LocalDateTime.parse(lDTO.getFrDttm(), formatter);
		dateTo = LocalDateTime.parse(lDTO.getToDttm(), formatter);
		Timestamp ts_Fr = Timestamp.valueOf(dateFr);
		Timestamp ts_To = Timestamp.valueOf(dateTo);
		assetPriceDetailPK.setAssetSeqNo(lDTO.getAssetSeqNo());
		assetPriceDetailPK.setFrDttm(ts_Fr);
		assetPriceDetailPK.setToDttm(ts_To);
		lMaster.setPrice(lDTO.getPrice());
		lMaster.setPriceUnitSeqNo(lDTO.getPriceUnitSeqNo());
		lMaster.setId(assetPriceDetailPK);
		return lMaster;
	}
	
}