package com.nader.aria.assistant.business.service.interfaces;

import com.nader.aria.assistant.entities.abstracts.Message;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.reminder.Reminder;

import java.util.List;
import java.util.Optional;

public interface IReminderService {

  
    public Reminder addReminder( Reminder reminder) throws Exception;
    
    public List<Reminder> getAllReminder(Login login) throws Exception;

    public Optional<Reminder> readReminder(Long reminderId) throws Exception;

    public Reminder updateReminder( Reminder reminder) throws Exception;

    public void deleteReminder( Reminder reminder) throws Exception;

    public Message addMessage( Message message) throws Exception;

    public List<Message> getAllMessage( Reminder reminder) throws Exception;

    public Optional<Message> readMessage( Long messageId) throws Exception;

    public Message updateMessage( Message message) throws Exception;

    public void deleteMessage( Message message) throws Exception;

}
