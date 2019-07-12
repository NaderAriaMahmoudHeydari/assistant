package com.nader.aria.assistant_blue.entities.enums;

public enum MedicineTestType {

	BLOOD_SUGAR(1,120),
	BLOOD_PRESSURE(2,12);
	
	private int no;
	
	private int normalValue;
	
	public int getNo() { return no; }
	
	public int getNormalValue() { return normalValue; }
	
	private MedicineTestType(int no , int normalValue ) { 
		this.no = no; 
		this.normalValue = normalValue;
	}
}
