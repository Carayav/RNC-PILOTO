package com.uv.model;

import com.uv.types.rnc.Documento;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id_medico;
	private String nombre_medico;
	private String apellido1;
	private String apellido2;

	public void setId_establecimiento(Integer id_establecimiento) {
		this.id_establecimiento = id_establecimiento;
	}

	private Integer id_establecimiento;

	public Medico(Documento docu){
		this.nombre_medico = docu.getBodyDoc().getResolucionTratamientoDoc().getMedicoTratante();

	}

	public Medico() {
	}


	public Integer getId_medico() {
		return id_medico;
	}
	public String getNombre_medico() {
		return nombre_medico;
	}
	public String getApellido_1() {
		return apellido1;
	}
	public String getApellido_2() {
		return apellido2;
	}
	public Integer getId_establecimiento() {
		return id_establecimiento;
	}
	
	
}
