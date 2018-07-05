package com.nader.aria.assistant.dao.life_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.life.Life;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ILifeRepository extends JpaRepository<Life,Long> {

    public Life findByLogin(@Param("login") Login login);

}
