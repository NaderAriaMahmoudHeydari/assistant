package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.ILifeService;
import com.nader.aria.assistant.dao.life_repository.*;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.life.Aim;
import com.nader.aria.assistant.entities.life.Sprint;
import com.nader.aria.assistant.entities.life.Task;
import com.nader.aria.assistant.entities.life.TaskLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LifeServiceImpl implements ILifeService {



    private ILifeRepository lifeRepository;
    private IAimRepository aimRepository;
    private ISprintRepository sprintRepository;
    private ITaskRepository taskRepository;
    private ITaskLogRepository taskLogRepository;

    @Autowired
    public LifeServiceImpl(ILifeRepository lifeRepository , IAimRepository aimRepository ,
                           ISprintRepository sprintRepository , ITaskRepository taskRepository ,
                           ITaskLogRepository taskLogRepository ){

        this.lifeRepository = lifeRepository;
        this.aimRepository = aimRepository;
        this.sprintRepository = sprintRepository;
        this.taskRepository = taskRepository;
        this.taskLogRepository = taskLogRepository;

    }

    @Override
    @Transactional
    public Aim save(Aim aim) throws Exception{

        return aimRepository.save(aim);
    }

    @Override
    @Transactional
    public List<Aim> getAimList(Login login) throws Exception {

       return lifeRepository.findByLogin(login).getAims();

    }

    @Override
    @Transactional
    public Optional<Aim> getAim(Long aimId) throws Exception{
        return aimRepository.findById(aimId);
    }

    @Override
    @Transactional
    public void delete(Aim aim) throws Exception{
        aimRepository.delete(aim);
    }

    @Override
    @Transactional
    public void deleteSelectedAim(Long aimId) throws Exception{
        aimRepository.deleteById(aimId);
    }

    @Override
    @Transactional
    public void deleteAllAim() throws Exception{
        aimRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteAllAim(List<Aim> aims) throws Exception{
        aimRepository.deleteAll(aims);
    }

    @Override
    @Transactional
    public Sprint save(Sprint sprint) throws Exception{
        return sprintRepository.save(sprint);
    }

    @Override
    @Transactional
    public List<Sprint> getSprintList(Aim aim) throws Exception{
        return sprintRepository.findAllByAim(aim);
    }

    @Override
    @Transactional
    public Optional<Sprint> readSprint(Long sprintId) throws Exception{
        return sprintRepository.findById(sprintId);
    }

    @Override
    @Transactional
    public void delete(Sprint sprint) throws Exception{
        sprintRepository.delete(sprint);
    }

    @Override
    @Transactional
    public void deleteSelectedSprint(Long sprintId) throws Exception{
        sprintRepository.deleteById(sprintId);
    }

    @Override
    @Transactional
    public void deleteAllSprint() throws Exception{
        sprintRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteAllSprint(List<Sprint> sprints) throws Exception{
        sprintRepository.deleteAll(sprints);
    }

    @Override
    @Transactional
    public Task save(Task task) throws Exception{
        return  taskRepository.save(task);
    }

    @Override
    @Transactional
    public List<Task> getTaskList(Sprint sprint) throws Exception{
        return taskRepository.findAllBySprint(sprint);
    }

    @Override
    @Transactional
    public Optional<Task> readTask(Long taskId) throws Exception{
        return taskRepository.findById(taskId);
    }

    @Override
    @Transactional
    public List<Task> getAllSubTask(Long parentTaskId) throws Exception{

        Optional<Task> parentTask = taskRepository.findById(parentTaskId);
        if( parentTask.isPresent() ){
            return taskRepository.findAllByDependency(parentTask.get());
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(Task task) throws Exception{
        taskRepository.delete(task);
    }

    @Override
    @Transactional
    public void deleteSelectedTask(Long taskId) throws Exception{
        taskRepository.deleteById(taskId);
    }

    @Override
    @Transactional
    public void deleteAllTask() throws Exception{
        taskRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteAllTask(List<Task> tasks) throws Exception{
        taskRepository.deleteAll(tasks);
    }

    @Override
    @Transactional
    public TaskLog save(TaskLog taskLog) throws Exception{
        return taskLogRepository.save( taskLog );
    }

    @Override
    @Transactional
    public List<TaskLog> getAllTaskLog(Task task) throws Exception {
        return taskLogRepository.findAllByTask(task);
    }

    @Override
    @Transactional
    public Optional<TaskLog> readTaskLog(Long taskLogId) throws Exception{
        return taskLogRepository.findById(taskLogId);
    }

    @Override
    @Transactional
    public void delete(TaskLog taskLog) throws Exception{
        taskLogRepository.delete( taskLog );
    }


    @Override
    @Transactional
    public void deleteAllTaskLogOnTask(Task task) throws Exception{

        Optional<Task> optionalTask = taskRepository.findById(task.getId());
        if( optionalTask.isPresent() ){
            List<TaskLog> tempTaskLog = taskLogRepository.findAllByTask(optionalTask.get());
            taskLogRepository.deleteAll(tempTaskLog);
        }

    }


}
