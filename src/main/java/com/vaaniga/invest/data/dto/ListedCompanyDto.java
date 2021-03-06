package com.vaaniga.invest.data.dto;

import com.vaaniga.invest.data.model.ListedCompany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListedCompanyDto {
	
	private Long serialNumber;

	private String companyName;
	
	private String isin;
	
	private String bseSymbol;
	
	private String nseSymbol;
	
	private String mseSymbol;
	
	private String marketCapCategorization;
	
	public ListedCompanyDto(ListedCompany listedCompany) {
		this.serialNumber = listedCompany.getSerialNumber();
		this.companyName = listedCompany.getCompanyName();
		this.isin = listedCompany.getIsin();
		this.bseSymbol = listedCompany.getBseSymbol();
		this.nseSymbol = listedCompany.getNseSymbol();
		this.mseSymbol = listedCompany.getMseSymbol();
		this.marketCapCategorization = listedCompany.getMarketCapCategorization();
	}
}
