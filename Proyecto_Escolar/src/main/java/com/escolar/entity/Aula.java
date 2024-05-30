package com.escolar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "aula")
public class Aula {

	@Id
	@Column(name = "id_aula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_aula;
	
	@Column(name = "alumnos_max")
	private int alumnos_max;
	
	@Column(name = "nro_aula")
	private int nro_aula;
	
	@Column(name = "estado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name = "id_docente")
	private Docente docente;
}
