package asset_meter_details.controller;

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

import asset_meter_details.model.dto.AssetMeterDetail_DTO;
import asset_meter_details.model.master.AssetMeterDetailPK;
import asset_meter_details.service.I_AssetMeterDetailsAdmin_Service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetMeterDetailsAdminMgmt")
public class AssetMeterDetailsAdmin_Controller 
{

	//private static final Logger AssUtilDetailsgger = LoggerFactory.getLogger(AssetMeter_AssetMeter_Lontroller.class);

	@Autowired
	private I_AssetMeterDetailsAdmin_Service assetMeterDetailsAdminServ;
	
	@PostMapping("/new")
	public ResponseEntity<AssetMeterDetail_DTO> newAssetMeter(@RequestBody AssetMeterDetail_DTO assetMeterDetailsDTO) {
		AssetMeterDetail_DTO assetMeterDetailsDTO2 = assetMeterDetailsAdminServ.newAssetMeterDetail(assetMeterDetailsDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetMeterDetailsDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssUtilDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMeterDetail_DTO>> getAllAssetMeter_Details() {
		ArrayList<AssetMeterDetail_DTO> assetMeterDetailsDTOs = assetMeterDetailsAdminServ.getAllAssetMeterDetails();
		//AssUtilDetailsgger.info("size :"+assetMeterDetailsDTOs.size());
		return new ResponseEntity<>(assetMeterDetailsDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getSelectDetails", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMeterDetail_DTO>> getSelectAssetMeter_Details(@RequestBody ArrayList<AssetMeterDetailPK> seqNos) 
	{
		ArrayList<AssetMeterDetail_DTO> assetMeterDetailsDTOs2 = assetMeterDetailsAdminServ.getSelectDetails(seqNos);		
		return new ResponseEntity<>(assetMeterDetailsDTOs2, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getDetailsBetween/{fr}/{to}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMeterDetail_DTO>> getDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		ArrayList<AssetMeterDetail_DTO> assetMeterDetailsDTOs2 = assetMeterDetailsAdminServ.getDetailsBetweenTimes(fr, to);		
		return new ResponseEntity<>(assetMeterDetailsDTOs2, HttpStatus.OK);
	}
	
	@PutMapping("/updAssetMeter")
	public void updateAssetMeter(@RequestBody AssetMeterDetail_DTO assetMeterDetailsDTO) {
		assetMeterDetailsAdminServ.updAssetMeterDetail(assetMeterDetailsDTO);
	}
	
	@DeleteMapping("/delSelectAssUtilDetails")
	public void deleteSelectAssUtilDetails(@RequestBody ArrayList<AssetMeterDetailPK> seqNos) {
		assetMeterDetailsAdminServ.delSelectDetails(seqNos);
	}
	
	@DeleteMapping("/delDetailsBetween/{fr}/{to}")
	public void delDetailsBetweenTimes(@PathVariable String fr, @PathVariable String to) {
		assetMeterDetailsAdminServ.delSelectDetailsBetweenTimes(fr, to);		
		return;
	}
	
	@DeleteMapping("/delAllAssUtilDetails")
	public void deleteAllAssetMeter() {
		assetMeterDetailsAdminServ.delAllAssetMeterDetails();
	}
	
	
	}