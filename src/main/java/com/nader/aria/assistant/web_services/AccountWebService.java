package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.AccountServiceImpl;
import com.nader.aria.assistant.entities.account.Address;
import com.nader.aria.assistant.entities.account.ContactDetail;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.account.UserNamePassword;
import com.nader.aria.assistant.entities.enums.Gender;
import com.nader.aria.assistant.entities.enums.Language;
import com.nader.aria.assistant.model.AccountModel;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.ws.rs.NotFoundException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class AccountWebService {

    private AccountServiceImpl accountService;

    @Autowired
    public AccountWebService(AccountServiceImpl accountService){
        this.accountService = accountService;
    }

    @GetMapping("/getGenders")
    public ResponseEntity<?> getGenders(){
        return ResponseEntityManager.OK.getResponseEntity(Gender.values());
    }

    @GetMapping("/getLanguages")
    public ResponseEntity<?> getLanguages(){
        return ResponseEntityManager.OK.getResponseEntity(Language.values());
    }

    @PostMapping("/registering")
    public ResponseEntity<?> registering(@RequestBody AccountModel accountModel){

        try {

            return ResponseEntityManager.CREATED.getResponseEntity(accountService.registering(accountModel));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }

    }

    @PostMapping("/login")
    public ResponseEntity<?> enter(@RequestBody UserNamePassword userNamePassword){

        try {

           Login login = accountService.enter(userNamePassword);

           if( login != null ){

               return ResponseEntityManager.ACCEPTED.getResponseEntity(login);
           }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return ResponseEntityManager.NOT_FOUND.getResponseEntity();
    }

    @PostMapping("/uploadUserImage")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file,
                                         @RequestParam("loginId") Long loginId){

        try {

            if( file != null && ( loginId != null )){
                Optional<Login> optional = accountService.findById(loginId);
                if( optional.isPresent() ){
                    Login tempLogin = optional.get();
                    tempLogin.getUser().setImage(file.getBytes());
                    accountService.saveUserImage(tempLogin);

                    return ResponseEntityManager.OK.getResponseEntity(tempLogin);
                }

                return ResponseEntityManager.NOT_FOUND.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }

    }

    @PostMapping("/downloadUserImage")
    public ResponseEntity<?> downloadUserImage(@RequestBody Login login){

        try{

            if( login != null && login.getId() != null ){
                Optional<Login> optional = accountService.findById(login.getId());
                if( optional.isPresent() ) {

                    byte[] fileContent = optional.get().getUser().getImage();
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(fileContent);

                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
                    headers.add("Pragma", "no-cache");
                    headers.add("Expires", "0");

                    InputStreamResource inputStreamResource = new InputStreamResource(byteArrayInputStream);
                    return ResponseEntity.ok().headers(headers)
                            .contentLength(fileContent.length)
                            .contentType(org.springframework.http.MediaType.parseMediaType("application/octet-stream"))
                            .body(inputStreamResource);

                }
                return ResponseEntityManager.NOT_FOUND.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (IOException e){
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity("server can not read user Image file");
        }catch (Exception e){
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }

    }

    @PostMapping("/updateProfile")
    public ResponseEntity<?> updateProfile(@RequestBody Login login){

        try {

            return (login != null && login.getId() != null) ?
                    ResponseEntityManager.OK.getResponseEntity( (accountService.update(login)) ):
                    ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (NotFoundException e){
            e.printStackTrace();
            return ResponseEntityManager.NOT_FOUND.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }


    }

    @PostMapping("/deleteProfile")
    public ResponseEntity<?> deleteProfile(@RequestBody Login login){

        try {
            if( login != null && login.getId() != null ){
                accountService.delete(login.getId());
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();


        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }
    }


    @PostMapping("/updateUserNamePassword")
    public ResponseEntity<?> updateUserNamePassword(@RequestBody UserNamePassword userNamePassword){

        if( userNamePassword != null && userNamePassword.getId() != null && userNamePassword.getId() != null &&
                userNamePassword.getPassword() != null && userNamePassword.getUserName() != null ){

            try{
                return ResponseEntityManager.OK.getResponseEntity(accountService.update(userNamePassword));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }

        }

        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

    }

    @PostMapping("/updateAddress")
    public ResponseEntity<?> updateAddress(@RequestBody Address address){

        if( address != null && address.getId() != null ){
            try{
                return ResponseEntityManager.OK.getResponseEntity(accountService.update(address));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

    }

    @PostMapping("/updateContactDetail")
    public ResponseEntity<?> updateContactDetail(@RequestBody ContactDetail contactDetail){

        if( contactDetail != null && contactDetail.getId() != null ){

            try{
                return ResponseEntityManager.OK.getResponseEntity(accountService.update(contactDetail));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(){
        //TODO Refactor This Method;
        return null;
    }


}
