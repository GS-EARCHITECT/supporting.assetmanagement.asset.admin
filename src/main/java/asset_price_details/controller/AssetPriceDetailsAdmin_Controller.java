package asset_price_details.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import asset_price_details.model.dto.AssetPriceDetail_DTO;
import asset_price_details.model.master.AssetPriceDetailPK;
import asset_price_details.service.I_AssetPriceDetailsAdmin_Service;

@RestController
@RequestMapping("/assetPriceDetailsAdminMgmt")
public class AssetPriceDetailsAdmin_Controller {

	// private static final Logger AssUtilDetailsgger =
	// LoggerFactory.getLogger(AssetPrice_AssetPrice_Lontroller.class);

	@Autowired
	private I_AssetPriceDetailsAdmin_Service assetPriceDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetPriceDetail_DTO> newAssetPrice(@RequestBody AssetPriceDetail_DTO assetPriceDetailsDTO) {
		AssetPriceDetail_DTO assetPriceDetailsDTO2 = assetPriceDetailsAdminServ.newAssetPriceDetail(assetPriceDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetPriceDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetPriceDetail_DTO>> getAllAssetPrice_Details() {
		ArrayList<AssetPriceDetail_DTO> assetPriceDetailsDTOs = assetPriceDetailsAdminServ.getAllAssetPriceDetails();
		// AssUtilDetailsgger.info("size :"+assetPriceDetailsDTOs.size());
		return new ResponseEntity<>(assetPriceDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetPriceDetail_DTO>> getSelectAssetPrice_Details(
			@RequestBody ArrayList<AssetPriceDetailPK> seqNos) {
		ArrayList<AssetPriceDetail_DTO> assetPriceDetailsDTOs2 = assetPriceDetailsAdminServ.getSelectDetails(seqNos);
		return new ResponseEntity<>(assetPriceDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getDetailsBetween/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetPriceDetail_DTO>> getDetailsBetweenTimes(@PathVariable String fr,
			@PathVariable String to) {
		ArrayList<AssetPriceDetail_DTO> assetPriceDetailsDTOs2 = assetPriceDetailsAdminServ.getDetailsBetweenTimes(fr, to);
		return new ResponseEntity<>(assetPriceDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetPrice")
	public void updateAssetPrice(@RequestBody AssetPriceDetail_DTO assetPriceDetailsDTO) {
		assetPriceDetailsAdminServ.updAssetPriceDetail(assetPriceDetailsDTO);
	}

	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<AssetPriceDetailPK> seqNos) {
		assetPriceDetailsAdminServ.delSelectDetails(seqNos);
	}

	@DeleteMapping("/delDetailsBetween/{fr}/{to}")
	public void delDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		assetPriceDetailsAdminServ.delSelectDetailsBetweenTimes(fr, to);
		return;
	}

	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetPrice() {
		assetPriceDetailsAdminServ.delAllAssetPriceDetails();
	}

}