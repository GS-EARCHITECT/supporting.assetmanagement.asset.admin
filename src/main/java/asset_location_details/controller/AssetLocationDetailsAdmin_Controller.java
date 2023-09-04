package asset_location_details.controller;

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

import asset_location_details.model.dto.AssetLocationDetail_DTO;
import asset_location_details.model.master.AssetLocationDetailPK;
import asset_location_details.service.I_AssetLocationDetailsAdmin_Service;

@RestController
@RequestMapping("/assetLocationDetailsAdminMgmt")
public class AssetLocationDetailsAdmin_Controller 
{

	//private static final Logger AssUtilDetailsgger = LoggerFactory.getLogger(AssetLocation_AssetLocation_Lontroller.class);

	@Autowired
	private I_AssetLocationDetailsAdmin_Service assetLocationDetailsAdminServ;
	
	@PostMapping("/new")
	public ResponseEntity<AssetLocationDetail_DTO> newAssetLocation(@RequestBody AssetLocationDetail_DTO assetLocationDetailsDTO) {
		AssetLocationDetail_DTO assetLocationDetailsDTO2 = assetLocationDetailsAdminServ.newAssetLocationDetail(assetLocationDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetLocationDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetLocationDetail_DTO>> getAllAssetLocation_Details() {
		ArrayList<AssetLocationDetail_DTO> assetLocationDetailsDTOs = assetLocationDetailsAdminServ.getAllAssetLocationDetails();
		//AssUtilDetailsgger.info("size :"+assetLocationDetailsDTOs.size());
		return new ResponseEntity<>(assetLocationDetailsDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetLocationDetail_DTO>> getSelectAssetLocation_Details(@RequestBody ArrayList<AssetLocationDetailPK> seqNos) 
	{
		ArrayList<AssetLocationDetail_DTO> assetLocationDetailsDTOs2 = assetLocationDetailsAdminServ.getSelectDetails(seqNos);		
		return new ResponseEntity<>(assetLocationDetailsDTOs2, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getDetailsBetween/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetLocationDetail_DTO>> getDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		ArrayList<AssetLocationDetail_DTO> assetLocationDetailsDTOs2 = assetLocationDetailsAdminServ.getDetailsBetweenTimes(fr, to);		
		return new ResponseEntity<>(assetLocationDetailsDTOs2, HttpStatus.OK);
	}
	
	@PutMapping("/updAssetLocation")
	public void updateAssetLocation(@RequestBody AssetLocationDetail_DTO assetLocationDetailsDTO) {
		assetLocationDetailsAdminServ.updAssetLocationDetail(assetLocationDetailsDTO);
	}
	
	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<AssetLocationDetailPK> seqNos) {
		assetLocationDetailsAdminServ.delSelectDetails(seqNos);
	}
	
	@DeleteMapping("/delDetailsBetween/{fr}/{to}")
	public void delDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		assetLocationDetailsAdminServ.delSelectDetailsBetweenTimes(fr, to);		
		return;
	}
	
	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetLocation() {
		assetLocationDetailsAdminServ.delAllAssetLocationDetails();
	}
	
	
	}