package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.medicine.DrugInfoManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IDrugInfoManagerRepository extends JpaRepository<DrugInfoManager,Long> {

    public DrugInfoManager findByLogin(@Param("login") Login login);
}
