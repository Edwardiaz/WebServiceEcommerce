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
@Table(name = "roleOptions")
public class RoleOptions implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRoleOptions")
	private Long idRoleOptions;

	@Column(name = "optionss")
	private String optionss;

	@Column(name = "insertar", columnDefinition = "BIT", length = 1)
	private boolean insertar;

	@Column(name = "actualizar", columnDefinition = "BIT", length = 1)
	private boolean actualizar;

	@Column(name = "eliminar", columnDefinition = "BIT", length = 1)
	private boolean eliminar;

	@Column(name = "consultar", columnDefinition = "BIT", length = 1)
	private boolean consultar;

	@Column(name = "idRole")
	private Long idRole;

	@Column(name = "idOptionss")
	private Long idOptionss;

	@JoinColumn(name = "idRole", referencedColumnName = "idRole", insertable = false, updatable = false)
	@ManyToOne
	private Role roleobj;

	@JoinColumn(name = "idOptionss", referencedColumnName = "idOptionss", insertable = false, updatable = false)
	@ManyToOne
	private Optionss optionssobj;

	public RoleOptions() {

	}

	

	public RoleOptions(Long idRoleOptions, String optionss, boolean insertar, boolean actualizar, boolean eliminar,
			boolean consultar, Long idRole, Long idOptionss) {
		super();
		this.idRoleOptions = idRoleOptions;
		this.optionss = optionss;
		this.insertar = insertar;
		this.actualizar = actualizar;
		this.eliminar = eliminar;
		this.consultar = consultar;
		this.idRole = idRole;
		this.idOptionss = idOptionss;
	}



	public Long getIdRoleOptions() {
		return idRoleOptions;
	}



	public void setIdRoleOptions(Long idRoleOptions) {
		this.idRoleOptions = idRoleOptions;
	}



	public Long getIdRole() {
		return idRole;
	}



	public void setIdRole(Long idRole) {
		this.idRole = idRole;
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



	public boolean isInsertar() {
		return insertar;
	}



	public void setInsertar(boolean insertar) {
		this.insertar = insertar;
	}



	public boolean isActualizar() {
		return actualizar;
	}



	public void setActualizar(boolean actualizar) {
		this.actualizar = actualizar;
	}



	public boolean isEliminar() {
		return eliminar;
	}



	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}



	public boolean isConsultar() {
		return consultar;
	}



	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRoleOptions == null) ? 0 : idRoleOptions.hashCode());
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
		RoleOptions other = (RoleOptions) obj;
		if (idRoleOptions == null) {
			if (other.idRoleOptions != null)
				return false;
		} else if (!idRoleOptions.equals(other.idRoleOptions))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RoleOptions [idRoleOptions=" + idRoleOptions + "]";
	}

}
