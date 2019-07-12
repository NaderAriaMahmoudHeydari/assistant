package com.nader.aria.assistant_blue.entities.medicine;

import java.util.List;
import javax.persistence.*;
import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Login;

@Entity
@Table(name="DRUG_INFO_MANAGERS")
public class DrugInfoManager extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name="LOGIN_ID")
	private Login login;
	
	@OneToMany( cascade = {CascadeType.ALL},fetch = FetchType.LAZY , mappedBy ="drugInfoManager")
	private List<DrugInfo> drugInfos;
	
	
	public Login getLogin() { return login; }
	public void setLogin(Login login) { this.login = login; }
	
	public List<DrugInfo> getDrugInfos(){ return drugInfos; }
	public void setDrugInfo(List<DrugInfo> drugInfos) { this.drugInfos =drugInfos; }
	
}
