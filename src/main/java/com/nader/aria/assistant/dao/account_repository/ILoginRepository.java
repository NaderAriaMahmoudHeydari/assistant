package com.nader.aria.assistant.dao.account_repository;

import com.nader.aria.assistant.entities.account.Login;
import com.nader.aria.assistant.entities.account.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ILoginRepository extends JpaRepository<Login,Long> {

     public Login findByUserNamePasswordUserNameAndUserNamePasswordPassword(@Param("userName") String userName, @Param("password") String password);
     public Login findByUser(@Param("user") User user);

     @Query(value = " select l.userNamePassword.userName from Login as l ")
     public List<String> findAllUserName();
}
