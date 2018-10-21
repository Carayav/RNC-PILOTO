package com.uv.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Centro_derivador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer codigo_establecimiento;
	private String nombre_establecimiento;
	private Integer servicio_salud;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Localizacion id_localizacion;

	public Integer getId() {
		return id;
	}
	public Integer getCodigo_establecimiento() {
		return codigo_establecimiento;
	}
	public String getNombre_establecimiento() {
		return nombre_establecimiento;
	}
	public Integer getServicio_salud() {
		return servicio_salud;
	}
	
}
