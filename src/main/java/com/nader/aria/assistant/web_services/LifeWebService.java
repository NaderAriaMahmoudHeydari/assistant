package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.interfaces.ILifeService;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.*;
import com.nader.aria.assistant.entities.life.Aim;
import com.nader.aria.assistant.entities.life.Sprint;
import com.nader.aria.assistant.entities.life.Task;
import com.nader.aria.assistant.entities.life.TaskLog;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import com.nader.aria.assistant.entities.enums.TaskType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/life")
public class LifeWebService {

    private ILifeService lifeService;

    @Autowired
    public LifeWebService(ILifeService lifeService){
        this.lifeService = lifeService;
    }


    @GetMapping("/getAimTypes")
    public ResponseEntity<?> getAimTypes(){

        return ResponseEntityManager.OK.getResponseEntity(AimType.values());
    }

    @GetMapping("/getAimTimeTypes")
    public ResponseEntity<?> getAimTimeTypes() {

        return ResponseEntityManager.OK.getResponseEntity(AimTimeType.values());
    }

    @GetMapping("/getStateTypes")
    public ResponseEntity<?> getStateTypes(){

        return ResponseEntityManager.OK.getResponseEntity(StateType.values());
    }

    @GetMapping("/getPriorityTypes")
    public ResponseEntity<?> getPriorityTypes(){

        return ResponseEntityManager.OK.getResponseEntity(PriorityType.values());
    }

    @GetMapping("/getTaskTimeTypes")
    public ResponseEntity<?> getTaskTimeTypes(){

        return ResponseEntityManager.OK.getResponseEntity(TaskTimeType.values());
    }

    @GetMapping("/getTaskTypes")
    public ResponseEntity<?> getTaskTypes(){

        return ResponseEntityManager.OK.getResponseEntity(TaskType.values());
    }

