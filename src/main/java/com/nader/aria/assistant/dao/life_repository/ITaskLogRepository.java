package com.nader.aria.assistant.dao.life_repository;

import com.nader.aria.assistant.entities.enums.StateType;
import com.nader.aria.assistant.entities.life.Task;
import com.nader.aria.assistant.entities.life.TaskLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;

public interface ITaskLogRepository extends JpaRepository<TaskLog,Long> {

    public List<TaskLog> findAllByTask(@Param("task") Task task);
    public List<TaskLog> findAllByStateType(@Param("stateType") StateType stateType);
    public List<TaskLog> findAllByStartLog(@Param("startLog") Calendar startLog);
    public List<TaskLog> findAllByEndLog(@Param("endLog") Calendar endLog);
    public List<TaskLog> findAllByStartLogAndEndLog(@Param("startLog") Calendar startLog, @Param("endLog") Calendar endLog);

}
