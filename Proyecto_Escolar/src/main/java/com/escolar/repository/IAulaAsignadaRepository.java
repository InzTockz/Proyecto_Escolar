package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entity.Aula;
import com.escolar.entity.AulaAsignada;
import com.escolar.entity.Estudiante;

public interface IAulaAsignadaRepository extends JpaRepository<AulaAsignada, Integer> {
	
	boolean existsByEstudianteAndAula(Estudiante estudiante, Aula aula);
}
