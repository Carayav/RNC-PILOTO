package com.uv.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tratamiento_indicado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer intencion_tratamiento;
	private Date fecha_intencion;
	private Date fecha_comite;
	private String medicamentos;
	
	@ManyToOne
	@JoinColumn(name="id_tratamiento", nullable=false)
	private Tratamiento tratamiento;
	
	public Integer getId() {
		return id;
	}
	public Integer getIntencion_tratamiento() {
		return intencion_tratamiento;
	}
	public Date getFecha_intencion() {
		return fecha_intencion;
	}
	public Date getFecha_comite() {
		return fecha_comite;
	}
	public String getMedicamentos() {
		return medicamentos;
	}

}
