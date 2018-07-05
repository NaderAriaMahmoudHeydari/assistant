package com.nader.aria.assistant.dao.account_repository;

import com.nader.aria.assistant.entities.account.Address;
import com.nader.aria.assistant.entities.account.ContactDetail;
import com.nader.aria.assistant.entities.account.User;
import com.nader.aria.assistant.entities.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.Calendar;
import java.util.List;

public interface IUserRepository extends JpaRepository<User,Long> {

    public List<User> findAllByGender(@Param("gender") Gender gender);
    public List<User> findAllByBirthDay(@Param("birthDay") Calendar birthDay);
    public User findByAddress(@Param("address") Address address);
    public User findByContactDetail(@Param("contactDetail") ContactDetail contactDetail);
    public User findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

}
