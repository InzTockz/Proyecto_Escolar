package com.escolar.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "trimestre")
@Entity
@Data
public class Trimestre {

	@Id
	@Column(name = "id_trimestre")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_trimestre;
	
	@Column(name = "nombre_trimestre")
	private String nombre_trimestre;
}
