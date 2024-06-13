package com.escolar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Estudiante;
import com.escolar.repository.IEstudianteRepository;
import com.escolar.services.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private IEstudianteRepository estuRepo;
	
	@Override
	public List<Estudiante> findAll() {
		return estuRepo.findAll();
	}

	@Override
	public Optional<Estudiante> findById(int id) {
		return estuRepo.findById(id);
	}

	@Override
	public Estudiante save(Estudiante estudiante) {
		return estuRepo.save(estudiante);
	}

	@Override
	public Estudiante update(int id, Estudiante estudiante) {
		if(estuRepo.existsById(id)) {
			return estuRepo.save(estudiante);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		estuRepo.deleteById(id);
	}

}
