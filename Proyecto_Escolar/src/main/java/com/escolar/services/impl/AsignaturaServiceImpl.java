package com.escolar.services.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Asignatura;
import com.escolar.repository.IAsignaturaRepository;
import com.escolar.services.AsignaturaService;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	private IAsignaturaRepository asignaRepo;
	
	@Override
	public List<Asignatura> findAll() {
		return asignaRepo.findAll();
	}

	@Override
	public Optional<Asignatura> findById(int id) {
		return asignaRepo.findById(id);
	}

}
