package com.escolar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.entitys.Trimestre;
import com.escolar.services.TrimestreService;

@RestController
@RequestMapping("/api/trimestre")
public class TrimestreController {

	@Autowired
	private TrimestreService triSer;
	
	@GetMapping
	public List<Trimestre> listarTrimestre(){
		return triSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Trimestre> listarTrimestreId(@PathVariable int id){
		Optional<Trimestre> trimestre = triSer.findById(id);
		return trimestre.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
}
