package com.ecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idState")
	private Long idState;
	
	@Column(name = "stateName")
	private String stateName;
	
	@Column(name = "idCountry")
	private Long idCountry;

	@JoinColumn(name = "idCountry", referencedColumnName = "idCountry", insertable = false, updatable = false)
	@ManyToOne
	private Country country;

	public State() {
	}

	public State(Long idState, String stateName, Long idSettings) {
		super();
		this.idState = idState;
		this.stateName = stateName;
		this.idCountry = idSettings;
	}

	public Long getIdState() {
		return idState;
	}

	public void setIdState(Long idState) {
		this.idState = idState;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}

	
	
}
