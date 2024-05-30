package com.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Aula;
import com.escolar.repository.IAulaRepository;

@Service
public class AulaServiceImpl implements AulaService {

	@Autowired
	private IAulaRepository auRepo;
	
	@Override
	public List<Aula> findAll() {
		return auRepo.findAll();
	}

	@Override
	public Optional<Aula> findById(int id) {
		return auRepo.findById(id);
	}

	@Override
	public Aula save(Aula aula) {
		return auRepo.save(aula);
	}

	@Override
	public Aula update(int id, Aula aula) {
		if(auRepo.existsById(id)) {
			return auRepo.save(aula);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		auRepo.deleteById(id);
	}

}
