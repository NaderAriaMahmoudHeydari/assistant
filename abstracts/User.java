package com.nader.aria.assistant_blue.entities.abstracts;

import com.nader.aria.assistant_blue.entities.account.Address;
import com.nader.aria.assistant_blue.entities.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="USERS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE" , discriminatorType = DiscriminatorType.STRING )
public abstract class User extends BaseEntity {

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME"  )
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    private Gender gender;

    @Column(name="BIRTH_DAY"  )
    private LocalDate birthDay;

    @OneToOne(cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER)
    @JoinColumn(name="ADDRESS_ID"  )
    private Address address;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Gender getGender() { return gender; }
    public void setGender(Gender gender) { this.gender = gender; }

    public LocalDate getBirthDay(){ return birthDay; }
    public void setBirthDay(LocalDate birthDay){ this.birthDay = birthDay; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

}
