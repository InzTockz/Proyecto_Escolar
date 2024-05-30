package com.escolar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.entitys.Grado;
import com.escolar.services.GradoService;

@RestController
@RequestMapping("api/grado")
public class GradoController {

	@Autowired
	private GradoService graSer;
	
	@GetMapping
	public List<Grado> listarGrado(){
		return graSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Grado> listarGradoId(@PathVariable int id){
		Optional<Grado> grado = graSer.findById(id);
		return grado.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
}
