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
@Table(name = "notas")
@Data
public class Notas {

	@Id
	@Column(name = "id_notas")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_notas;
	
	@Column(name = "calificacion")
	private double calificacion;
	
	@ManyToOne
	@JoinColumn(name = "id_trimestre")
	private Trimestre idtrimestre;
	
	@ManyToOne
	@JoinColumn(name = "id_estudiante")
	private Estudiante idestudiante;
	
	@ManyToOne
	@JoinColumn(name = "id_docente")
	private Docente iddocente;
}
