package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entity.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {

}
