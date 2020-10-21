package com.capg.census;

public class CensusAnalyserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public enum ExceptionType {
		IncorrectCensusFile;
	}
	
	ExceptionType type; 

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
