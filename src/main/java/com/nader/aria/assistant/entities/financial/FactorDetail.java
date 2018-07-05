package com.nader.aria.assistant.entities.financial;

import javax.persistence.*;
import com.nader.aria.assistant.entities.abstracts.BaseEntity;

@Entity
@Table(name="FACTOR_DETAILS")

public class FactorDetail extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER)
	@JoinColumn(name="FACTOR_ID")
	private Factor factor;
	
	@Column(name="TITLE"  )
	private String title;
	
	@Column(name="AMOUNT_OF")
	private Long amountOf;
	
	@Column(name="PRICE_PER_UNIT")
	private Long pricePerUnit;
	
	@Column(name="SUM")
	private Long sum;
	
	
	public Factor getFactor() { return factor; }
	public void setFactor(Factor factor) { this.factor = factor; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public Long getAmountOf() { return amountOf; }
	public void setAmountOf(Long amountOf) { this.amountOf = amountOf; }
	
	public Long getPricePerUnint() { return pricePerUnit; }
	public void setPricePerUnint(Long pricePerUnit) { this.pricePerUnit = pricePerUnit; }
	
	public Long getSum() { return sum; }
	public void setSum(Long sum) { this.sum = sum; }


}
