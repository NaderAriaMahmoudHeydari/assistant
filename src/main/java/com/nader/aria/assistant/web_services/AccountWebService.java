package com.nader.aria.assistant.web_services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/account")
public class AccountWebService {

    @GetMapping(value = "/")
    public String index(){
        return "Authorize Fail;";
    }


}
