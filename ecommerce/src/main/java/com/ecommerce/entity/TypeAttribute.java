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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "typeAttribute")
public class TypeAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTypeAttribute")
	private Long idTypeAttribute;
	
	@Column(name = "nameAttribute")
	private String nameAttribute;
	
	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "number")
	private Long number;
	
	@Column(name = "decimal")
	private Double decimal;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "longText")
	private String longText;
	
	@Column(name= "logic", columnDefinition = "BIT", length = 1)
	private boolean logic;
	
	@Column(name = "image")
	private String image;

	@OneToMany(mappedBy = "typeAttribute", fetch = FetchType.EAGER)
	private Set<ConfigProducts> listConfigProducts;
	
	public TypeAttribute() {
	}

	public TypeAttribute(Long idTypeAttribute, String nameAttribute, Date date, Long number, Double decimal,
			String text, String longText, boolean logic, String image) {
		super();
		this.idTypeAttribute = idTypeAttribute;
		this.nameAttribute = nameAttribute;
		this.date = date;
		this.number = number;
		this.decimal = decimal;
		this.text = text;
		this.longText = longText;
		this.logic = logic;
		this.image = image;
	}

	public Long getIdTypeAttribute() {
		return idTypeAttribute;
	}

	public void setIdTypeAttribute(Long idTypeAttribute) {
		this.idTypeAttribute = idTypeAttribute;
	}

	public String getNameAttribute() {
		return nameAttribute;
	}

	public void setNameAttribute(String nameAttribute) {
		this.nameAttribute = nameAttribute;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Double getDecimal() {
		return decimal;
	}

	public void setDecimal(Double decimal) {
		this.decimal = decimal;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getLongText() {
		return longText;
	}

	public void setLongText(String longText) {
		this.longText = longText;
	}

	public boolean isLogic() {
		return logic;
	}

	public void setLogic(boolean logic) {
		this.logic = logic;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
