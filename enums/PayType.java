package com.nader.aria.assistant_blue.entities.enums;

public enum PayType {
	
	DEBT(1),
	BUY(2);
	
	private int no; 
	
	public int getPayType() { return no; }
	
	private PayType(int no) { this.no = no; }

}
