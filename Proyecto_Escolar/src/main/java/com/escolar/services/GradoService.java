package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entitys.Grado;

public interface GradoService {

	List<Grado> findAll();
	
	Optional<Grado> findById(int id);
}
