package com.nader.aria.assistant_blue.entities.idea;

import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Login;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="IDEA_MANAGERS")
public class IdeaManager extends BaseEntity {

    @OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany( cascade = {CascadeType.ALL},fetch = FetchType.LAZY , mappedBy ="ideaManager")
    private List<Idea> ideas;

    public Login getLogin(){ return login; }
    public void setLogin(Login login){ this.login = login; }

    public List<Idea> getIdeas(){ return ideas; }
    public void setIdeas(List<Idea> ideas){ this.ideas = ideas; }


}
