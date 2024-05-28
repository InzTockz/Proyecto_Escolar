package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entitys.Carrera;

public interface ICarreraRepository extends JpaRepository<Carrera, Integer> {

}
