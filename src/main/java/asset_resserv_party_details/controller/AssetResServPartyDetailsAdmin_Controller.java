package asset_resserv_party_details.controller;

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

import asset_resserv_party_details.model.dto.AssetResServPartyDetail_DTO;
import asset_resserv_party_details.service.I_AssetResServPartyDetailsAdmin_Service;

@RestController
@RequestMapping("/assetResServPartyDetailsAdminMgmt")
public class AssetResServPartyDetailsAdmin_Controller {

	// private static final Logger AssUtilDetailsgger =
	// LoggerFactory.getLogger(AssetResServParty_AssetResServParty_Lontroller.class);

	@Autowired
	private I_AssetResServPartyDetailsAdmin_Service assetResServPartyDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetResServPartyDetail_DTO> newAssetResServParty(
			@RequestBody AssetResServPartyDetail_DTO assetResServPartyDetailsDTO) {
		AssetResServPartyDetail_DTO assetResServPartyDetailsDTO2 = assetResServPartyDetailsAdminServ
				.newAssetResServPartyDetail(assetResServPartyDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetResServPartyDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetResServPartyDetail_DTO>> getAllAssetResServParty_Details() {
		ArrayList<AssetResServPartyDetail_DTO> assetResServPartyDetailsDTOs = assetResServPartyDetailsAdminServ
				.getAllAssetResServPartyDetails();
		// AssUtilDetailsgger.info("size :"+assetResServPartyDetailsDTOs.size());
		return new ResponseEntity<>(assetResServPartyDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetResServPartyDetail_DTO>> getSelectAssetResServParty_Details(
			@RequestBody ArrayList<Long> seqNos) {
		ArrayList<AssetResServPartyDetail_DTO> assetResServPartyDetailsDTOs2 = assetResServPartyDetailsAdminServ
				.getSelectDetails(seqNos);
		return new ResponseEntity<>(assetResServPartyDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getDetailsForParties", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetResServPartyDetail_DTO>> getDetailsForParties(
			@RequestBody ArrayList<Long> seqNos) {
		ArrayList<AssetResServPartyDetail_DTO> assetResServPartyDetailsDTOs2 = assetResServPartyDetailsAdminServ
				.getDetailsForParties(seqNos);
		return new ResponseEntity<>(assetResServPartyDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getDetailsForResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetResServPartyDetail_DTO>> getDetailsForResources(
			@RequestBody ArrayList<Long> seqNos) {
		ArrayList<AssetResServPartyDetail_DTO> assetResServPartyDetailsDTOs2 = assetResServPartyDetailsAdminServ
				.getDetailsForResources(seqNos);
		return new ResponseEntity<>(assetResServPartyDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getDetailsForServices", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetResServPartyDetail_DTO>> getDetailsForServices(
			@RequestBody ArrayList<Long> seqNos) {
		ArrayList<AssetResServPartyDetail_DTO> assetResServPartyDetailsDTOs2 = assetResServPartyDetailsAdminServ
				.getDetailsForResources(seqNos);
		return new ResponseEntity<>(assetResServPartyDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetResServParty")
	public void updateAssetResServParty(@RequestBody AssetResServPartyDetail_DTO assetResServPartyDetailsDTO) {
		assetResServPartyDetailsAdminServ.updAssetResServPartyDetail(assetResServPartyDetailsDTO);
	}

	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<Long> seqNos) {
		assetResServPartyDetailsAdminServ.delSelectDetails(seqNos);
	}

	@DeleteMapping("/delDetailsForParties")
	public void delDetailsForParties(@RequestBody ArrayList<Long> seqNos) {
		assetResServPartyDetailsAdminServ.delDetailsForParties(seqNos);
	}

	@DeleteMapping("/delDetailsForResources")
	public void delDetailsForResources(@RequestBody ArrayList<Long> seqNos) {
		assetResServPartyDetailsAdminServ.delDetailsForResources(seqNos);
	}

	@DeleteMapping("/delDetailsForServices")
	public void delDetailsForServices(@RequestBody ArrayList<Long> seqNos) {
		assetResServPartyDetailsAdminServ.delDetailsForServices(seqNos);
	}

	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetResServParty() {
		assetResServPartyDetailsAdminServ.delAllAssetResServPartyDetails();
	}

}