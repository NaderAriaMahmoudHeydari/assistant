package com.nader.aria.assistant_blue.entities.enums;

public enum ScheduleType {

	UN_PLANING(1),
	DAILY_SCHEDULE(2),
	SPRINT(3);
	
	private int no;
	
	public int getNo() { return no; }
	
	private ScheduleType(int no) { this.no = no; }

}
