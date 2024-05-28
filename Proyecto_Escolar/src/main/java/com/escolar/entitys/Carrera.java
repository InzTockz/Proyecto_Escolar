package com.escolar.entitys;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "carrera")
@Data
public class Carrera {
	
	@Id
	@Column(name = "id_carrera")
	private int id_carrera;
	
	@Column(name = "nombre_carrera")
	private String nom_carrera;

}
