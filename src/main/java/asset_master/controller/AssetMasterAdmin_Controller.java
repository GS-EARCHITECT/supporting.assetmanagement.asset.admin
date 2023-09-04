package asset_master.controller;

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
import asset_master.model.dto.AssetMaster_DTO;
import asset_master.service.I_AssetMasterAdmin_Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/assetAdminManagement")
public class AssetMasterAdmin_Controller {

	// private static final Logger logger =
	// LoggerFactory.getLogger(AssetMaster_Controller.class);

	@Autowired
	private I_AssetMasterAdmin_Service assetMasterAdminServ;

	@PostMapping("/new")
	public ResponseEntity<AssetMaster_DTO> newasset(@RequestBody AssetMaster_DTO assetDTO) {
		AssetMaster_DTO assetDTO2 = assetMasterAdminServ.newAssetMaster(assetDTO);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(assetDTO2, httpHeaders, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaster_DTO>> getAllAssetMasters() {
		ArrayList<AssetMaster_DTO> assetDTOs = assetMasterAdminServ.getAllAssetMasters();
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssets", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaster_DTO>> getSelectAssetMasters(@RequestBody ArrayList<Long> assetSeqNos) {
		ArrayList<AssetMaster_DTO> assetDTOs = assetMasterAdminServ.getSelectAssets(assetSeqNos);
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getSelectAssetsByResources", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ArrayList<AssetMaster_DTO>> getSelectAssetMastersByResources(
			@RequestBody ArrayList<Long> cos) {
		ArrayList<AssetMaster_DTO> assetDTOs = assetMasterAdminServ.getSelectAssetsByResources(cos);
		return new ResponseEntity<>(assetDTOs, HttpStatus.OK);
	}

	@GetMapping(value = "/getStatus/{assetSeqNo}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Character> getAssetStatus(@PathVariable Long assetSeqNo) {
		Character assetSt = assetMasterAdminServ.getAssetDoneStatus(assetSeqNo);
		return new ResponseEntity<>(assetSt, HttpStatus.OK);
	}

	@PutMapping("/updasset")
	public void updateasset(@RequestBody AssetMaster_DTO assetDTO) {
		assetMasterAdminServ.updAssetMaster(assetDTO);
		return;
	}

	@PutMapping("/updAssetDoneStatus{assetSeqNo}/{assetSt]")
	public void updateAssetStatus(@PathVariable Long id, @PathVariable Character assetSt) {
		assetMasterAdminServ.setAssetDoneStatus(id, assetSt);
		return;
	}

	@DeleteMapping("/delSelectasset")
	public void deleteSelectasset(@RequestBody ArrayList<Long> assetSeqNoList) {
		assetMasterAdminServ.delSelectAssets(assetSeqNoList);
		;
		return;
	}

	@DeleteMapping("/delSelectAssetsByResources")
	public void delSelectAssetsByResources(@RequestBody ArrayList<Long> rSeqNoList) {
		assetMasterAdminServ.delSelectAssetsByResources(rSeqNoList);
		return;
	}

	@DeleteMapping("/delAllasset")
	public void deleteAllassets() {
		assetMasterAdminServ.delAllAssetMasters();
		;
		return;
	}
}