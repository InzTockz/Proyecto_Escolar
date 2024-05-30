package com.escolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escolar.entity.Trimestre;

public interface ITrimestreRepository extends JpaRepository<Trimestre, Integer> {

}
