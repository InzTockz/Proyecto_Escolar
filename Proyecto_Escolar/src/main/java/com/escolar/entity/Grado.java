package com.escolar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "grado")
@Data
public class Grado {

	@Id
	@Column(name = "id_grado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_grado;
	
	@Column(name = "nombre_grado")
	private String nombre_grado;
}
