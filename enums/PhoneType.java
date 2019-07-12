package com.nader.aria.assistant_blue.entities.enums;

public enum PhoneType {

    MOBILE(1),
    HOME(2),
    WORK(3),
    MAIN(4),
    WORK_FAX(5),
    HOME_FAX(6),
    PAGER(7),
    OTHER(8),
    CUSTOM(9);

    private int no;

    public int getNo(){ return no; }

    private PhoneType(int no){
        this.no = no;
    }

}
