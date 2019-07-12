package com.nader.aria.assistant_blue.entities.phone_book;



import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.ContactSpecificity;
import com.nader.aria.assistant_blue.entities.enums.PhoneType;

import javax.persistence.*;


@Entity
@Table(name = "PHONES",uniqueConstraints = @UniqueConstraint(columnNames={"PHONE_TYPE","NUMBER"}))
@NamedQueries({
        @NamedQuery(name = Phone.FIND_ALL_BY_CONTACT_TYPE,query = "select p from Phone as p where p.phoneType =: phoneType"),
        @NamedQuery(name = Phone.FIND_ALL_BY_PHONE,query = "select p from Phone as p where p.number =: number")
})
public class Phone extends BaseEntity {

    public static final String FIND_ALL_BY_CONTACT_TYPE = "Phone.findAllByContactType";
    public static final String FIND_ALL_BY_PHONE = "Phone.findAllByPhone";

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER)
    @JoinColumn(name="CONTACT_SPECIFICITY_ID")
    private ContactSpecificity contactSpecificity;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER)
    @JoinColumn(name="USER_CONTACT_ID")
    private UserContact userContact;

    @Enumerated(EnumType.STRING)
    @Column(name="PHONE_TYPE")
    private PhoneType phoneType;

    @Column(name ="NUMBER")
    private String number;

    public ContactSpecificity getContactSpecificity(){ return contactSpecificity; }
    public void setContactSpecificity(ContactSpecificity contactSpecificity){ this.contactSpecificity = contactSpecificity; }

    public UserContact getUserContact(){ return userContact; }
    public void setUserContact(UserContact userContact){ this.userContact = userContact; }

    public PhoneType getPhoneType(){ return phoneType; }
    public void setPhoneType(PhoneType phoneType){ this.phoneType = phoneType; }

    public String getNumber(){ return number; }
    public void setNumber(String number){ this.number = number; }

}
