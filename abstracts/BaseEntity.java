package com.nader.aria.assistant_blue.entities.abstracts;

import java.io.Serializable;
import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID",unique=true, nullable = false)
	private Long id;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }



}
