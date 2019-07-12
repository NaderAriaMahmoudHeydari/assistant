package com.nader.aria.assistant_blue.entities.enums;

public enum ReminderState {

	INFO(1),
	WARNING(2),
	ERROR(3);
	
	private int no;
	
	public int getNo() { return no; }
	private ReminderState(int no) { this.no = no; }

}
