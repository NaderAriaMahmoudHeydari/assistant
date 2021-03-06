package com.nader.aria.assistant.entities.enums;

public enum TaskType {

    TASK(1),
    MEDICINE_TEST(2),
    MEDICINE_VISIT(3),
    TAKING_MEDICATION(4);

    private int no;

    private TaskType(int no){
        this.no = no;
    }

    public int getNo(){ return no; }

}
