package com.nader.aria.assistant_blue.entities.idea;

import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="IDEAS" , uniqueConstraints = @UniqueConstraint( columnNames= {"TITLE","CODE"}) )
public class Idea extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name="IDEA_MANAGER_ID" )
    private IdeaManager ideaManager;

    @Column(name = "RANK")
    private Long rank;

    @Column(name ="TITLE"   )
    private String title;

    @Column(name ="CODE"   )
    private String code;

    @Column(name ="SUBJECT"   )
    private String subject;

    @Column(name ="TECHNOLOGY_FIELD"   )
    private String technologyField;

    @Column(name ="DESCRIPTION"   )
    private String description;

    @Column(name="COME_TO_MIND_DATE")
    private LocalDate comeToMindDate;

    @Column(name ="CHANCE_TO_BE_DONE"   )
    private Integer chanceToBeDone;

    @Column(name ="SIMILAR"   )
    private boolean similar;

    @Column(name="BUILD_TIME")
    private LocalDate buildTime;

    @Column(name ="NEEDED_CAPITAL"   )
    private Integer neededCapital;

    @OneToMany( cascade = {CascadeType.DETACH,CascadeType.REFRESH} ,fetch = FetchType.LAZY , mappedBy ="dependency")
    private List<Idea> dependencies;

    @ManyToOne( cascade = {CascadeType.DETACH,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
    @JoinColumn(name="DEPENDENCY_ID"  )
    private Idea dependency;


    public IdeaManager getIdeaManager(){ return ideaManager; }
    public void setIdeaManager(IdeaManager ideaManager){ this.ideaManager = ideaManager; }

    public Long getRank(){ return rank; }
    public void setRank(Long rank){ this.rank = rank; }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getCode(){ return code; }
    public void setCode(String code){ this.code = code; }

    public String getSubject(){ return subject; }
    public void setSubject(String subject){ this.subject = subject; }

    public String getTechnologyField(){ return technologyField; }
    public void setTechnologyField(String technologyField){ this.technologyField = technologyField; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description = description; }

    public LocalDate getComeToMindDate(){ return comeToMindDate; }
    public void setComeToMindDate(LocalDate comeToMindDate){ this.comeToMindDate = comeToMindDate; }

    public Integer getChanceToBeDone(){ return chanceToBeDone; }
    public void setChanceToBeDone(Integer chanceToBeDone){ this.chanceToBeDone = chanceToBeDone; }

    public boolean isSimilar(){ return similar; }
    public void setSimilar(boolean similar){ this.similar = similar; }

    public LocalDate getBuildTime(){ return buildTime; }
    public void setBuildTime(LocalDate buildTime){ this.buildTime = buildTime; }

    public Integer getNeededCapital(){ return neededCapital; }
    public void setNeededCapital(Integer neededCapital){ this.neededCapital = neededCapital; }

    public List<Idea> getDependencies(){ return dependencies; }
    public void setDependencies(List<Idea> dependencies){ this.dependencies = dependencies; }

    public Idea getDependency(){ return dependency; }
    public void setDependency(Idea dependency){ this.dependency = dependency; }

}
