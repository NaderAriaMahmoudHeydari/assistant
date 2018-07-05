package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.account.Login;

public interface IAccountService {

    public Login enter( String userName , String password ) throws Exception;
}
