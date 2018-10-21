package com.uv.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String nombre_medico;
	private String apellido_1;
	private String apellido_2;
	private String id_tratamiento;
	
	public Integer getId() {
		return id;
	}
	public String getNombre_medico() {
		return nombre_medico;
	}
	public String getApellido_1() {
		return apellido_1;
	}
	public String getApellido_2() {
		return apellido_2;
	}
	public String getId_tratamiento() {
		return id_tratamiento;
	}
	
	
}
