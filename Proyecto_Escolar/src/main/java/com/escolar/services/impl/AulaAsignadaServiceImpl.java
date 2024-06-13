package com.escolar.services.impl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.entity.Aula;
import com.escolar.entity.AulaAsignada;
import com.escolar.repository.IAulaAsignadaRepository;
import com.escolar.services.AulaAsignadaService;
import com.escolar.services.AulaService;

@Service
public class AulaAsignadaServiceImpl implements AulaAsignadaService {

	@Autowired
	private IAulaAsignadaRepository asRepo;

	@Autowired
	private AulaService aRepo;

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
		
		Optional<Aula> findAula = aRepo.findById(aulaasignada.getAula().getId_aula());
		Aula aula = findAula.get();
		if(aula.getAlumnos_max()==0) {
			return null;
		} else {
			if (asRepo.existsByEstudianteAndAula(aulaasignada.getEstudiante(), aulaasignada.getAula())) {
				return null;
			} else {
				if (aula != null) {
					aula.setAlumnos_max(aula.getAlumnos_max() - 1);
					aRepo.update(aula.getId_aula(), aula);
				}

				return asRepo.save(aulaasignada);
			}
		}
	}

	@Override
	public AulaAsignada update(int id, AulaAsignada aulaasignada) {
		if (asRepo.existsById(id)) {
			return asRepo.save(aulaasignada);
		} else {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Optional<AulaAsignada> findAuAsig = asRepo.findById(id);
		AulaAsignada auasig = findAuAsig.get();
		Optional<Aula> findAula = aRepo.findById(auasig.getAula().getId_aula());
		Aula aula = findAula.get();
		aula.setAlumnos_max(aula.getAlumnos_max() + 1);
		aRepo.update(aula.getId_aula(), aula);
		asRepo.deleteById(id);
	}

}
