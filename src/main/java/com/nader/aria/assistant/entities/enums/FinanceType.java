package com.nader.aria.assistant.entities.enums;

public enum FinanceType {
	
	PREDICTABLE(1),
	UN_PREDICTABLE(2);
	
	private int no;
	
	public int getNo() { return no; }
	
	private FinanceType(int no) { this.no = no; }

}
