package asset_date_details.controller;

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
import asset_date_details.model.dto.AssetDateDetail_DTO;
import asset_date_details.model.master.AssetDateDetailPK;
import asset_date_details.service.I_AssetDateDetailsAdmin_Service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetDateDetailsAdminMgmt")
public class AssetDateDetailsAdmin_Controller {

	// private static final Logger AssDateDetailsgger =
	// LoggerFactory.getLogger(AssetPrice_AssetPrice_Lontroller.class);

	@Autowired
	private I_AssetDateDetailsAdmin_Service assetDateDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetDateDetail_DTO> newAssetPrice(@RequestBody AssetDateDetail_DTO assetDateDetailsDTO) {
		AssetDateDetail_DTO assetDateDetailsDTO2 = assetDateDetailsAdminServ.newAssetDateDetail(assetDateDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetDateDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssDateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetDateDetail_DTO>> getAllAssetPrice_DateDetails() {
		ArrayList<AssetDateDetail_DTO> assetDateDetailsDTOs = assetDateDetailsAdminServ.getAllAssetDateDetails();
		// AssDateDetailsgger.info("size :"+assetDateDetailsDTOs.size());
		return new ResponseEntity<>(assetDateDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDateDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetDateDetail_DTO>> getSelectAssetPrice_DateDetails(
			@RequestBody ArrayList<AssetDateDetailPK> seqNos) {
		ArrayList<AssetDateDetail_DTO> assetDateDetailsDTOs2 = assetDateDetailsAdminServ
				.getSelectAssetDateDetails(seqNos);
		return new ResponseEntity<>(assetDateDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetPrice")
	public void updateAssetPrice(@RequestBody AssetDateDetail_DTO assetDateDetailsDTO) {
		assetDateDetailsAdminServ.updAssetDateDetail(assetDateDetailsDTO);
	}

	@DeleteMapping("/delSelectAssDateDetails")
	public void deleteSelectAssDateDetails(@RequestBody ArrayList<AssetDateDetailPK> seqNos) {
		assetDateDetailsAdminServ.delSelectAssetDateDetails(seqNos);
	}

	@DeleteMapping("/delAllAssDateDetails")
	public void deleteAllAssetPrice() {
		assetDateDetailsAdminServ.delAllAssetDateDetails();
	}

}