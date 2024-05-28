package com.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entitys.Docente;
import com.escolar.repository.IDocenteRepository;

@Service
public class DocenteServicesImpl implements DocenteService {

	@Autowired
	private IDocenteRepository docRepo;
	
	@Override
	public List<Docente> findAll() {
		return docRepo.findAll();
	}

	@Override
	public Optional<Docente> findById(int id) {
		return docRepo.findById(id);
	}

	@Override
	public Docente save(Docente docente) {
		return docRepo.save(docente);
	}

	@Override
	public Docente update(int id, Docente docente) {
		if(docRepo.existsById(id)) {
			return docRepo.save(docente);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		docRepo.deleteById(id);
	}

}
