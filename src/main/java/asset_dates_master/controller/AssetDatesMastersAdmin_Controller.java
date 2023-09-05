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

import asset_dates_master.model.dto.AssetDatesMaster_DTO;
import asset_dates_master.service.I_AssetDatesMasterAdmin_Service;

@RestController
@RequestMapping("/assetDatesMastersAdminMgmt")
public class AssetDatesMastersAdmin_Controller {

	// private static final Logger AssDatesMastersgger =
	// LoggerFactory.getLogger(AssetPrice_AssetPrice_Lontroller.class);

	@Autowired
	private I_AssetDatesMasterAdmin_Service assetDatesMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetDatesMaster_DTO> newAssetPrice(@RequestBody AssetDatesMaster_DTO assetDatesMastersDTO) {
		AssetDatesMaster_DTO assetDatesMastersDTO2 = assetDatesMasterAdminServ
				.newAssetDatesMaster(assetDatesMastersDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetDatesMastersDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssDatesMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetDatesMaster_DTO>> getAllAssetPrice_DatesMasters() {
		ArrayList<AssetDatesMaster_DTO> assetDatesMastersDTOs = assetDatesMasterAdminServ.getAllAssetDatesMasters();
		// AssDatesMastersgger.info("size :"+assetDatesMastersDTOs.size());
		return new ResponseEntity<>(assetDatesMastersDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDatesMasters", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetDatesMaster_DTO>> getSelectAssetPrice_DatesMasters(
			@RequestBody ArrayList<Long> seqNos) {
		ArrayList<AssetDatesMaster_DTO> assetDatesMastersDTOs2 = assetDatesMasterAdminServ
				.getSelectAssetDatesMasters(seqNos);
		return new ResponseEntity<>(assetDatesMastersDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetPrice")
	public void updateAssetPrice(@RequestBody AssetDatesMaster_DTO assetDatesMastersDTO) {
		assetDatesMasterAdminServ.updAssetDatesMaster(assetDatesMastersDTO);
	}

	@DeleteMapping("/delSelectAssDatesMasters")
	public void deleteSelectAssDatesMasters(@RequestBody ArrayList<Long> seqNos) {
		assetDatesMasterAdminServ.delSelectAssetDatesMasters(seqNos);
	}

	@DeleteMapping("/delAllAssDatesMasters")
	public void deleteAllAssetPrice() {
		assetDatesMasterAdminServ.delAllAssetDatesMasters();
	}

}