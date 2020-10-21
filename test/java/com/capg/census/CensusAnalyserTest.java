package com.capg.census;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTest {
	
	private static final String INDIA_CENSUS_CSV_FILE = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\test\\resources\\IndiaStateCensusData.csv";
	private static final String WRONG_CSV_FILE_PATH = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	
	@Test
	public void givenIndianCensusCSVFileShouldReturnCorrectRecords() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		ExpectedException exception = ExpectedException.none();
		exception.expect(CensusAnalyserException.class);
		int numOfRecords = 0;
		try {
			numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		assertEquals(29, numOfRecords);
	}
	
	@Test
	public void givenIndianCensusCSVFileIfIncorrectReturnsCustomException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		ExpectedException exception = ExpectedException.none();
		exception.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.IncorrectCensusFile, e.type);
		}
		
	}
}
