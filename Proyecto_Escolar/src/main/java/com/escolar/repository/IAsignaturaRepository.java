package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entity.Asignatura;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Integer> {

}
