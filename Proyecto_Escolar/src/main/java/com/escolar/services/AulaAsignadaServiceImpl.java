package com.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.AulaAsignada;
import com.escolar.repository.IAulaAsignadaRepository;

@Service
public class AulaAsignadaServiceImpl implements AulaAsignadaService {

	@Autowired
	private IAulaAsignadaRepository asRepo;
	
	@Override
	public List<AulaAsignada> findAll() {
		return asRepo.findAll();
	}

	@Override
	public Optional<AulaAsignada> findById(int id) {
		return asRepo.findById(id);
	}

	@Override
	public AulaAsignada save(AulaAsignada aulaasignada) {
		return asRepo.save(aulaasignada);
	}

	@Override
	public AulaAsignada update(int id, AulaAsignada aulaasignada) {
		if(asRepo.existsById(id)) {
			return asRepo.save(aulaasignada);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		asRepo.deleteById(id);
	}

}
