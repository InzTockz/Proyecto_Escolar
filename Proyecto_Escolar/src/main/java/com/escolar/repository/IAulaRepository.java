package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entitys.Aula;

public interface IAulaRepository extends JpaRepository<Aula, Integer> {

}
