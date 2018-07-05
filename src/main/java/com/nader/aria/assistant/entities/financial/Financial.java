package com.nader.aria.assistant.entities.financial;


import javax.persistence.*;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;
import com.nader.aria.assistant.entities.abstracts.Fund;
import com.nader.aria.assistant.entities.enums.FinanceType;
import com.nader.aria.assistant.entities.enums.PaymentReceiveType;

@Entity
@Table(name="FINANCIALS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="FINANCIAL_TYPE" , discriminatorType = DiscriminatorType.STRING )
public class Financial extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name="TITLE"  )
	private String title;
	
	@Column(name="VALUE")
	private Long value;
	
	@OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER)
	@JoinColumn(name="FUND")
	private Fund fund;
	
	@Enumerated(EnumType.STRING)
	@Column(name="FINANCE_TYPE")
	private FinanceType financeType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="PAYMENT_RECEIVE_TYPE")
	private PaymentReceiveType paymentReceiveType;
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public Long getValue() { return value; }
	public void setValue(Long value) { this.value = value; }
	
	public Fund getFund() { return fund; }
	public void setFund(Fund fund) { this.fund = fund; }
	
	public FinanceType getFinanceType() { return financeType; }
	public void setFinanceType(FinanceType financeType) { this.financeType = financeType; }
	
	public PaymentReceiveType getPaymentReceiveType() { return paymentReceiveType; }
	public void setPaymentReceiveType(PaymentReceiveType paymentReceiveType) { this.paymentReceiveType = paymentReceiveType; }
	
	

}
