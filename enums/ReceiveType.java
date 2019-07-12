package com.nader.aria.assistant_blue.entities.enums;

public enum ReceiveType {

	DEMAND(1),//طلب
	SALARY(2),
	REWARD(3);
	
	private int no;
	
	public int getNo() { return no; }
	
	private ReceiveType(int no) { this.no = no; }

}
