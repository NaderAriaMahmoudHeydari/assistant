package com.nader.aria.assistant.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class PageInfo implements Serializable{

   private Menu[] menus;

   private String pageTitle;

   private String copyRight;

   private LocalDateTime lastUpdate;

   public Menu[] getMenus(){ return Menu.values(); }


}
