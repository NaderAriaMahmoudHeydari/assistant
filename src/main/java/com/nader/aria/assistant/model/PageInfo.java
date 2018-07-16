package com.nader.aria.assistant.model;

import com.nader.aria.assistant.entities.enums.Menu;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PageInfo implements Serializable{

   private Map<String,String> menus;

   private String pageTitle;

   private String copyRight;

   private LocalDateTime lastUpdate;

   private String message;

   public Map<String,String> getMenus(){
     return Stream.of(Menu.values()).collect(Collectors.toMap(Menu::getMenuName,Menu::getPath));
   }

   public String getPageTitle(){ return pageTitle; }
   public void setPageTitle(String pageTitle){ this.pageTitle = pageTitle; }

   public String getCopyRight(){ return copyRight; }
   public void setCopyRight(String copyRight){ this.copyRight = copyRight; }

   public LocalDateTime getLastUpdate(){
      if( lastUpdate == null ){
         lastUpdate = LocalDateTime.now();

      }
      return lastUpdate;
   }

   public void setLastUpdate(LocalDateTime lastUpdate){ this.lastUpdate = lastUpdate; }

   public String getMessage(){ return message; }
   public void setMessage(String message){ this.message = message; }



}
