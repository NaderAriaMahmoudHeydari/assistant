package com.nader.aria.assistant.dao.life_repository;

import com.nader.aria.assistant.entities.enums.AimTimeType;
import com.nader.aria.assistant.entities.enums.AimType;
import com.nader.aria.assistant.entities.enums.StateType;
import com.nader.aria.assistant.entities.life.Aim;
import com.nader.aria.assistant.entities.life.Life;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface IAimRepository extends JpaRepository<Aim,Long>{

    public List<Aim> findAllByAimType(@Param("aimType") AimType aimType);
    public List<Aim> findAllByAimTimeType(@Param("aimTimeType") AimTimeType aimTimeType);
    public List<Aim> findAllByStateType(@Param("stateType") StateType stateType);
    public List<Aim> findAllByLife(@Param("life") Life life);
    public Aim findAimByTitle(@Param("title") String title);
    public Aim findAimByCode(@Param("code") String code);

}