    @PostMapping("/addAim")
    public ResponseEntity<?> saveAim(@RequestBody Aim aim){

        try{

            if( aim != null && aim.getLife() != null && aim.getLife().getId() != null ){
                return ResponseEntityManager.CREATED.getResponseEntity(lifeService.save(aim));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/aimList")
    public ResponseEntity<?> getAimList(@RequestBody Login login ){

        try {
            return ResponseEntityManager.OK.getResponseEntity(lifeService.getAimList(login));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntityManager.NOT_FOUND.getResponseEntity();

    }

    @PostMapping("/readAim")
    public ResponseEntity<?> readAim(@RequestBody Long aimId){

        if( aimId != null ){

            try{
                return ResponseEntityManager.OK.getResponseEntity(lifeService.getAim(aimId));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateAim")
    public ResponseEntity<?> updateAim(@RequestBody Aim aim){

        try{

            if( aim != null && aim.getId() != null ){
                return ResponseEntityManager.OK.getResponseEntity(lifeService.save(aim));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();

    }

    @PostMapping("/deleteAim")
    public ResponseEntity<?> deleteAim(@RequestBody Aim aim) {
        try{

            if( aim != null && aim.getId() != null ){
                lifeService.delete(aim);
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteSelectedAim")
    public ResponseEntity<?> deleteAim(@RequestBody Long aimId){

        try{

            if( aimId != null ){
                lifeService.deleteSelectedAim(aimId);
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteAllAim")
    public ResponseEntity<?> deleteAllAim(){

        try{


            lifeService.deleteAllAim();
            return ResponseEntityManager.OK.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteAllSelectedAim")
    public ResponseEntity<?> deleteAllSelectedAim(@RequestBody List<Aim> aims){

        try{


            lifeService.deleteAllAim(aims);

            return ResponseEntityManager.OK.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/addSprint")
    public ResponseEntity<?> saveSprint(@RequestBody Sprint sprint){

        try{

            if( sprint != null && sprint.getAim() != null && sprint.getAim().getId() != null ){
                return ResponseEntityManager.CREATED.getResponseEntity(lifeService.save(sprint));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();

    }

    @PostMapping("/sprintList")
    public ResponseEntity<?> getSprintList(@RequestBody Aim aim){

        try{

            if( aim != null && aim.getId() != null ){

                return ResponseEntityManager.OK.getResponseEntity(lifeService.getSprintList(aim));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @GetMapping("/sprintList/{aimId}")
    public ResponseEntity<?> getSprintList(@PathVariable(value = "aimId") Long aimId){

        try{

            if( aimId != null ){
                Aim temp = new Aim();
                temp.setId(aimId);
                return ResponseEntityManager.OK.getResponseEntity( lifeService.getSprintList(temp));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/readSprint")
    public ResponseEntity<?> readSprint(@RequestBody Long sprintId){

       if( sprintId != null ){
           try{
               Optional<Sprint> optional = lifeService.readSprint(sprintId);
               return ( optional.isPresent() ) ?
                      ResponseEntityManager.OK.getResponseEntity(optional.get()) :
                      ResponseEntityManager.NOT_FOUND.getResponseEntity();
           }catch (Exception e){
               e.printStackTrace();
               return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
           }
       }
       return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateSprint")
    public ResponseEntity<?> updateSprint(@RequestBody Sprint sprint){

        try{

            if( sprint != null && sprint.getId() != null ){
                return ResponseEntityManager.OK.getResponseEntity(lifeService.save(sprint));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();

    }

    @PostMapping("/deleteSprint")
    public ResponseEntity<?> deleteSprint(@RequestBody Sprint sprint) {
        try{

            if( sprint != null && sprint.getId() != null ){
                lifeService.delete(sprint);
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteSelectedSprint")
    public ResponseEntity<?> deleteSprint(@RequestBody Long sprintId){

        try{

            if( sprintId != null ){
                lifeService.deleteSelectedSprint(sprintId);
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteAllSprint")
    public ResponseEntity<?> deleteAllSprint(){

        try{


            lifeService.deleteAllSprint();
            return ResponseEntityManager.OK.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteAllSelectedSprint")
    public ResponseEntity<?> deleteAllSelectedSprint(@RequestBody List<Sprint> sprints){

        try{


            lifeService.deleteAllSprint(sprints);

            return ResponseEntityManager.OK.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> saveTask(@RequestBody Task task){

        try{

            if( task != null && task.getSprint() != null && task.getSprint().getId() != null ){
                return ResponseEntityManager.CREATED.getResponseEntity(lifeService.save(task));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();

    }

    @PostMapping("/taskList")
    public ResponseEntity<?> getTaskList(@RequestBody Sprint sprint){

        try{

            if( sprint != null && sprint.getId() != null ){

               return ResponseEntityManager.OK.getResponseEntity(lifeService.getTaskList(sprint));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @GetMapping("/taskList/{sprintId}")
    public ResponseEntity<?> getTaskList(@PathVariable("sprintId") Long sprintId){

        try{
            if( sprintId != null ){

                Sprint temp = new Sprint();
                temp.setId(sprintId);
                return ResponseEntityManager.OK.getResponseEntity(lifeService.getTaskList(temp));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/readTask")
    public ResponseEntity<?> readTask(@RequestBody Long taskId){

        if( taskId != null ){
            try{
                Optional<Task> optional = lifeService.readTask(taskId);
                return ( optional.isPresent() )?
                        ResponseEntityManager.OK.getResponseEntity(optional.get()) :
                        ResponseEntityManager.NOT_FOUND.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @GetMapping("/subTaskList/{parentTaskId}")
    public ResponseEntity<?> getSubTaskList(@PathVariable("parentTaskId") Long parentTaskId ) {

        try {

            if (parentTaskId != null) {
                return ResponseEntityManager.OK.getResponseEntity(lifeService.getAllSubTask(parentTaskId));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }

    }

    @PostMapping("/updateTask")
    public ResponseEntity<?> updateTask(@RequestBody Task task){

        try{

            if( task != null && task.getId() != null ){

                return ResponseEntityManager.OK.getResponseEntity(lifeService.save(task));
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();

    }

    @PostMapping("/deleteTask")
    public ResponseEntity<?> deleteTask(@RequestBody Task task) {
        try{

            if( task != null && task.getId() != null ){
                lifeService.delete(task);
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteSelectedTask")
    public ResponseEntity<?> deleteTask(@RequestBody Long taskId){

        try{

            if( taskId != null ){
                lifeService.deleteSelectedTask(taskId);
                return ResponseEntityManager.OK.getResponseEntity();
            }
            return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteAllTask")
    public ResponseEntity<?> deleteAllTask(){

        try{


            lifeService.deleteAllTask();
            return ResponseEntityManager.OK.getResponseEntity();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/deleteAllSelectedTask")
    public ResponseEntity<?> deleteAllSelectedTask(@RequestBody List<Task> tasks){

        try{


            lifeService.deleteAllTask(tasks);

            return ResponseEntityManager.OK.getResponseEntity();

        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
    }

    @PostMapping("/addTaskLog")
    public ResponseEntity<?> addTaskLog(@RequestBody TaskLog taskLog){

        if( taskLog != null && taskLog.getTask() != null && taskLog.getTask().getId() != null ){
            try{
                return ResponseEntityManager.CREATED.getResponseEntity(lifeService.save(taskLog));
            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readTaskLogs")
    public ResponseEntity<?> readTaskLogs(@RequestBody Task task){

        try{

            if( task != null && task.getId() != null ){
                return ResponseEntityManager.OK.getResponseEntity( lifeService.getAllTaskLog(task));
            }else {
                return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
        }
    }

    @PostMapping("/readTaskLog")
    public ResponseEntity<?> readTaskLog(@RequestBody Long taskLogId){

        if( taskLogId != null ){
            try{
                Optional<TaskLog> optional = lifeService.readTaskLog(taskLogId);
                return ( optional.isPresent() )?
                        ResponseEntityManager.OK.getResponseEntity(optional.get()):
                        ResponseEntityManager.NOT_FOUND.getResponseEntity();
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateTaskLog")
    public ResponseEntity<?> updateTaskLog(@RequestBody TaskLog taskLog){

        if( taskLog != null && taskLog.getId() != null ) {
            try {

                return ResponseEntityManager.OK.getResponseEntity(lifeService.save(taskLog));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteTaskLog")
    public ResponseEntity<?> deleteTaskLog(@RequestBody TaskLog taskLog){

        if( taskLog != null && taskLog.getId() != null ){
            try{

                lifeService.delete(taskLog);
                return ResponseEntityManager.OK.getResponseEntity();

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }

        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteAllTaskLogForSelectedTask")
    public ResponseEntity<?> deleteAllTaskLog(@RequestBody Task task){

        if( task != null && task.getId() != null ){
            try{

                lifeService.deleteAllTaskLogOnTask(task);
                ResponseEntityManager.OK.getResponseEntity();

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }

        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

    }


}

