package com.nader.aria.assistant.entities.enums;

public enum AimType {

	ACADEMIC(1),
	EDUCATIONAL(2),
	FINANCIAL(3),
	WORK(4),
	PHYSICAL(5),
	SPIRITUAL(6),
	GENERIC(7),
	OTHER(8);
	
	private int no; 
	
	public int getNo() { return no; }
	
	private AimType(int no) { this.no = no; }

}
