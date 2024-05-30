package com.escolar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.entitys.Asignatura;
import com.escolar.services.AsignaturaService;

@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {

	@Autowired
	private AsignaturaService asSer;
	
	@GetMapping
	public List<Asignatura> listarAsignaturas(){
		return asSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Asignatura> listarAsignaturaId(@PathVariable int id){
		Optional<Asignatura> asignatura = asSer.findById(id);
		return asignatura.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
}
