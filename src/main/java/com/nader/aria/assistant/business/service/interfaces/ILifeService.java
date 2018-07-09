package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.life.Aim;

import java.util.List;

public interface ILifeService  {

    public List<Aim> getAimList(Long loginId) throws Exception;
}
