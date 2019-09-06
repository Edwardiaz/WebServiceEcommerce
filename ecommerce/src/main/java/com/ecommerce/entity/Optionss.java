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
@Table(name = "optionss")
public class Optionss implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idOptionss")
	private Long idOptionss;
	
	@Column(name= "optionss")
	private String optionss;
	
	@Column(name= "url")
	private String url;
	
	@Column(name= "icon")
	private String icon;
	
	@Column(name= "subMenu")
	private String subMenu;
	
	@OneToMany(mappedBy = "optionssobj", fetch = FetchType.EAGER)
	private Set<RoleOptions> listRoleOptions;

	public Optionss() {
		
	}

	public Optionss(Long idOptionss, String optionss, String url, String icon, String subMenu) {
		super();
		this.idOptionss = idOptionss;
		this.optionss = optionss;
		this.url = url;
		this.icon = icon;
		this.subMenu = subMenu;
	}

	public Long getIdOptionss() {
		return idOptionss;
	}

	public void setIdOptionss(Long idOptionss) {
		this.idOptionss = idOptionss;
	}

	public String getOptionss() {
		return optionss;
	}

	public void setOptionss(String optionss) {
		this.optionss = optionss;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idOptionss == null) ? 0 : idOptionss.hashCode());
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
		Optionss other = (Optionss) obj;
		if (idOptionss == null) {
			if (other.idOptionss != null)
				return false;
		} else if (!idOptionss.equals(other.idOptionss))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Optionss [idOptionss=" + idOptionss + "]";
	}

	
}
