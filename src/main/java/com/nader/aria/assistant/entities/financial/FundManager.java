package com.nader.aria.assistant.entities.financial;

import javax.persistence.*;
import javax.validation.Valid;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.account.Login;


@Entity
@Table(name="FUND_MANAGERS")
public class FundManager extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
	@JoinColumn(name ="LOGIN_ID" )
	private Login login;
	
	@OneToOne( cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER )
	@JoinColumn(name ="CURRENT_FUND_ID" )
	@Valid
	private CurrentFund currentFund;
	
	@OneToOne( cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER )
	@JoinColumn(name ="SAVINGS_FUND_ID" )
	@Valid
	private SavingsFund savingsFund;
	
	public Login getLogin() { return login; }
	public void setLogin(Login login) { this.login = login; }
	
	public CurrentFund getCurrentFund() { return currentFund; }
	public void setCurrentFund(CurrentFund currentFund) { this.currentFund = currentFund; }
	
	public SavingsFund getSavingsFund() { return savingsFund; }
	public void setSavingsFund(SavingsFund savingsFund) { this.savingsFund = savingsFund; }

}
