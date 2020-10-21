package com.capg.census;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.capg.census.CensusAnalyserException.ExceptionType;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CensusAnalyser {

	public int loadIndiaCensusData(String CSVFilePath) throws CensusAnalyserException {
		int numOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CSVFilePath));
			CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
		} catch (IOException e) {
			throw new CensusAnalyserException("Incorrect file type or path.", ExceptionType.IncorrectCensusFile);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException("Incorrect delimiter/ header.", ExceptionType.IncorrectFormat);
		}
		return numOfEntries;
	}
	
	public int loadIndiaStatesCode(String CSVFilePath) throws CensusAnalyserException {
		int numOfEntries = 0;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(CSVFilePath));
			CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
			Iterator<IndiaStateCodeCSV> stateCodeCSVIterator = csvToBean.iterator();
			while (stateCodeCSVIterator.hasNext()) {
				numOfEntries++;
				stateCodeCSVIterator.next();
			}
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(), ExceptionType.IncorrectCensusFile);
		} catch (RuntimeException e) {
			throw new CensusAnalyserException(e.getMessage(), ExceptionType.IncorrectFormat);
		}
		return numOfEntries;
	}
}
