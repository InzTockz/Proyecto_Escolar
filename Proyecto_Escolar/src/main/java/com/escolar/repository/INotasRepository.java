package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entitys.Notas;

public interface INotasRepository extends JpaRepository<Notas, Integer> {

}
