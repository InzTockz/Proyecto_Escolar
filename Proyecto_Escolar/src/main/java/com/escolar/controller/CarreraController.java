package com.escolar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.entity.Carrera;
import com.escolar.services.CarreraService;

@RestController
@RequestMapping("/api/carrera")
public class CarreraController {

	@Autowired
	private CarreraService carSer;
	
	@GetMapping
	public List<Carrera> listarCarrera(){
		return carSer.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Carrera> listarCarreraId(@PathVariable int id){
		Optional<Carrera> carrera = carSer.findById(id);
		return carrera.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
}
