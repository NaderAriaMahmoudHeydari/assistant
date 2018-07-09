package com.nader.aria.assistant.model;

import java.io.Serializable;

public class LoginModel implements Serializable{

    private Long id;

    private String userName;

    private String password;

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getUserName(){ return userName; }
    public void setUserName(String userName){ this.userName = userName; }

    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }

}
