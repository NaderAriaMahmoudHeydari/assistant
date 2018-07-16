package com.nader.aria.assistant.dao.reminder_repository;

import com.nader.aria.assistant.entities.abstracts.Message;
import com.nader.aria.assistant.entities.reminder.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;

public interface IMessageRepository<M extends Message> extends JpaRepository<Message,Long> {

    public List<M> findAllByReminder(@Param("reminder") Reminder reminder);
    public List<M> findAllByExpirationDate(@Param("expirationDate") Calendar expirationDate);
    public M findByTitle(@Param("title") String title);
    public M findByMessage(@Param("message") String message);

}
