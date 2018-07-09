package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.ILifeService;
import com.nader.aria.assistant.dao.account_repository.ILoginRepository;
import com.nader.aria.assistant.dao.life_repository.ILifeRepository;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.life.Aim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LifeServiceImpl implements ILifeService {

    private ILoginRepository loginRepository;

    private ILifeRepository lifeRepository;

    @Autowired
    public LifeServiceImpl(ILifeRepository lifeRepository , ILoginRepository loginRepository ){
        this.lifeRepository = lifeRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public List<Aim> getAimList(Long loginId) throws Exception {

        Optional<Login> optional = loginRepository.findById(loginId);

        if( optional.isPresent() ){
            Login login = optional.get();
            return lifeRepository.findByLogin(login).getAims();
        }
        return null;
    }
}
