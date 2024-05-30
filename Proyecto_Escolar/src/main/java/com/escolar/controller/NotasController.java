package com.escolar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.entity.Notas;
import com.escolar.services.NotasService;

@RestController
@RequestMapping("/api/notas")
public class NotasController {
	
	@Autowired
	private NotasService notaSer;
	
	@GetMapping
	public List<Notas> listarNotas(){
		return notaSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Notas> listarNotasId(@PathVariable int id) {
		Optional<Notas> notas = notaSer.findById(id);
		return notas.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Notas> registrarNotas(@RequestBody Notas notas){
		Notas notasRegistradas = notaSer.save(notas);
		return ResponseEntity.status(HttpStatus.CREATED).body(notasRegistradas);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Notas> actualizarNotas(@PathVariable int id, @RequestBody Notas notas){
		Notas actualizarNotas = notaSer.update(id, notas);
		if(actualizarNotas!=null) {
			return ResponseEntity.ok().body(actualizarNotas);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarNotas(@PathVariable int id){
		notaSer.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
