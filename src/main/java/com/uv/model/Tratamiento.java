package com.uv.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Tratamiento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_tratamiento;
	private Integer resolucion_comite;
	private Integer tipo_tratamiento;
	private Integer intencion_tratamiento;
	private Date fecha_intencion;
	private String  descripcion_tratamiento;
	private Integer id_medico;


	public Tratamiento(com.uv.types.rnc.Documento doc){
		this.resolucion_comite = Integer.parseInt(doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientoGeneral().getResolucionComite());
		this.tipo_tratamiento = doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientos().getTratamiento().get(0).getTipoTratamiento();
		this.intencion_tratamiento = doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientos().getTratamiento().get(0).getIntencionTratamiento();
		this.fecha_intencion = doc.getBodyDoc().getResolucionTratamientoDoc().getTratamientos().getTratamiento().get(0).getFechaIntencion().toGregorianCalendar().getTime();
		this.descripcion_tratamiento = doc.getBodyDoc().
				getResolucionTratamientoDoc().
				getTratamientoGeneral().
				getDescripcionTratamiento();
		this.id_medico = 345;

	}

	@ManyToOne
    @JoinColumn(name="id_diagnostico", nullable=false)
	private Diagnostico diagnostico;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId_tratamiento() {
		return id_tratamiento;
	}

	public void setId_tratamiento(Integer id) {
		this.id_tratamiento = id;
	}

	public Integer getResolucion_comite() {
		return resolucion_comite;
	}

	public void setResolucion_comite(Integer resolucion_comite) {
		this.resolucion_comite = resolucion_comite;
	}

	public Integer getTipo_tratamiento() {
		return tipo_tratamiento;
	}

	public void setTipo_tratamiento(Integer tipo_tratamiento) {
		this.tipo_tratamiento = tipo_tratamiento;
	}

	public Integer getIntencion_tratamiento() {
		return intencion_tratamiento;
	}

	public void setIntencion_tratamiento(Integer intencion_tratamiento) {
		this.intencion_tratamiento = intencion_tratamiento;
	}

	public Date getFecha_intencion() {
		return fecha_intencion;
	}

	public void setFecha_intencion(Date fecha_intencion) {
		this.fecha_intencion = fecha_intencion;
	}

	public String getDescripcion_tratamiento() {
		return descripcion_tratamiento;
	}

	public void setDescripcion_tratamiento(String descripcion_tratamiento) {
		this.descripcion_tratamiento = descripcion_tratamiento;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

}
