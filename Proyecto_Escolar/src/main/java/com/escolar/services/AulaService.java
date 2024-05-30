package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entity.Aula;

public interface AulaService {

	List<Aula> findAll();
	
	Optional<Aula> findById(int id);
	
	Aula save(Aula aula);
	
	Aula update(int id, Aula aula);
	
	void deleteById(int id);
}
