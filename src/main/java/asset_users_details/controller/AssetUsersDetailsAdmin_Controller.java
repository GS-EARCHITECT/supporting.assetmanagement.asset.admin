package asset_users_details.controller;

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

import asset_users_details.model.dto.AssetUsersDetail_DTO;
import asset_users_details.model.master.AssetUsersDetailPK;
import asset_users_details.service.I_AssetUsersDetailsAdmin_Service;

@RestController
@RequestMapping("/assetUsersDetailsAdminMgmt")
public class AssetUsersDetailsAdmin_Controller {

	// private static final Logger AssUtilDetailsgger =
	// LoggerFactory.getLogger(AssetUsers_AssetUsers_Lontroller.class);

	@Autowired
	private I_AssetUsersDetailsAdmin_Service assetUsersDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetUsersDetail_DTO> newAssetUsers(@RequestBody AssetUsersDetail_DTO assetUsersDetailsDTO) {
		AssetUsersDetail_DTO assetUsersDetailsDTO2 = assetUsersDetailsAdminServ.newAssetUsersDetail(assetUsersDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetUsersDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetUsersDetail_DTO>> getAllAssetUsers_Details() {
		ArrayList<AssetUsersDetail_DTO> assetUsersDetailsDTOs = assetUsersDetailsAdminServ.getAllAssetUsersDetails();
		// AssUtilDetailsgger.info("size :"+assetUsersDetailsDTOs.size());
		return new ResponseEntity<>(assetUsersDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetUsersDetail_DTO>> getSelectAssetUsers_Details(
			@RequestBody ArrayList<AssetUsersDetailPK> seqNos) {
		ArrayList<AssetUsersDetail_DTO> assetUsersDetailsDTOs2 = assetUsersDetailsAdminServ.getSelectDetails(seqNos);
		return new ResponseEntity<>(assetUsersDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getDetailsBetween/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetUsersDetail_DTO>> getDetailsBetweenTimes(@PathVariable String fr,
			@PathVariable String to) {
		ArrayList<AssetUsersDetail_DTO> assetUsersDetailsDTOs2 = assetUsersDetailsAdminServ.getDetailsBetweenTimes(fr, to);
		return new ResponseEntity<>(assetUsersDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetUsers")
	public void updateAssetUsers(@RequestBody AssetUsersDetail_DTO assetUsersDetailsDTO) {
		assetUsersDetailsAdminServ.updAssetUsersDetail(assetUsersDetailsDTO);
	}

	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<AssetUsersDetailPK> seqNos) {
		assetUsersDetailsAdminServ.delSelectDetails(seqNos);
	}

	@DeleteMapping("/delDetailsBetween/{fr}/{to}")
	public void delDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		assetUsersDetailsAdminServ.delSelectDetailsBetweenTimes(fr, to);
		return;
	}

	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetUsers() {
		assetUsersDetailsAdminServ.delAllAssetUsersDetails();
	}

}