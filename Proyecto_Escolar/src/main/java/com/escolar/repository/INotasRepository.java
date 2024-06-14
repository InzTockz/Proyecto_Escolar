package com.escolar.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.escolar.entity.Notas;
import com.escolar.entity.Estudiante;
import com.escolar.entity.Trimestre;

public interface INotasRepository extends JpaRepository<Notas, Integer> {

	boolean existsByIdestudianteAndIdtrimestre(Estudiante idestudiante, Trimestre idtrimestre);
	
	@Query(value = "select * from notas where id_estudiante = ?", nativeQuery = true)
	List<Notas> findNotaEstudiante(int idEstudiante);
	
	Optional<Notas> findByIdestudiante(Estudiante estudiante);
	boolean existsByIdestudiante(Estudiante idestudiante);
}
