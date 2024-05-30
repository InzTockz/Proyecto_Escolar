package com.escolar.services;

import java.util.List;
import java.util.Optional;

import com.escolar.entity.Trimestre;

public interface TrimestreService {

	List<Trimestre> findAll();
	
	Optional<Trimestre> findById(int id);
}
