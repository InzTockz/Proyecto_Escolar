package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entitys.Trimestre;

public interface ITrimestreRepository extends JpaRepository<Trimestre, Integer> {

}
