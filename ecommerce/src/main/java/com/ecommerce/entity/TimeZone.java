package com.ecommerce.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "timeZone")
public class TimeZone implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTimeZone")
	private Long idTimeZone;
	
	@Column(name = "timeZone")
	private String timeZone;
	
	@OneToMany(mappedBy = "timeZone", fetch = FetchType.EAGER)
	private Set<Settings> listSettings;

	public TimeZone() {
	}

	public TimeZone(Long idTimeZone, String timeZone) {
		super();
		this.idTimeZone = idTimeZone;
		this.timeZone = timeZone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTimeZone == null) ? 0 : idTimeZone.hashCode());
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
		TimeZone other = (TimeZone) obj;
		if (idTimeZone == null) {
			if (other.idTimeZone != null)
				return false;
		} else if (!idTimeZone.equals(other.idTimeZone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TimeZone [idTimeZone=" + idTimeZone + "]";
	}

	public Long getIdTimeZone() {
		return idTimeZone;
	}

	public void setIdTimeZone(Long idTimeZone) {
		this.idTimeZone = idTimeZone;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
}
