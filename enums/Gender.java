package com.nader.aria.assistant_blue.entities.enums;

public enum Gender {
	
	MAN(1),
	WOMAN(2),
	OTHER(3);
	
	private int no;
	
	public int getNo() { return no; }
	
	private Gender(int no) { this.no = no; }
	
	public static String readEqualTypeToGender(Gender gender) {

		if( gender.equals(Gender.MAN)) { 
			return "Sir";
		}else if( gender.equals(Gender.WOMAN)) {
			return "Mis";
		}else {
			return "OTH";
		}
	}
	
	@Override
	public String toString() {
		return this.name();
	}

}
