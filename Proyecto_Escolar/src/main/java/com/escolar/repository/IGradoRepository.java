package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entitys.Grado;

public interface IGradoRepository extends JpaRepository<Grado, Integer> {

}
