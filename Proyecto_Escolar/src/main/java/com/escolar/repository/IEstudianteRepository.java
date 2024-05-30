package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entity.Estudiante;

public interface IEstudianteRepository extends JpaRepository<Estudiante, Integer> {

}
