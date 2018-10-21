package com.uv.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Diagnostico implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_diagnostico;
	private Integer tipo_comite;
	private Date fecha_diagnostico;
	private Date fecha_comite;
	private String diagnostico_comite;
	private String diagnostico_cie10;
	private Integer ecog;
	private String tnm;
	private String estadio;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;
	
	@OneToMany(mappedBy="diagnostico")
	private Set<Tratamiento> tratamiento;
	
	public void setId_diagnostico(Integer id_diagnostico) {
		this.id_diagnostico = id_diagnostico;
	}
	public void setTipo_comite(Integer tipo_comite) {
		this.tipo_comite = tipo_comite;
	}
	public void setFecha_diagnostico(Date fecha_diagnostico) {
		this.fecha_diagnostico = fecha_diagnostico;
	}
	public void setDiagnostico_comite(String diagnostico_comite) {
		this.diagnostico_comite = diagnostico_comite;
	}
	public void setDiagnostico_cie10(String diagnostico_cie10) {
		this.diagnostico_cie10 = diagnostico_cie10;
	}
	public void setEcog(Integer ecog) {
		this.ecog = ecog;
	}
	public void setTnm(String tnm) {
		this.tnm = tnm;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public void setTratamiento(Set<Tratamiento> tratamiento) {
		this.tratamiento = tratamiento;
	}
	public Integer getId_diagnostico() {
		return id_diagnostico;
	}
	public Integer getTipo_comite() {
		return tipo_comite;
	}
	public Date getFecha_diagnostico() {
		return fecha_diagnostico;
	}
	public String getDiagnostico_comite() {
		return diagnostico_comite;
	}
	public String getDiagnostico_cie10() {
		return diagnostico_cie10;
	}
	public Integer getEcog() {
		return ecog;
	}
	public String getTnm() {
		return tnm;
	}
	public String getEstadio() {
		return estadio;
	}	
	
	public Set<Tratamiento> getTratamiento(){
		return tratamiento;
	}
	public Date getFecha_comite() {
		return fecha_comite;
	}
	public void setFecha_comite(Date fecha_comite) {
		this.fecha_comite = fecha_comite;
	}

	public Diagnostico(com.uv.types.rnc.Documento docu){
		com.uv.types.rnc.Diagnostico diagnostico = docu.getBodyDoc().getDiagnosticoDoc().getDiagnostico();
		this.diagnostico_cie10 = diagnostico.getDiagnosticoCIE10();
		this.diagnostico_comite = diagnostico.getDiagnosticoComite();
		this.ecog = diagnostico.getECOG();
		this.estadio = diagnostico.getEstadio();
		List<com.uv.types.rnc.Tratamiento> tratamientos = docu.getBodyDoc().getResolucionTratamientoDoc().
				getTratamientos().getTratamiento();
		this.fecha_comite = tratamientos.get(0).getFechaComite().toGregorianCalendar().getTime();
		this.fecha_diagnostico = diagnostico.getFechaDiagnostico().toGregorianCalendar().getTime();
		this.tipo_comite = Integer.parseInt(diagnostico.getTipoComite());
		this.tnm = diagnostico.getTNM();

	}
}
