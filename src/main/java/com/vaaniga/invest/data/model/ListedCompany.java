package com.vaaniga.invest.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ListedCompany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long serialNumber;

	private String companyName;
	
	private String isin;
	
	private String bseSymbol;
	
	private String nseSymbol;
	
	private String mseSymbol;
	
	private String marketCapCategorization;
	
}
