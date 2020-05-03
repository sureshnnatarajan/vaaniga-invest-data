package com.vaaniga.invest.data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaaniga.invest.data.dto.ListedCompanyDto;
import com.vaaniga.invest.data.service.VaanigaDataService;

@RestController
@RequestMapping(path="/data")
@CrossOrigin("*")
public class VaanigaDataController {

	private VaanigaDataService vaanigaDataService;
	
	@Autowired
	public VaanigaDataController(VaanigaDataService vaanigaDataServiceParam) {
		this.vaanigaDataService = vaanigaDataServiceParam;
	}
	
	@GetMapping(value = "/generateListedCompanies", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> generateListedCompanies() {
		Map<String, String> responseObject = new HashMap<>(1);
		
		long startTime = System.nanoTime();
		
		vaanigaDataService.populateListedCompanyData();
		
		long timeElapsed = System.nanoTime() - startTime;
		responseObject.put("results", "Success");
		responseObject.put("executionTime", timeElapsed / 1000000 + " milliseconds");
		
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listedCompanies", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getListedCompanies() {
		Map<String, Object> responseObject = new HashMap<>(1);
		
		long startTime = System.nanoTime();
		
		List<ListedCompanyDto> companyList = vaanigaDataService.getListedCompanies();
		
		long timeElapsed = System.nanoTime() - startTime;
		responseObject.put("results", companyList);
		responseObject.put("executionTime", timeElapsed / 1000000 + " milliseconds");
		
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
	
	//@GetMapping(value="/companies/{sector}", produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value="/company/search/{companyName}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> searchByCompanyName(@PathVariable String companyName) {
		
		Map<String, Object> responseObject = new HashMap<>(1);
		
		long startTime = System.nanoTime();
		
		List<ListedCompanyDto> searchResults = vaanigaDataService.getListedCompany(companyName);	
		
		long timeElapsed = System.nanoTime() - startTime;
		responseObject.put("results", searchResults);
		responseObject.put("executionTime", timeElapsed / 1000000 + " milliseconds");
		
		return new ResponseEntity<>(responseObject, HttpStatus.OK);
	}
}
