package com.uv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Antecedentes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_antecedentes;
	
	private Date fecha_primera_consulta;
	private String diagnostico_previo;
	private Integer motivo_presentacion;
	
	@OneToOne
    @JoinColumn(name = "id_antecedentes")
    private Diagnostico id_diagnostico;
	
	public void setFecha_primera_consulta(Date fecha_primera_consulta) {
		this.fecha_primera_consulta = fecha_primera_consulta;
	}
	public void setDiagnostico_previo(String diagnostico_previo) {
		this.diagnostico_previo = diagnostico_previo;
	}
	public void setMotivo_presentacion(Integer motivo_presentacion) {
		this.motivo_presentacion = motivo_presentacion;
	}
	public void setId_diagnostico(Diagnostico id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}
	public Integer getId_antecedentes() {
		return id_antecedentes;
	}
	public Date getFecha_primera_consulta() {
		return fecha_primera_consulta;
	}

	public Integer getMotivo_presentacion() {
		return motivo_presentacion;
	}
	
	public String getDiagnostico_previo() {
		return diagnostico_previo;
	}
	
	
}
