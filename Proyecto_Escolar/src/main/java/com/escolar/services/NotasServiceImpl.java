package com.escolar.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Notas;
import com.escolar.repository.INotasRepository;

@Service
public class NotasServiceImpl implements NotasService {

	@Autowired
	private INotasRepository notaRepo;
	
	@Override
	public List<Notas> findAll() {
		return notaRepo.findAll();
	}

	@Override
	public Optional<Notas> findById(int id) {
		return notaRepo.findById(id);
	}

	@Override
	public Notas save(Notas notas) {
		return notaRepo.save(notas);
	}

	@Override
	public Notas update(int id, Notas notas) {
		if(notaRepo.existsById(id)) {
			return notaRepo.save(notas);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		notaRepo.deleteById(id);
	}

}
