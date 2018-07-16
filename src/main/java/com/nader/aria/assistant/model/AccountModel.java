package com.nader.aria.assistant.model;

import com.nader.aria.assistant.entities.account.User;
import com.nader.aria.assistant.entities.account.UserNamePassword;
import com.nader.aria.assistant.entities.enums.Gender;
import com.nader.aria.assistant.entities.enums.Language;
import com.nader.aria.assistant.entities.financial.CurrentFund;
import com.nader.aria.assistant.entities.financial.SavingsFund;


public class AccountModel extends BaseModel {

    private User user;

    private Language language;

    private UserNamePassword userNamePassword;

    private CurrentFund currentFund;

    private SavingsFund savingsFund;

    public final User getUser(){

        if( user == null ){
            user = new User();
        }
        return user;
    }

    public final void setUser(User user){
        this.user = user;
    }

    public final  Language getLanguage(){ return language; }

    public final  void setLanguage(Language language){ this.language = language; }

    public UserNamePassword getUserNamePassword(){

        if( userNamePassword == null ){
            userNamePassword = new UserNamePassword();
        }

        return userNamePassword;
    }

    public final  void setUserNamePassword(UserNamePassword userNamePassword){
        this.userNamePassword = userNamePassword;
    }

    public final  CurrentFund getCurrentFund(){

        if( currentFund == null ){
            currentFund = new CurrentFund();
        }
        return currentFund;
    }

    public final  void setCurrentFund(CurrentFund currentFund){
        this.currentFund = currentFund;
    }

    public final  SavingsFund getSavingsFund(){

        if( savingsFund == null ){
            savingsFund = new SavingsFund();
        }
        return savingsFund;
    }

    public final  void setSavingsFund(SavingsFund savingsFund){
        this.savingsFund = savingsFund;
    }

    public final Language[] getAllLanguage(){ return Language.values(); }

    public final Gender[] getAllGender(){ return Gender.values(); }

}
