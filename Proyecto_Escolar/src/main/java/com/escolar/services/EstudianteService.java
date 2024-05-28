package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entitys.Estudiante;

public interface EstudianteService {

	List<Estudiante> findAll();
	
	Optional<Estudiante> findById(int id);
	
	Estudiante save(Estudiante estudiante);
	
	Estudiante update(int id, Estudiante estudiante);
	
	void deleteById(int id);
}
