package com.nader.aria.assistant.entities.enums;

public enum PaymentReceiveType {
	
	CHECK(1),
	CASH(2),
	INSTALLMENT(3),
	BILL(4),
	POS(5),
	GENERIC(6);
	
	private int no;
	
	public int getNo() { return no; }
	
	private PaymentReceiveType(int no) { this.no = no; }

}
