package com.capg.census;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CensusAnalyserTestUC2 {
	
	private static final String INDIA_STATE_CODE = "D:\\Eclipse Workspace\\IndianCensusAnalyser\\src\\test\\resources\\IndiaStateCode.csv";
	
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
}
