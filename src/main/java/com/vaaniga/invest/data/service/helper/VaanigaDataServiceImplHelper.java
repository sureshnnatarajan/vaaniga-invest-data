package com.vaaniga.invest.data.service.helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.vaaniga.invest.data.model.ListedCompany;
import com.vaaniga.invest.data.repository.ListedCompanyRepository;

import lombok.Data;

@Component
@Data
public class VaanigaDataServiceImplHelper {

	public static final String _CSV_FILE_ = "/Users/sureshnatarajan/Downloads/Avg-Market-Cap-Dec-2019.csv";

	private ListedCompanyRepository listedCompanyRepository;

	@Autowired
	public VaanigaDataServiceImplHelper(ListedCompanyRepository listedCompanyRepository) {
		super();
		this.listedCompanyRepository = listedCompanyRepository;
	}

	public List<String[]> readDataFromFile() throws IOException, CsvException {
		// Create an object of file reader 
		// class with CSV file as a parameter. 
		FileReader filereader = new FileReader(_CSV_FILE_); 

		// create csvReader object and skip first Line 
		CSVReader csvReader = new CSVReaderBuilder(filereader) 
				.withSkipLines(1) 
				.build(); 
		List<String[]> allData = csvReader.readAll();

		return allData;
	}

	public List<ListedCompany> constructEntityModelCollection(List<String[]> allData) {
		List<ListedCompany> listedCompanies = new ArrayList<>();

		int columnCount = 0;

		// print Data 
		for (String[] row : allData) {

			ListedCompany company = new ListedCompany();
			columnCount = 0;
			for (String cell : row) { 
				switch(columnCount) {
				case 0:
					company.setSerialNumber(Long.valueOf(cell));
					break;
				case 1:
					company.setCompanyName(cell);
					break;
				case 2:
					company.setIsin(cell);
					break;
				case 3:
					company.setBseSymbol(cell);
					break;
				case 4:
					
					break;
				case 5:
					company.setNseSymbol(cell);
					break;
				case 6:
					break;
				case 7:
					company.setMseSymbol(cell);
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					company.setMarketCapCategorization(cell);
					break;
				default:
					break;	
				}
				++columnCount;
				listedCompanies.add(company);
			} 
			System.out.println(company); 
		}
		return listedCompanies;
	}

	@Transactional
	public void pushModelDataToRepository() throws IOException, CsvException {
		
		List<ListedCompany> listedCompanies = constructEntityModelCollection(readDataFromFile());
		
		//Store the collection completely
		listedCompanyRepository.saveAll(listedCompanies);
	}

	public void performPopulateListedCompanies() {
		
		try {
			pushModelDataToRepository();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
		
	}
}
