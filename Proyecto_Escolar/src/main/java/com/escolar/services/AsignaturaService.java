package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entitys.Asignatura;

public interface AsignaturaService {

	List<Asignatura> findAll();
	
	Optional<Asignatura> findById(int id);
}
