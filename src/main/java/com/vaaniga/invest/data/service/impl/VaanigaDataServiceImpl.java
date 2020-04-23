package com.vaaniga.invest.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaaniga.invest.data.dto.ListedCompanyDto;
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
		return null;
	}

	@Override
	public void populateListedCompanyData() {
		implHelper.performPopulateListedCompanies();
	}
}
