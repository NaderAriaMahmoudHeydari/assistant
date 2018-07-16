package com.nader.aria.assistant.web_services;

import com.nader.aria.assistant.business.service.interfaces.IReminderService;
import com.nader.aria.assistant.entities.abstracts.Message;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.enums.ReminderState;
import com.nader.aria.assistant.entities.enums.RepetitionType;
import com.nader.aria.assistant.entities.reminder.Reminder;
import com.nader.aria.assistant.entities.enums.MessageType;
import com.nader.aria.assistant.utils.ResponseEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/reminder")
public class ReminderWebService {


    private IReminderService reminderService;

    @Autowired
    public ReminderWebService(IReminderService reminderService){
        this.reminderService = reminderService;
    }

    @GetMapping("/getRepetitionTypes")
    public ResponseEntity<?> getRepetitionTypes(){
        return ResponseEntityManager.OK.getResponseEntity(RepetitionType.values());
    }

    @GetMapping("/getReminderStates")
    public ResponseEntity<?> getReminderStates(){
        return ResponseEntityManager.OK.getResponseEntity(ReminderState.values());
    }

    @GetMapping("/getMessageTypes")
    public ResponseEntity<?> getMessageTypes(){
        return ResponseEntityManager.OK.getResponseEntity(MessageType.values());
    }

    @PostMapping("/addReminder")
    public ResponseEntity<?> addReminder(@RequestBody Reminder reminder){

        if( reminder != null ){

            try{
                return ResponseEntityManager.CREATED.getResponseEntity(reminderService.addReminder(reminder));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/getAllReminder")
    public ResponseEntity<?> getAllReminder(@RequestBody Login login){

        if( login != null && login.getId() != null ){
            try{
                return ResponseEntityManager.OK.getResponseEntity(reminderService.getAllReminder(login));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

    }

    @PostMapping("/readReminder")
    public ResponseEntity<?> readReminder(@RequestBody Long reminderId){
        //TODO add readReminder;
        return null;
    }

    @PostMapping("/updateReminder")
    public ResponseEntity<?> updateReminder(@RequestBody Reminder reminder){

        if( reminder != null && reminder.getId() != null ){
            try{
                return ResponseEntityManager.OK.getResponseEntity(reminderService.updateReminder(reminder));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteReminder")
    public ResponseEntity<?> deleteReminder(@RequestBody Reminder reminder){

        if( reminder != null && reminder.getId() != null ){
            try {

                reminderService.deleteReminder(reminder);
                return ResponseEntityManager.OK.getResponseEntity();

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/addMessage")
    public ResponseEntity<?> addMessage(@RequestBody Message message){

        if( message != null && message.getReminder() != null && message.getReminder().getId() != null ){
            try{

                return ResponseEntityManager.CREATED.getResponseEntity(reminderService.addMessage(message));

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();

    }

    @PostMapping("/getAllMessage")
    public ResponseEntity<?> getAllMessage(@RequestBody Reminder reminder){

        if( reminder!= null && reminder.getId() != null ){

            try {
                return ResponseEntityManager.OK.getResponseEntity(reminderService.getAllMessage(reminder));
            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/readMessage")
    public ResponseEntity<?> readMessage(@RequestBody Long messageId){

        if( messageId != null ){
            try{
                Optional<Message> optional = reminderService.readMessage(messageId);
                return ( optional.isPresent() )?
                        ResponseEntityManager.OK.getResponseEntity(optional.get()) :
                        ResponseEntityManager.NOT_FOUND.getResponseEntity();

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/updateMessage")
    public ResponseEntity<?> updateMessage(@RequestBody Message message){

        if( message != null && message.getId() != null ){

            try{

                return ResponseEntityManager.OK.getResponseEntity(reminderService.updateMessage(message));

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }

    @PostMapping("/deleteMessage")
    public ResponseEntity<?> deleteMessage(@RequestBody Message message){

        if( message != null && message.getId() != null && message.getReminder() == null ){

            try{

                reminderService.deleteMessage(message);
                return ResponseEntityManager.OK.getResponseEntity();

            }catch (Exception e){
                e.printStackTrace();
                return ResponseEntityManager.INTERNAL_SERVER_ERROR.getResponseEntity();
            }
        }
        return ResponseEntityManager.BAD_REQUEST.getResponseEntity();
    }


}
