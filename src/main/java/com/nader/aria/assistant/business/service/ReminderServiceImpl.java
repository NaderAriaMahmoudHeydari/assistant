package com.nader.aria.assistant.business.service;

import com.nader.aria.assistant.business.service.interfaces.IReminderService;
import com.nader.aria.assistant.dao.reminder_repository.IMessageRepository;
import com.nader.aria.assistant.dao.reminder_repository.IReminderManagerRepository;
import com.nader.aria.assistant.dao.reminder_repository.IReminderRepository;
import com.nader.aria.assistant.entities.abstracts.Message;
import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.reminder.Reminder;
import com.nader.aria.assistant.entities.reminder.ReminderManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements IReminderService{

    private IReminderManagerRepository reminderManagerRepository;
    private IReminderRepository reminderRepository;
    private IMessageRepository messageRepository;

    @Autowired
    public ReminderServiceImpl( IReminderManagerRepository reminderManagerRepository ,
                                IReminderRepository reminderRepository ,
                                IMessageRepository messageRepository ){

        this.reminderManagerRepository = reminderManagerRepository;
        this.reminderRepository = reminderRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    @Transactional
    public Reminder addReminder(Reminder reminder) throws Exception{
        return reminderRepository.save( reminder );
    }

    @Override
    @Transactional
    public List<Reminder> getAllReminder(Login login) throws Exception{
        ReminderManager reminderManager = reminderManagerRepository.findByLogin(login);
        return reminderRepository.findAllByReminderManager(reminderManager);
    }

    @Override
    @Transactional
    public Optional<Reminder> readReminder(Long reminderId) throws Exception{
        return reminderRepository.findById(reminderId);
    }

    @Override
    @Transactional
    public Reminder updateReminder( Reminder reminder) throws Exception{
        return reminderRepository.save(reminder);
    }

    @Override
    @Transactional
    public void deleteReminder( Reminder reminder) throws Exception{
        reminderRepository.delete(reminder);
    }

    @Override
    @Transactional
    public Message addMessage(Message message) throws Exception{
        return (Message) messageRepository.save(message);
    }

    @Override
    @Transactional
    public List<Message> getAllMessage( Reminder reminder) throws Exception{
        return messageRepository.findAllByReminder(reminder);
    }

    @Override
    @Transactional
    public Optional<Message> readMessage( Long messageId) throws Exception{
        return messageRepository.findById(messageId);
    }

    @Override
    @Transactional
    public Message updateMessage( Message message) throws Exception{
        return (Message) messageRepository.save(message);
    }

    @Override
    @Transactional
    public void deleteMessage( Message message) throws Exception{
        messageRepository.delete(message);
    }
}
