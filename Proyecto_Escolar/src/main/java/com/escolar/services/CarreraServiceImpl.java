package com.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Carrera;
import com.escolar.repository.ICarreraRepository;

@Service
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private ICarreraRepository carreRepo;
	
	@Override
	public List<Carrera> findAll() {
		return carreRepo.findAll();
	}

	@Override
	public Optional<Carrera> findById(int id) {
		return carreRepo.findById(id);
	}

}
