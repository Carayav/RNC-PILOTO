package com.uv.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Localizacion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private Integer region;
	private Integer provincia;
	private Integer comuna;
	private String direccion;
	
	@OneToOne
    @JoinColumn(name = "id")
    private Paciente paciente;
	
	@OneToOne
    @JoinColumn(name = "id")
    private Centro_derivador centro_derivador;
	
	public Integer getId() {
		return id;
	}

	public Integer getRegion() {
		return region;
	}

	public Integer getProvincia() {
		return provincia;
	}

	public Integer getComuna() {
		return comuna;
	}

	public String getDireccion() {
		return direccion;
	}
	
	
}
