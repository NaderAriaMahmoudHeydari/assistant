package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.IAccountService;
import com.nader.aria.assistant.dao.account_repository.ILoginRepository;
import com.nader.aria.assistant.dao.financial_repository.IFundManagerRepository;
import com.nader.aria.assistant.dao.life_repository.ILifeRepository;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.account.UserNamePassword;
import com.nader.aria.assistant.entities.financial.FundManager;
import com.nader.aria.assistant.entities.life.Life;
import com.nader.aria.assistant.model.AccountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    private ILoginRepository loginRepository;
    private IFundManagerRepository fundManagerRepository;
    private ILifeRepository lifeRepository;

    @Autowired
    public AccountServiceImpl(ILoginRepository loginRepository,
                              IFundManagerRepository fundManagerRepository,
                              ILifeRepository lifeRepository ){

        this.loginRepository = loginRepository;
        this.fundManagerRepository = fundManagerRepository;
        this.lifeRepository = lifeRepository;
    }

    @Transactional
    public Login enter(UserNamePassword userNamePassword) throws Exception{
        return loginRepository.findByUserNamePassword(userNamePassword);
    }

    @Transactional
    public Login registering(AccountModel accountModel) throws Exception{

        Login login = new Login();
        login.setUser(accountModel.getUser());
        login.setUserNamePassword(accountModel.getUserNamePassword());
        login.setLanguage(accountModel.getLanguage());
        loginRepository.save(login);

        Life life = new Life();
        life.setLogin(login);
        lifeRepository.save(life);

        FundManager fundManager = new FundManager();
        fundManager.setLogin(login);
        fundManager.setCurrentFund(accountModel.getCurrentFund());
        fundManager.setSavingsFund(accountModel.getSavingsFund());

        fundManagerRepository.save(fundManager);
        return login;
    }

    @Transactional
    public Login saveUserImage(Login login) throws Exception {

        return loginRepository.save(login);
    }

    @Transactional
    public Optional<Login> findById(Long id) throws Exception{
        return loginRepository.findById(id);
    }
}
