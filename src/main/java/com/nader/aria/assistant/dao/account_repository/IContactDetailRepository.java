package com.nader.aria.assistant.dao.account_repository;

import com.nader.aria.assistant.entities.account.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IContactDetailRepository extends JpaRepository<ContactDetail,Long> {

     public ContactDetail findByPhone(@Param("phone") String phone);
     public ContactDetail findByCell(@Param("cell") String cell);
     public ContactDetail findByEmail(@Param("email") String email);
    
}
