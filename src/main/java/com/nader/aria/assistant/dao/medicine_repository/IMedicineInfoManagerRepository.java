package com.nader.aria.assistant.dao.medicine_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.medicine.MedicineInfoManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;



public interface IMedicineInfoManagerRepository extends JpaRepository<MedicineInfoManager,Long> {

    public MedicineInfoManager findByLogin(@Param("login") Login login);

}
