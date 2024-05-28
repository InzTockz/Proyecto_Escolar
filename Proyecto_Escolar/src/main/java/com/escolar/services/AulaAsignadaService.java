package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entitys.AulaAsignada;

public interface AulaAsignadaService {

	List<AulaAsignada> findAll();
	
	Optional<AulaAsignada> findById(int id);
	
	AulaAsignada save(AulaAsignada aulaasignada);
	
	AulaAsignada update(int id, AulaAsignada aulaasignada);
	
	void deleteById(int id);
}
