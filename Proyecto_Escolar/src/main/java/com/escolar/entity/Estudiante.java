package com.escolar.entity;

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

@Entity
@Data
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@Column(name = "id_estudiante")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_estudiante;
	
	@Column(name = "nombres")
	private String nombres;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "fecha_nacimiento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fecha_nacimiento;
	
	@Column(name = "dni")
	private int dni;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_grado")
	private Grado grado;
}
