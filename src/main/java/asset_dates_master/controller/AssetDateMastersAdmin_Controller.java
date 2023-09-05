package asset_dates_master.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import asset_dates_master.model.dto.AssetDateMaster_DTO;
import asset_dates_master.service.I_AssetDateMastersAdmin_Service;

@RestController
@RequestMapping("/assetDateMastersAdminMgmt")
public class AssetDateMastersAdmin_Controller {

	// private static final Logger AssDateMastersgger =
	// LoggerFactory.getLogger(AssetPrice_AssetPrice_Lontroller.class);

	@Autowired
	private I_AssetDateMastersAdmin_Service assetDateMastersAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetDateMaster_DTO> newAssetPrice(@RequestBody AssetDateMaster_DTO assetDateMastersDTO) {
		AssetDateMaster_DTO assetDateMastersDTO2 = assetDateMastersAdminServ
				.newAssetDateMaster(assetDateMastersDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetDateMastersDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssDateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetDateMaster_DTO>> getAllAssetPrice_DateMasters() {
		ArrayList<AssetDateMaster_DTO> assetDateMastersDTOs = assetDateMastersAdminServ.getAllAssetDateMasters();
		// AssDateMastersgger.info("size :"+assetDateMastersDTOs.size());
		return new ResponseEntity<>(assetDateMastersDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDateMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetDateMaster_DTO>> getSelectAssetPrice_DateMasters(
			@RequestBody ArrayList<Long> seqNos) {
		ArrayList<AssetDateMaster_DTO> assetDateMastersDTOs2 = assetDateMastersAdminServ
				.getSelectAssetDateMasters(seqNos);
		return new ResponseEntity<>(assetDateMastersDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetPrice")
	public void updateAssetPrice(@RequestBody AssetDateMaster_DTO assetDateMastersDTO) {
		assetDateMastersAdminServ.updAssetDateMaster(assetDateMastersDTO);
	}

	@DeleteMapping("/delSelectAssDateMasters")
	public void deleteSelectAssDateMasters(@RequestBody ArrayList<Long> seqNos) {
		assetDateMastersAdminServ.delSelectAssetDateMasters(seqNos);
	}

	@DeleteMapping("/delAllAssDateMasters")
	public void deleteAllAssetPrice() {
		assetDateMastersAdminServ.delAllAssetDateMasters();
	}

}