package com.nader.aria.assistant.dao.idea_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.idea.IdeaManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IdeaManagerRepository extends JpaRepository<IdeaManager,Long> {

    public IdeaManager findByLogin(@Param("login") Login login);

}
