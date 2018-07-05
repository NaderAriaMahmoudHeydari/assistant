package com.nader.aria.assistant.dao.life_repository;

import com.nader.aria.assistant.entities.enums.PriorityType;
import com.nader.aria.assistant.entities.enums.TaskType;
import com.nader.aria.assistant.entities.financial.Financial;
import com.nader.aria.assistant.entities.life.Sprint;
import com.nader.aria.assistant.entities.life.Task;
import com.nader.aria.assistant.entities.reminder.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;


public interface ITaskRepository extends JpaRepository<Task,Long> {

    public List<Task> findAllByPriorityType(@Param("priorityType") PriorityType priorityType);
    public List<Task> findAllByTaskType(@Param("taskType") TaskType taskType);
    public List<Task> findAllByTimePrediction(@Param("timePrediction") Calendar timePrediction);
    public List<Task> findAllBySprint(@Param("sprint") Sprint sprint);
    public List<Task> findAllByDependency(@Param("dependency") Task dependency);
    public Task findByTitle(@Param("title") String title);
    public Task findByCode(@Param("code") String code);
    public Task findByFinancial(@Param("financial") Financial financial);
    public Task findByReminder(@Param("reminder") Reminder reminder);

}
