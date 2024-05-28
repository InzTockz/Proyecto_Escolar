package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entitys.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {

}
