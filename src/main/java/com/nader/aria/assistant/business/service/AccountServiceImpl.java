package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.IAccountService;
import com.nader.aria.assistant.dao.account_repository.IAddressRepository;
import com.nader.aria.assistant.dao.account_repository.IContactDetailRepository;
import com.nader.aria.assistant.dao.account_repository.ILoginRepository;
import com.nader.aria.assistant.dao.account_repository.IUserNamePasswordRepository;
import com.nader.aria.assistant.dao.financial_repository.IFundManagerRepository;
import com.nader.aria.assistant.dao.idea_repository.IdeaManagerRepository;
import com.nader.aria.assistant.dao.life_repository.ILifeRepository;
import com.nader.aria.assistant.dao.medicine_repository.IDrugInfoManagerRepository;
import com.nader.aria.assistant.dao.medicine_repository.IMedicineInfoManagerRepository;
import com.nader.aria.assistant.dao.reminder_repository.IReminderManagerRepository;
import com.nader.aria.assistant.entities.account.Address;
import com.nader.aria.assistant.entities.account.ContactDetail;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.account.UserNamePassword;
import com.nader.aria.assistant.entities.financial.FundManager;
import com.nader.aria.assistant.entities.idea.IdeaManager;
import com.nader.aria.assistant.entities.life.Life;
import com.nader.aria.assistant.entities.medicine.DrugInfoManager;
import com.nader.aria.assistant.entities.medicine.MedicineInfoManager;
import com.nader.aria.assistant.entities.reminder.ReminderManager;
import com.nader.aria.assistant.model.AccountModel;
import com.nader.aria.assistant.utils.PasswordDigester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AccountServiceImpl implements IAccountService {

    private ILoginRepository loginRepository;
    private IUserNamePasswordRepository userNamePasswordRepository;
    private IAddressRepository addressRepository;
    private IContactDetailRepository contactDetailRepository;
    private IFundManagerRepository fundManagerRepository;
    private ILifeRepository lifeRepository;
    private IDrugInfoManagerRepository drugInfoManagerRepository;
    private IReminderManagerRepository reminderManagerRepository;
    private IMedicineInfoManagerRepository medicineInfoManagerRepository;
    private IdeaManagerRepository ideaManagerRepository;


    @Autowired
    public AccountServiceImpl(ILoginRepository loginRepository ,
                              IUserNamePasswordRepository userNamePasswordRepository ,
                              IAddressRepository addressRepository ,
                              IContactDetailRepository contactDetailRepository ,
                              IFundManagerRepository fundManagerRepository ,
                              ILifeRepository lifeRepository ,
                              IDrugInfoManagerRepository drugInfoManagerRepository ,
                              IReminderManagerRepository reminderManagerRepository ,
                              IMedicineInfoManagerRepository medicineInfoManagerRepository,
                              IdeaManagerRepository ideaManagerRepository ){

        this.loginRepository = loginRepository;
        this.userNamePasswordRepository = userNamePasswordRepository;
        this.addressRepository = addressRepository;
        this.contactDetailRepository = contactDetailRepository;
        this.fundManagerRepository = fundManagerRepository;
        this.lifeRepository = lifeRepository;
        this.drugInfoManagerRepository = drugInfoManagerRepository;
        this.reminderManagerRepository = reminderManagerRepository;
        this.medicineInfoManagerRepository = medicineInfoManagerRepository;
        this.ideaManagerRepository = ideaManagerRepository;

    }

    @Override
    @Transactional
    public Login enter(UserNamePassword userNamePassword) throws Exception{
        userNamePassword.setPassword(
                PasswordDigester.digest(userNamePassword.getPassword(),
                                        userNamePassword.getUserName() )
        );

        return loginRepository.findByUserNamePasswordUserNameAndUserNamePasswordPassword(userNamePassword.getUserName(),userNamePassword.getPassword());
    }

    @Override
    @Transactional
    public Login registering(AccountModel accountModel) throws Exception{

        Login login = new Login();
        login.setUser(accountModel.getUser());
        accountModel.getUserNamePassword().setPassword(
                PasswordDigester.digest(accountModel.getUserNamePassword().getPassword(),
                                        accountModel.getUserNamePassword().getUserName() )
        );


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

        DrugInfoManager drugInfoManager = new DrugInfoManager();
        drugInfoManager.setLogin(login);
        drugInfoManagerRepository.save(drugInfoManager);

        ReminderManager reminderManager = new ReminderManager();
        reminderManager.setLogin(login);
        reminderManagerRepository.save(reminderManager);

        MedicineInfoManager medicineInfoManager = new MedicineInfoManager();
        medicineInfoManager.setLogin(login);
        medicineInfoManagerRepository.save(medicineInfoManager);

        IdeaManager ideaManager = new IdeaManager();
        ideaManager.setLogin(login);
        ideaManagerRepository.save(ideaManager);

        return login;
    }



    @Override
    @Transactional
    public Login saveUserImage(Login login) throws Exception {

        return loginRepository.save(login);
    }

    @Override
    @Transactional
    public Optional<Login> findById(Long id) throws Exception{
        return loginRepository.findById(id);
    }

    @Override
    @Transactional
    public Login update(Login login) throws Exception{
        return loginRepository.save(login);
    }

    @Override
    @Transactional
    public void delete(Long loginId) throws Exception{

        Optional<Login> optional = loginRepository.findById( loginId );
        Login login = ( optional.isPresent() ? optional.get() : null );

        if( login != null ){

            FundManager tempFundManager = fundManagerRepository.findByLogin(login);
            Life tempLife  = lifeRepository.findByLogin(login);

            fundManagerRepository.delete(tempFundManager);
            fundManagerRepository.flush();

            lifeRepository.delete(tempLife);
            lifeRepository.flush();

            loginRepository.delete(login);
            loginRepository.flush();

        }

    }

    @Override
    @Transactional
    public UserNamePassword update(UserNamePassword userNamePassword) throws Exception{
        userNamePassword.setPassword(
                PasswordDigester.digest(userNamePassword.getPassword(),userNamePassword.getUserName())
        );
        return userNamePasswordRepository.save(userNamePassword);
    }

    @Override
    @Transactional
    public Address update(Address address) throws Exception{
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public ContactDetail update(ContactDetail contactDetail) throws Exception{
        return contactDetailRepository.save(contactDetail);
    }
}
