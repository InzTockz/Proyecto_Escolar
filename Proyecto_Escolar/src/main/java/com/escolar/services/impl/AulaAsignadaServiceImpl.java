package com.escolar.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escolar.entity.Aula;
import com.escolar.entity.AulaAsignada;
import com.escolar.entity.Docente;
import com.escolar.entity.Estudiante;
import com.escolar.entity.Notas;
import com.escolar.entity.Trimestre;
import com.escolar.repository.IAulaAsignadaRepository;
import com.escolar.repository.IDocenteRepository;
import com.escolar.repository.IEstudianteRepository;
import com.escolar.repository.INotasRepository;
import com.escolar.repository.ITrimestreRepository;
import com.escolar.services.AulaAsignadaService;
import com.escolar.services.AulaService;

@Service
public class AulaAsignadaServiceImpl implements AulaAsignadaService {

	@Autowired
	private IAulaAsignadaRepository asRepo;

	@Autowired
	private AulaService aRepo;

	@Autowired
	private INotasRepository notaRepo;

	@Autowired
	private IDocenteRepository docRepo;

	@Autowired
	ITrimestreRepository triRepo;
	
	@Autowired
	IEstudianteRepository estuRepo;

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
		Optional<Docente> findDocente = docRepo.findById(aula.getDocente().getId_docente());
		if (aula.getAlumnos_max() == 0) {
			return null;
		} else {
			if (asRepo.existsByEstudianteAndAula(aulaasignada.getEstudiante(), aulaasignada.getAula())) {
				return null;
			} else {
				if (aula != null) {
					aula.setAlumnos_max(aula.getAlumnos_max() - 1);
					aRepo.update(aula.getId_aula(), aula);
				}

				if (aula != null) {
					// NOTA1
					Optional<Trimestre> findTrimestre1 = triRepo.findById(1);
					Notas notas1 = new Notas();
					notas1.setCalificacion(0);
					notas1.setIdtrimestre(findTrimestre1.get());
					notas1.setIdestudiante(aulaasignada.getEstudiante());
					notas1.setIddocente(findDocente.get());
					notaRepo.save(notas1);

					// NOTA2
					Optional<Trimestre> findTrimestre2 = triRepo.findById(2);
					Notas notas2 = new Notas();
					notas2.setCalificacion(0);
					notas2.setIdtrimestre(findTrimestre2.get());
					notas2.setIdestudiante(aulaasignada.getEstudiante());
					notas2.setIddocente(findDocente.get());
					notaRepo.save(notas2);

					// NOTA3
					Optional<Trimestre> findTrimestre3 = triRepo.findById(3);
					Notas notas3 = new Notas();
					notas3.setCalificacion(0);
					notas3.setIdtrimestre(findTrimestre3.get());
					notas3.setIdestudiante(aulaasignada.getEstudiante());
					notas3.setIddocente(findDocente.get());
					notaRepo.save(notas3);
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

		notaRepo.deleteAllById(() -> {
			List<Integer> notaId = new ArrayList<>();
			List<Notas> listadoNotas = notaRepo.findNotaEstudiante(findAuAsig.get().getEstudiante().getId_estudiante());
			for(Notas nota : listadoNotas) {
				notaId.add(nota.getId_notas());
			}
			return notaId.iterator();
		});
		
		aRepo.update(aula.getId_aula(), aula);
		asRepo.deleteById(id);
	}

}
