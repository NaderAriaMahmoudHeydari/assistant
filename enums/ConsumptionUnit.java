package com.nader.aria.assistant_blue.entities.enums;

public enum ConsumptionUnit {

    ONE_QUARTER_PILLS("1/4P"),
    HALF_A_PILL("1/2P"),
    ONE_PILL("1P"),
    TWO_PILLS("2P"),
    A_QUARTER_SPOON("1/4S"),
    HALF_A_TABLESPOON("1/2S"),
    ONE_SPOON("1S"),
    TWO_SPOONS("2S"),
    THREE_SPOONS("3S"),
    FOUR_SPOONS("4S"),
    FIVE_SPOONS("5S"),
    ONE_INJECTION("1In"),
    OTHER("OTH");

    private String unitString;

    public String getUnitString(){ return unitString; }

    private ConsumptionUnit(String unitString){
        this.unitString = unitString;
    }
}
