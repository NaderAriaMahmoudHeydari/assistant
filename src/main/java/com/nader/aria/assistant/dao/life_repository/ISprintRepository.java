package com.nader.aria.assistant.dao.life_repository;

import com.nader.aria.assistant.entities.enums.StateType;
import com.nader.aria.assistant.entities.life.Aim;
import com.nader.aria.assistant.entities.life.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;


public interface ISprintRepository extends JpaRepository<Sprint,Long> {

    public List<Sprint> findAllByStartDate(@Param("startDate") Calendar startDate);
    public List<Sprint> findAllByEndDate(@Param("endDate") Calendar endDate);
    public List<Sprint> findAllByStartDateAndEndDate(@Param("startDate") Calendar startDate, @Param("endDate") Calendar endDate);
    public List<Sprint> findAllByStateType(@Param("stateType") StateType stateType);
    public List<Sprint> findAllByAim(@Param("aim") Aim aim);
    public Sprint findByTitle(@Param("title") String title);
    public Sprint findByCode(@Param("code") String code);

}
