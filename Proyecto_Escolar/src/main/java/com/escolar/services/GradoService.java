package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entity.Grado;

public interface GradoService {

	List<Grado> findAll();
	
	Optional<Grado> findById(int id);
}
