package com.nader.aria.assistant.dao.account_repository;

import com.nader.aria.assistant.entities.account.UserNamePassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IUserNamePasswordRepository extends JpaRepository<UserNamePassword,Long> {

    public UserNamePassword findByUserName(@Param("userName") String userName);
    public UserNamePassword findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
