package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.account.UserNamePassword;
import com.nader.aria.assistant.model.AccountModel;

import java.util.Optional;

public interface IAccountService {

    public Login enter(UserNamePassword userNamePassword) throws Exception;

    public Login registering(AccountModel accountModel) throws Exception;

    public Login saveUserImage(Login login) throws Exception;

    public Optional<Login> findById(Long id) throws Exception;

}
