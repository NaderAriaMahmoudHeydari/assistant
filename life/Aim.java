package com.nader.aria.assistant_blue.entities.life;

import javax.persistence.*;
import java.util.List;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.enums.AimTimeType;
import com.nader.aria.assistant_blue.entities.enums.AimType;
import com.nader.aria.assistant_blue.entities.enums.StateType;
import org.hibernate.annotations.Formula;


@Entity
@Table(name="AIMS" , uniqueConstraints = @UniqueConstraint( columnNames= {"LIFE_ID","TITLE","CODE"}) )
@NamedQueries({
		@NamedQuery(name = Aim.FIND_ALL_BY_LIFE,query = "select a from Aim as a where a.life =:life"),
		@NamedQuery(name = Aim.GET_ALL_AIMS_CODE,query = "select a.code from Aim as a ")
})
public class Aim extends BaseEntity {

	public static final String FIND_ALL_BY_LIFE = "aim.findAllByLife";
	public static final String GET_ALL_AIMS_CODE = "aim.getAllAimsCode";

	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="LIFE_ID")
	private Life life;

	@Column(name="RANK")
	private Integer rank;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="CODE")
	private String code;
	
	@Column(name="DESCRIPTION"  )
	private String description;
	
	@Enumerated(EnumType.STRING)
	@Column(name="AIM_TYPE")
	private AimType aimType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="AIM_TIME_TYPE")
	private AimTimeType aimTimeType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATE_TYPE")
	private StateType stateType;

    @OneToMany( cascade = {CascadeType.ALL} ,fetch = FetchType.LAZY , mappedBy ="aim" )
    private List<Task> tasks;


    public Integer getRank(){ return rank; }
    public void setRank(Integer rank){ this.rank = rank; }

	public Life getLife() { return life; }
	public void setLife(Life life) { this.life = life; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getCode() { return code; }
	public void setCode(String code) { this.code = code; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public AimType getAimType() { return aimType; }
	public void setAimType(AimType aimType) { this.aimType = aimType; }
	
	public AimTimeType getAimTimeType() { return aimTimeType; }
	public void setAimTimeType(AimTimeType aimTimeType) { this.aimTimeType = aimTimeType; }
	
	public StateType getStateType() { return stateType; }
	public void setStateType(StateType stateType) { this.stateType = stateType; }
	
	public List<Task> getTasks(){ return tasks; }
	public void setTasks(List<Task> tasks){ this.tasks = tasks; }

	@Formula("(select count(t.*) from TASKS as t where t.aim_id = id ")
	@Transient
	private long taskSize;


	public Long getTaskSize(){
    	return taskSize;
	}

}
