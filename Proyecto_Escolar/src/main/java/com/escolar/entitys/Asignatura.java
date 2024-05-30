package com.escolar.entitys;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "asignatura")
@Data
public class Asignatura {

	@Id
	@Column(name = "id_asignatura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_asignatura;
	
	@Column(name = "nombre_asignatura")
	private String nom_asignatura;
}
