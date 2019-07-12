package com.nader.aria.assistant_blue.entities.abstracts;


import javax.persistence.*;



@Entity
@Table(name="FUNDS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="FUND_TYPE" , discriminatorType = DiscriminatorType.STRING )
public abstract class Fund extends BaseEntity {

	
	private static final long serialVersionUID = 1L;

	@Column(name="MIN_STOCK")
	private Long minStock;
	
	@Column(name="CURRENT_STOCK")
	private Long currentStock;

	@Column(name="MAX_STOCK")
	private Long maxStock;


	public Long getMinStock() { return minStock; }
	public void setMinStock(Long minStock) { this.minStock = minStock; }
	
	public Long getMaxStock() { return maxStock; }
	public void setMaxStock(Long maxStock) { this.maxStock = maxStock; }
	
	public Long getCurrentStock() { return currentStock; }
	public void setCurrentStock(Long currentStock) { this.currentStock = currentStock; }


}
