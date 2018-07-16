package com.nader.aria.assistant.entities.enums;

import java.util.ArrayList;
import java.util.List;

public enum Menu implements IMenuItems {


    ACCOUNT(1,"Account","/account"){

        public List<String> getItems(){
            List<String> subMenus = new ArrayList<>();
            subMenus.add(SubMenu.LOGIN.toString());
            subMenus.add(SubMenu.REGISTERING.toString());
            subMenus.add(SubMenu.UPDATE_PROFILE.toString());
            subMenus.add(SubMenu.UPLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DOWNLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DELETE_PROFILE.toString());
            subMenus.add(SubMenu.LOG_OUT.toString());
            return subMenus;
        }

    },

    LIFE(2,"Life","/life"){

        public List<String> getItems(){

            List<String> subMenus = new ArrayList<>();
            subMenus.add(SubMenu.ADD_AIM.toString());
            subMenus.add(SubMenu.AIM_LIST.toString());
            subMenus.add(SubMenu.UPDATE_AIM.toString());
            subMenus.add(SubMenu.DELETE_AIM.toString());
            subMenus.add(SubMenu.DELETE_ALL_AIMS.toString());
            subMenus.add(SubMenu.ADD_SPRINT.toString());
            subMenus.add(SubMenu.SPRINT_LIST.toString());
            subMenus.add(SubMenu.UPDATE_SPRINT.toString());
            subMenus.add(SubMenu.DELETE_SPRINT.toString());
            subMenus.add(SubMenu.DELETE_ALL_SPRINTS.toString());
            subMenus.add(SubMenu.ADD_TASK.toString());
            subMenus.add(SubMenu.TASK_LIST.toString());
            subMenus.add(SubMenu.UPDATE_TASK.toString());
            subMenus.add(SubMenu.DELETE_TASK.toString());
            subMenus.add(SubMenu.DELETE_ALL_TASK.toString());
            return subMenus;

        }

    },
    FINANCIAL(3,"Financial","/financial"){

        public List<String> getItems(){
            List<String> subMenus = new ArrayList<>();
            subMenus.add(SubMenu.LOGIN.toString());
            subMenus.add(SubMenu.REGISTERING.toString());
            subMenus.add(SubMenu.UPDATE_PROFILE.toString());
            subMenus.add(SubMenu.UPLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DOWNLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DELETE_PROFILE.toString());
            subMenus.add(SubMenu.LOG_OUT.toString());
            return subMenus;
        }

    },
    MEDICINE(4,"Medicine","/medicine"){

        public List<String> getItems(){
            List<String> subMenus = new ArrayList<>();
            subMenus.add(SubMenu.LOGIN.toString());
            subMenus.add(SubMenu.REGISTERING.toString());
            subMenus.add(SubMenu.UPDATE_PROFILE.toString());
            subMenus.add(SubMenu.UPLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DOWNLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DELETE_PROFILE.toString());
            subMenus.add(SubMenu.LOG_OUT.toString());
            return subMenus;
        }

    },
    REMINDER(5,"Reminder","/reminder"){

        public List<String> getItems(){
            List<String> subMenus = new ArrayList<>();
            subMenus.add(SubMenu.LOGIN.toString());
            subMenus.add(SubMenu.REGISTERING.toString());
            subMenus.add(SubMenu.UPDATE_PROFILE.toString());
            subMenus.add(SubMenu.UPLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DOWNLOAD_USER_IMAGE.toString());
            subMenus.add(SubMenu.DELETE_PROFILE.toString());
            subMenus.add(SubMenu.LOG_OUT.toString());
            return subMenus;
        }

    };

    private int index;
    private String menuName;
    private String path;

    private Menu(int index , String menuName , String path){

        this.index = index;
        this.path = path;
        this.menuName = menuName;
    }

    public int getIndex(){ return index; }

    public String getPath(){ return path; }

    public String getMenuName(){ return menuName; }



}
