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

import com.escolar.entitys.Estudiante;
import com.escolar.services.EstudianteService;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

	@Autowired
	private EstudianteService estSer;
	
	@GetMapping
	public List<Estudiante> listarEstudiante(){
		return estSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudiante> listarEstudianteId(@PathVariable int id){
		Optional<Estudiante> estudiante = estSer.findById(id);
		return estudiante.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante){
		Estudiante guardarEstudiante = estSer.save(estudiante);
		return ResponseEntity.status(HttpStatus.CREATED).body(guardarEstudiante);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable int id, @RequestBody Estudiante estudiante){
		Estudiante actualizarEstudiante = estSer.update(id, estudiante);
		if(actualizarEstudiante != null) {
			return ResponseEntity.ok().body(actualizarEstudiante);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarEstudiante(@PathVariable int id){
		estSer.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
