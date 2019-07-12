package com.nader.aria.assistant_blue.entities.enums;

public enum RepetitionType {

	NEVER(1),
	MONTHLY(2),
	WEEKLY(3),
	TWENTY_FOUR_HOURS(4),
	TWELVE_HOURS(5),
	ONE_HOUR(6),
	ONE_MINUTE(7),
	EVERYDAY(8),
	SATURDAY(9),
	SUNDAY(10),
	MONDAY(11),
	TUESDAY(12),
	WEDNESDAY(13),
	THURSDAY(14),
	FRIDAY(15),
	BASED_ON_TIME_RECEIVED(16);
	
	private int no;
	
	public int getNo() { return no; }
	
	private RepetitionType(int no) { this.no = no; }

}
