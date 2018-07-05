package com.nader.aria.assistant.entities.abstracts;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="FUNDS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="FUND_TYPE" , discriminatorType = DiscriminatorType.STRING )
public abstract class Fund extends BaseEntity {


	
	private static final long serialVersionUID = 1L;
	

	@Column(name="MIN_STOCK")
	@NotNull
	@Min(value = 0)
	private Long minStock;
	
	@Column(name="MAX_STOCK")
	@NotNull
	@Min(value = 0)
	private Long maxStock;
	
	@Column(name="CURRENT_STOCK")
	@NotNull
	@Min(value = 0)
	private Long currentStock;


	public Fund(){}

	public Fund(Long id,Long version,Long minStock,Long maxStock,Long currentStock){

		super(id,version);
		this.minStock = minStock;
		this.maxStock = maxStock;
		this.currentStock = currentStock;

	}

	public Long getMinStock() { return minStock; }
	public void setMinStock(Long minStock) { this.minStock = minStock; }
	
	public Long getMaxStock() { return maxStock; }
	public void setMaxStock(Long maxStock) { this.maxStock = maxStock; }
	
	public Long getCurrentStock() { return currentStock; }
	public void setCurrentStock(Long currentStock) { this.currentStock = currentStock; }

}
