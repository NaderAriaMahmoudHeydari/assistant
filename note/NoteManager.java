package com.nader.aria.assistant_blue.entities.note;


import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Login;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="NOTE_MANAGER")
@NamedQuery(name=NoteManager.FIND_BY_LOGIN,query = "select i from NoteManager as i where i.login =:login")
public class NoteManager extends BaseEntity {

    public static final String FIND_BY_LOGIN = "NoteManager.findByLogin";

    @OneToOne( cascade = {CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany( cascade = {CascadeType.ALL},fetch = FetchType.LAZY , mappedBy ="noteManager")
    private List<Note> notes;

    public Login getLogin(){ return login; }
    public void setLogin(Login login){ this.login = login; }

    public List<Note> getNotes(){ return notes; }
    public void setNotes(List<Note> notes){ this.notes = notes; }

}
