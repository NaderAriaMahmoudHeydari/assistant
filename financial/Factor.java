package com.nader.aria.assistant_blue.entities.financial;

import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="FACTORS")
@DiscriminatorValue("FACTOR")
public class Factor extends Payment {

	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = {CascadeType.ALL} , fetch = FetchType.LAZY , mappedBy = "factor" )
	private List<FactorDetail> factorDetails;
	
	public List<FactorDetail> getFactorDetails(){ return factorDetails; }
	public void setFactorDetails(List<FactorDetail> factorDetails) { this.factorDetails = factorDetails; }
	

}
