package com.vaaniga.invest.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vaaniga.invest.data.model.ListedCompany;

@Repository
public interface ListedCompanyRepository extends JpaRepository<ListedCompany, Long> {

	List<ListedCompany> findByCompanyNameContainingIgnoreCase(String companyName);
	
	List<ListedCompany> findByNseSymbolContainingIgnoreCase(String nseSymbol);
	
	List<ListedCompany> findByBseSymbolContainingIgnoreCase(String bseSymbol);
	
	List<ListedCompany> findByMseSymbolContainingIgnoreCase(String mseSymbol);
	
	List<ListedCompany> findByMarketCapCategorizationContainingIgnoreCase(String marketCapCategorization);
}
