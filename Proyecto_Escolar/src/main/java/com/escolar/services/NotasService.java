package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entity.Notas;

public interface NotasService {
	
	List<Notas> findAll();
	
	Optional<Notas> findById(int id);
	
	Notas save(Notas notas);
	
	Notas update(int id, Notas notas);
	
	void deleteById(int id);
}
