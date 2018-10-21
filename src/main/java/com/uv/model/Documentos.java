package com.uv.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Documentos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	private String tipo_documento;
	private String pais_emisor;
	private Integer numero_documento;
	private Integer id_medico;
	
	@ManyToOne
    @JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;
	
	@OneToMany(mappedBy="documentos")
	@JsonIgnore
	private Set<Archivos> archivos;
	
	public Integer getId() {
		return id;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public String getPais_emisor() {
		return pais_emisor;
	}
	public Integer getNumero_documento() {
		return numero_documento;
	}
	public Integer getId_medico() {
		return id_medico;
	}
	public Set<Archivos> getArchivos() {
		return archivos;
	}

}
