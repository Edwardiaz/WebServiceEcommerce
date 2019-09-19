package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "promotions")
public class Promotions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPromotions")
	private Long idPromotions;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "amount")
	private Double amount;
	
	@Column(name= "descriptions")
	private String descriptions;
	
	@Column(name = "start")
	@Temporal(TemporalType.TIMESTAMP)
	private Date start;
	
	@Column(name = "end")
	@Temporal(TemporalType.TIMESTAMP)
	private Date end;
	
	@Column(name= "codePromotions")
	private String codePromotions;
	
	@Column(name= "idStatus")
	private Long idStatus;
	
	@JoinColumn(name = "idStatus", referencedColumnName = "idStatus", insertable = false, updatable = false)
	@ManyToOne
	private Status status;
	
	@OneToMany(mappedBy = "promotions", fetch = FetchType.EAGER)
	private Set<Orders> listOrders;
	
	@OneToMany(mappedBy = "promotions", fetch = FetchType.EAGER)
	private Set<ConfigPromotions> listConfigPromotions;

	public Promotions() {
	}

	public Promotions(Long idPromotions, String name, Double amount, String descriptions, Date start, Date end,
			String codePromotions, Long idStatus) {
		super();
		this.idPromotions = idPromotions;
		this.name = name;
		this.amount = amount;
		this.descriptions = descriptions;
		this.start = start;
		this.end = end;
		this.codePromotions = codePromotions;
		this.idStatus = idStatus;
	}
	
	

	public Long getIdPromotions() {
		return idPromotions;
	}

	public void setIdPromotions(Long idPromotions) {
		this.idPromotions = idPromotions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getCodePromotions() {
		return codePromotions;
	}

	public void setCodePromotions(String codePromotions) {
		this.codePromotions = codePromotions;
	}

	public Long getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPromotions == null) ? 0 : idPromotions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotions other = (Promotions) obj;
		if (idPromotions == null) {
			if (other.idPromotions != null)
				return false;
		} else if (!idPromotions.equals(other.idPromotions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Promotions [idPromotions=" + idPromotions + "]";
	}
	
	
}
