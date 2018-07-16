package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.life.Aim;
import com.nader.aria.assistant.entities.life.Sprint;
import com.nader.aria.assistant.entities.life.Task;
import com.nader.aria.assistant.entities.life.TaskLog;

import java.util.List;
import java.util.Optional;

public interface ILifeService  {

    public Aim save(Aim aim) throws Exception;

    public List<Aim> getAimList(Login login) throws Exception;

    public Optional<Aim> getAim(Long aimId) throws Exception;

    public void delete(Aim aim) throws Exception;

    public void deleteSelectedAim(Long aimId) throws Exception;

    public void deleteAllAim() throws Exception;

    public void deleteAllAim(List<Aim> aims) throws Exception;

    public Sprint save(Sprint sprint) throws Exception;

    public List<Sprint> getSprintList(Aim aim) throws Exception;

    public Optional<Sprint> readSprint(Long sprintId) throws Exception;

    public void delete(Sprint sprint) throws Exception;

    public void deleteSelectedSprint(Long sprintId) throws Exception;

    public void deleteAllSprint() throws Exception;

    public void deleteAllSprint(List<Sprint> sprints) throws Exception;

    public Task save(Task task) throws Exception;

    public List<Task> getTaskList(Sprint sprint) throws Exception;

    public Optional<Task> readTask(Long taskId) throws Exception;

    public List<Task> getAllSubTask(Long parentTaskId) throws Exception;

    public void delete(Task task) throws Exception;

    public void deleteSelectedTask(Long taskId) throws Exception;

    public void deleteAllTask() throws Exception;

    public void deleteAllTask(List<Task> tasks) throws Exception;

    public TaskLog save(TaskLog taskLog) throws Exception;

    public List<TaskLog> getAllTaskLog(Task task) throws Exception;

    public Optional<TaskLog> readTaskLog(Long taskLogId) throws Exception;

    public void delete(TaskLog taskLog) throws Exception;

    public void deleteAllTaskLogOnTask(Task task) throws Exception;




}
