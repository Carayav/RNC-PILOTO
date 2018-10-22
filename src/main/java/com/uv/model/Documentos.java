package com.uv.model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "documentos")
@TypeDefs({
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class Documentos implements Serializable {

	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Integer id_documentos;

	@ManyToOne
	@JoinColumn(name="id_paciente", nullable=false)
	private Paciente paciente;


	@Type(type = "jsonb")
	@Column(columnDefinition = "jsonb")
	private JsonData data;

	public Documentos() {
	}

	public JsonData getJsonData() {
		return data;
	}

	public void setJsonData(JsonData jsonData) {
		this.data = jsonData;
	}

	public Documentos(JsonData jsonData) {
		this.data = jsonData;
	}
}





//package com.uv.model;
//
//import javax.persistence.*;
//
//import com.vladmihalcea.hibernate.type.array.IntArrayType;
//import com.vladmihalcea.hibernate.type.array.StringArrayType;
//import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
//import com.vladmihalcea.hibernate.type.json.JsonNodeBinaryType;
//import com.vladmihalcea.hibernate.type.json.JsonNodeStringType;
//import com.vladmihalcea.hibernate.type.json.JsonStringType;
//import org.hibernate.annotations.Type;
//import org.hibernate.annotations.TypeDef;
//import org.hibernate.annotations.TypeDefs;
//
//@TypeDefs({
//		@TypeDef(name = "string-array", typeClass = StringArrayType.class),
//		@TypeDef(name = "int-array", typeClass = IntArrayType.class),
//		@TypeDef(name = "json", typeClass = JsonStringType.class),
//		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class),
//		@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class),
//		@TypeDef(name = "json-node", typeClass = JsonNodeStringType.class),
//})
//@Entity(name = "Documentos")
//@Table(name = "documentos")
//public class Documentos  {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id_documentos", updatable = false, nullable = false)
//	private Integer id;
//
//
//
//	@Type(type = "jsonb")
//	@Column(columnDefinition = "jsonb")
//	private String data;
//
//	@ManyToOne
//	@JoinColumn(name="id_paciente", nullable=false)
//	private Paciente paciente;
//
//
//	public Documentos() {
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Paciente getPaciente() {
//		return paciente;
//	}
//
//	public void setPaciente(Paciente paciente) {
//		this.paciente = paciente;
//	}
//
//	public String getData() {
//		return data;
//	}
//
//	public void setData(String data) {
//		this.data = data;
//	}
//
//	public Documentos(String data) {
//		this.data = data;
//	}
//}
