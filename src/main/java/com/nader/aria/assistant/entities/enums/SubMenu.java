package com.nader.aria.assistant.entities.enums;

public enum SubMenu {

    //Account SubMenus
    LOGIN(1,"Login","account/login"),
    REGISTERING(2,"Registering","account/registering"),
    UPDATE_PROFILE(3,"UpdateProfile","/updateProfile"),
    UPLOAD_USER_IMAGE(4,"UploadUserImage","/uploadUserImage"),
    DOWNLOAD_USER_IMAGE(5,"DownloadUserImage","/downloadUserImage"),
    DELETE_PROFILE(6,"DeleteProfile","/deleteProfile"),
    LOG_OUT(7,"Logout","/logout"),

    //Life SubMenus
    ADD_AIM(1,"Add Aim","/addAim"),
    AIM_LIST(2,"List Aims","/aimList"),
    UPDATE_AIM(3,"Update Aim","/updateAim"),
    DELETE_AIM(4,"Delete Aim","/deleteAim"),
    DELETE_ALL_AIMS(5,"Delete All Aim","/deleteAllAim"),
    ADD_SPRINT(6,"Add Sprint","/addSprint"),
    SPRINT_LIST(7,"Sprint List","/sprintList"),
    UPDATE_SPRINT(8,"Update Sprint","/updateSprint"),
    DELETE_SPRINT(9,"Delete Sprint","/deleteSprint"),
    DELETE_ALL_SPRINTS(10,"Delete All Sprints","/deleteAllSprint"),
    ADD_TASK(11,"Add Task","/addTask"),
    TASK_LIST(12,"Task List","/taskList"),
    UPDATE_TASK(13,"Update Task","/updateTask"),
    DELETE_TASK(14,"Delete Task","/deleteTask"),
    DELETE_ALL_TASK(15,"Delete All Tasks","/deleteAllTask");

    private int priority;

    private String title;

    private String path;

    private SubMenu(int priority , String title , String path ){
        this.priority = priority;
        this.title = title;
        this.path = path;
    }

   @Override
   public String toString(){
        return "index = " + priority+" , Title = "+title+" , Path = "+path;
   }

}
