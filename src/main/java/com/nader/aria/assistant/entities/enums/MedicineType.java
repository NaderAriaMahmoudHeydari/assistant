package com.nader.aria.assistant.entities.enums;

public enum MedicineType {

	CLINIC(1),
	PARA_CLINIC(2),
	HOSPITAL(3),
	OFFICE(4),
	OTHER(5);
	
	private int no;
	
	public int getNo() { return no; }
	
	private MedicineType(int no) { this.no = no; }
}
