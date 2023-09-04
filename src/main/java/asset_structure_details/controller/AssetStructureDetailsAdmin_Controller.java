package asset_structure_details.controller;

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

import asset_structure_details.model.dto.AssetStructureDetail_DTO;
import asset_structure_details.model.master.AssetStructureDetailPK;
import asset_structure_details.service.I_AssetStructureDetailsAdmin_Service;

@RestController
@RequestMapping("/assetStructureDetailsAdminMgmt")
public class AssetStructureDetailsAdmin_Controller {

	// private static final Logger AssUtilDetailsgger =
	// LoggerFactory.getLogger(AssetStructure_AssetStructure_Lontroller.class);

	@Autowired
	private I_AssetStructureDetailsAdmin_Service assetStructureDetailsAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetStructureDetail_DTO> newAssetStructure(@RequestBody AssetStructureDetail_DTO assetStructureDetailsDTO) {
		AssetStructureDetail_DTO assetStructureDetailsDTO2 = assetStructureDetailsAdminServ.newAssetStructureDetail(assetStructureDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetStructureDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetStructureDetail_DTO>> getAllAssetStructure_Details() {
		ArrayList<AssetStructureDetail_DTO> assetStructureDetailsDTOs = assetStructureDetailsAdminServ.getAllAssetStructureDetails();
		// AssUtilDetailsgger.info("size :"+assetStructureDetailsDTOs.size());
		return new ResponseEntity<>(assetStructureDetailsDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetStructureDetail_DTO>> getSelectAssetStructure_Details(
			@RequestBody ArrayList<AssetStructureDetailPK> seqNos) {
		ArrayList<AssetStructureDetail_DTO> assetStructureDetailsDTOs2 = assetStructureDetailsAdminServ.getSelectDetails(seqNos);
		return new ResponseEntity<>(assetStructureDetailsDTOs2, HttpStatus.OK);
	}

	@GetMapping(value = "/getDetailsBetween/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetStructureDetail_DTO>> getDetailsBetweenTimes(@PathVariable String fr,
			@PathVariable String to) {
		ArrayList<AssetStructureDetail_DTO> assetStructureDetailsDTOs2 = assetStructureDetailsAdminServ.getDetailsBetweenTimes(fr, to);
		return new ResponseEntity<>(assetStructureDetailsDTOs2, HttpStatus.OK);
	}

	@PutMapping("/updAssetStructure")
	public void updateAssetStructure(@RequestBody AssetStructureDetail_DTO assetStructureDetailsDTO) {
		assetStructureDetailsAdminServ.updAssetStructureDetail(assetStructureDetailsDTO);
	}

	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<AssetStructureDetailPK> seqNos) {
		assetStructureDetailsAdminServ.delSelectDetails(seqNos);
	}

	@DeleteMapping("/delDetailsBetween/{fr}/{to}")
	public void delDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		assetStructureDetailsAdminServ.delSelectDetailsBetweenTimes(fr, to);
		return;
	}

	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetStructure() {
		assetStructureDetailsAdminServ.delAllAssetStructureDetails();
	}

}