package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.AccountServiceImpl;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.account.UserNamePassword;
import com.nader.aria.assistant.model.AccountModel;
import com.nader.aria.assistant.model.AccountSmallInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class AccountWebService {

    private AccountServiceImpl accountService;

    @Autowired
    public AccountWebService(AccountServiceImpl accountService){
        this.accountService = accountService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Login> enter(@RequestBody UserNamePassword userNamePassword){

        try {
           Login login = accountService.enter(userNamePassword);

           if( login != null ){

               return new ResponseEntity<>(login,HttpStatus.ACCEPTED);
           }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>(new Login(),HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/registering",consumes = MediaType.APPLICATION_JSON)
    public ResponseEntity<Login> registering(@RequestBody AccountModel accountModel){

        try {

            return new ResponseEntity<>(accountService.registering(accountModel),HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();

        }

        return new ResponseEntity<>(new Login(),HttpStatus.NOT_ACCEPTABLE);
    }


    @PostMapping(value = "/uploadImage")
    public ResponseEntity<Login> uploadImage(@RequestBody MultipartFile file, @RequestBody Long loginId){

        try {

            if( file != null ){
                Optional<Login> optional = accountService.findById(loginId);
                if( optional.isPresent() ){
                    Login login = optional.get();
                    login.getUser().setImage(file.getBytes());
                    accountService.saveUserImage(login);
                    return new ResponseEntity<>(login,HttpStatus.OK );
                }

                return new ResponseEntity<>(new Login(),HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>(new Login() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return  new ResponseEntity<>(new Login() ,HttpStatus.NOT_ACCEPTABLE);
    }



}
