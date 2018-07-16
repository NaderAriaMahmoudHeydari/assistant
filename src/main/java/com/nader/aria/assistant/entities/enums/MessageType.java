package com.nader.aria.assistant.entities.enums;

public enum MessageType {

    INFO_MESSAGE(1),
    WARNING_MESSAGE(2),
    ERROR_MESSAGE(3);

    private int no;

    public int getNo(){ return no; }

    private MessageType(int no){
        this.no = no;
    }
}
