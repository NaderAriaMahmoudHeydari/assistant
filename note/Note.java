package com.nader.aria.assistant_blue.entities.note;


import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.enums.NoteType;

import javax.persistence.*;

@Entity
@Table(name="NOTES" , uniqueConstraints = { @UniqueConstraint( columnNames = {"NOTE_TYPE","CONTENT"} ) } )
@NamedQueries({
        @NamedQuery(name=Note.FIND_ALL,query = "select n from Note as n "),
        @NamedQuery(name=Note.FIND_ALL_BY_NOTE_MANGER,query = "select n from Note as n where n.noteManager = :noteManager")
})
public class Note extends BaseEntity {

    public static final String FIND_ALL = "Note.findAll";
    public static final String FIND_ALL_BY_NOTE_MANGER = "Note.findAllByNoteManager";


    @ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name="NOTE_MANAGER_ID" )
    private NoteManager noteManager;

    @Column(name = "RANK")
    private Long rank;

    @Enumerated(EnumType.STRING)
    @Column(name ="NOTE_TYPE")
    private NoteType noteType;

    @Column(name="TITLE")
    private String title;

    @Column(name ="CONTENT")
    private String content;

    public NoteManager getNoteManager(){ return noteManager; }
    public void setNoteManager(NoteManager noteManager){ this.noteManager = noteManager; }

    public Long getRank(){ return rank; }
    public void setRank(Long rank){ this.rank = rank; }

    public NoteType getNoteType(){ return noteType; }
    public void setNoteType(NoteType noteType){ this.noteType = noteType; }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getContent(){ return content; }
    public void setContent(String content){ this.content = content; }

}
