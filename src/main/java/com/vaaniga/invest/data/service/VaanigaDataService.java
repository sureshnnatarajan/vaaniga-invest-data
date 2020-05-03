package com.vaaniga.invest.data.service;

import java.util.List;

import com.vaaniga.invest.data.dto.ListedCompanyDto;

public interface VaanigaDataService {

	List<ListedCompanyDto> getSmallCapCompanies(String marketCapCategory);
	
	List<ListedCompanyDto> getListedCompany(String companyName);
	
	List<ListedCompanyDto> getListedCompanies();
	
	//To be invoked via a scheduler (or) via a privileged user with get api since path of CSV file will be hardcoded.
	void populateListedCompanyData();
	
}
