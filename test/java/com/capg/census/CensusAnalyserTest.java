package com.capg.census;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CensusAnalyserTest {
	
	private static final String INDIA_CENSUS_CSV_FILE = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\test\\resources\\IndiaStateCensusData.csv";
	
	@Test
	public void givenIndianCensusCSVFileShouldReturnCorrectRecords() {
		CensusAnalyser censusAnalyser = new CensusAnalyser();
		int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE);
		assertEquals(29, numOfRecords);
	}
}
