package com.escolar.entitys;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Table(name = "docente")
@Entity
@Data
public class Docente {

	@Id
	@Column(name = "id_docente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_docente;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fec_nacimiento;
	
	@Column(name = "dni")
	private int dni;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_carrera")
	private Carrera carrera;
	
	@ManyToOne
	@JoinColumn(name = "id_asignatura")
	private Asignatura asignatura;
}
