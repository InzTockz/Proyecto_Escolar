package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entity.Notas;

public interface INotasRepository extends JpaRepository<Notas, Integer> {

}
