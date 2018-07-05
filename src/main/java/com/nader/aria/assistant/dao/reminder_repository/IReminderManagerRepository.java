package com.nader.aria.assistant.dao.reminder_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.reminder.ReminderManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IReminderManagerRepository extends JpaRepository<ReminderManager,Long> {

    public ReminderManager findByLogin(@Param("login") Login login);

}
