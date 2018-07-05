package com.nader.aria.assistant.entities.enums;

public enum Language {

	EN_US(1),
	FR_IR(2);
	
	private int no;
	
	public int getNo() { return no; }
	
	private Language(int no) { this.no = no; }
	
	
}
