package com.capg.census;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {

	public int loadIndiaCensusData(String CSVFilePath) {
		int numOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CSVFilePath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			while(censusCSVIterator.hasNext()) {
				numOfEntries++;
				IndiaCensusCSV censusData = censusCSVIterator.next();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numOfEntries;
	}
}
