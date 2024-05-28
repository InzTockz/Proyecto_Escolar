package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entitys.Docente;

public interface DocenteService {

	List<Docente> findAll();
	
	Optional<Docente> findById(int id);
	
	Docente save(Docente docente);
	
	Docente update(int id, Docente docente);
	
	void deleteById(int id);
}
