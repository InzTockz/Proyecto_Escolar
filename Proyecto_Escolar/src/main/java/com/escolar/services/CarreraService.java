package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entity.Carrera;

public interface CarreraService {

	List<Carrera> findAll();
	
	Optional<Carrera> findById(int id);
}
