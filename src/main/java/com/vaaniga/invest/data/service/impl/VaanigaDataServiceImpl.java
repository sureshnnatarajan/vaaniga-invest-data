package com.vaaniga.invest.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaaniga.invest.data.dto.ListedCompanyDto;
import com.vaaniga.invest.data.model.ListedCompany;
import com.vaaniga.invest.data.service.VaanigaDataService;
import com.vaaniga.invest.data.service.helper.VaanigaDataServiceImplHelper;

@Service
public class VaanigaDataServiceImpl implements VaanigaDataService {

	private VaanigaDataServiceImplHelper implHelper;
	
	@Autowired
	public VaanigaDataServiceImpl(VaanigaDataServiceImplHelper implHelper) {
		super();
		this.implHelper = implHelper;
	}

	@Override
	public List<ListedCompanyDto> getSmallCapCompanies(String marketCapCategory) {
		return null;
	}

	@Override
	public List<ListedCompanyDto> getListedCompany(String companyName) {
		
		List<ListedCompany> searchResults = implHelper.getListedCompanyRepository().findByCompanyNameContainingIgnoreCase(companyName);
		
		List<ListedCompanyDto> results = new ArrayList<>();
		
		for (ListedCompany company : searchResults) {
			
			ListedCompanyDto dto = new ListedCompanyDto(company);
			
			results.add(dto);
		}
		
		return results;
	}

	@Override
	public void populateListedCompanyData() {
		implHelper.performPopulateListedCompanies();
	}
}
