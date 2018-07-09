package com.nader.aria.assistant.model;

public enum Menu {

    ACCOUNT("Account","/account"),
    HOME("Home","/home"),
    LIFE("Life","/life"),
    FINANCIAL("Financial","/financial"),
    MEDICINE("Medicine","/medicine"),
    REMINDER("Reminder","/reminder");

    private String menuName;
    private String path;

    private Menu(String menuName , String path){
        this.path = path;
        this.menuName = menuName;
    }

    public String getPath(){ return path; }


}
