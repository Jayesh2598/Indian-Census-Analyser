package com.capg.census;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTestUC2 {
	
	private static final String INDIA_STATE_CODE = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\test\\resources\\IndiaStateCode.csv";
	private static final String WRONG_CSV_FILE_PATH = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
	private static final String WRONG_CSV_FILE_TYPE = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCode.txt";
	private static final String WRONG_DELIMITER_FILE = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\test\\resources\\IndiaStateCodeTabDelimited.csv";
	
	@Test
	public void givenIndiaStateCodeFileShouldReturnCorrectRecords() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		ExpectedException exception = ExpectedException.none();
		exception.expect(CensusAnalyserException.class);
		int numOfRecords = 0;
		try {
			numOfRecords = censusAnalyser.loadIndiaStatesCode(INDIA_STATE_CODE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		assertEquals(37, numOfRecords);
	}
	
	@Test
	public void givenIndianStateCodeCSVFileIfIncorrectReturnsCustomException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		ExpectedException exception = ExpectedException.none();
		exception.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaStatesCode(WRONG_CSV_FILE_PATH);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.IncorrectCensusFile, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFileIfIncorrectTypeReturnsCustomException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		ExpectedException exception = ExpectedException.none();
		exception.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaStatesCode(WRONG_CSV_FILE_TYPE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.IncorrectCensusFile, e.type);
		}
	}
	
	@Test
	public void givenIndianStateCodeCSVFileIfIncorrectDelimiterUsedReturnsCustomException() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		ExpectedException exception = ExpectedException.none();
		exception.expect(CensusAnalyserException.class);
		try {
			censusAnalyser.loadIndiaStatesCode(WRONG_DELIMITER_FILE);
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
			assertEquals(CensusAnalyserException.ExceptionType.IncorrectFormat, e.type);
		}
	}
}
