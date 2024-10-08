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
@Table(name = "aula_asignada")
@Data
public class AulaAsignada {

	@Id
	@Column(name = "id_aula_asignada")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_aulaasignada;
	
	@ManyToOne
	@JoinColumn(name = "id_aula")
	private Aula aula;
	
	@ManyToOne
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;
}
