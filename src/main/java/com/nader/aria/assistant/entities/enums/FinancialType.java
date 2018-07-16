package com.nader.aria.assistant.entities.enums;

public enum FinancialType {

    FINANCIAL(1),
    RECEIVE(2),
    PAYMENT(3),
    FACTOR(4);

    private int no;

    private FinancialType(int no){
        this.no = no;
    }

    public int getNo(){ return no; }
}
