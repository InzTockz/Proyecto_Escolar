package com.escolar.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Grado;
import com.escolar.repository.IGradoRepository;
import com.escolar.services.GradoService;

@Service
public class GradoServiceImpl implements GradoService {

	@Autowired
	private IGradoRepository gradoRepo;
	
	@Override
	public List<Grado> findAll() {
		return gradoRepo.findAll();
	}

	@Override
	public Optional<Grado> findById(int id) {
		return gradoRepo.findById(id);
	}

}
