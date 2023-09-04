package asset_measures_details.controller;

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

import asset_measures_details.model.dto.AssetMeasuresDetail_DTO;
import asset_measures_details.model.master.AssetMeasuresDetailPK;
import asset_measures_details.service.I_AssetMeasuresDetailsAdmin_Service;

@RestController
@RequestMapping("/assetMeasuresDetailsAdminMgmt")
public class AssetMeasuresDetailsAdmin_Controller {

	// private static final Logger AssUtilDetailsgger =
	// LoggerFactory.getLogger(AssetMeasures_AssetMeasures_Lontroller.class);

	@Autowired
	private I_AssetMeasuresDetailsAdmin_Service assetMeasuresDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetMeasuresDetail_DTO> newAssetMeasures(@RequestBody AssetMeasuresDetail_DTO assetMeasuresDetailsDTO) {
		AssetMeasuresDetail_DTO assetMeasuresDetailsDTO2 = assetMeasuresDetailsAdminServ.newAssetMeasuresDetail(assetMeasuresDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetMeasuresDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMeasuresDetail_DTO>> getAllAssetMeasures_Details() {
		ArrayList<AssetMeasuresDetail_DTO> assetMeasuresDetailsDTOs = assetMeasuresDetailsAdminServ.getAllAssetMeasuresDetails();
		// AssUtilDetailsgger.info("size :"+assetMeasuresDetailsDTOs.size());
		return new ResponseEntity<>(assetMeasuresDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMeasuresDetail_DTO>> getSelectAssetMeasures_Details(
			@RequestBody ArrayList<AssetMeasuresDetailPK> seqNos) {
		ArrayList<AssetMeasuresDetail_DTO> assetMeasuresDetailsDTOs2 = assetMeasuresDetailsAdminServ.getSelectDetails(seqNos);
		return new ResponseEntity<>(assetMeasuresDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetMeasures")
	public void updateAssetMeasures(@RequestBody AssetMeasuresDetail_DTO assetMeasuresDetailsDTO) {
		assetMeasuresDetailsAdminServ.updAssetMeasuresDetail(assetMeasuresDetailsDTO);
	}

	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<AssetMeasuresDetailPK> seqNos) {
		assetMeasuresDetailsAdminServ.delSelectDetails(seqNos);
	}

	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetMeasures() {
		assetMeasuresDetailsAdminServ.delAllAssetMeasuresDetails();
	}

}