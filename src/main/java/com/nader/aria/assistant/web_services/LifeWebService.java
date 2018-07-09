package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.interfaces.ILifeService;
import com.nader.aria.assistant.entities.life.Aim;
import com.nader.aria.assistant.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/life")
public class LifeWebService {

    private ILifeService lifeService;

    @Autowired
    public LifeWebService(ILifeService lifeService){
        this.lifeService = lifeService;
    }


    @GetMapping("/aimList")
    public ResponseEntity<List<Aim>> getAimList(@RequestBody LoginModel loginModel ){

        try {
            return new ResponseEntity<>(lifeService.getAimList(loginModel.getId()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
    }

}
