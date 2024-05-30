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

import com.escolar.entitys.Aula;
import com.escolar.services.AulaService;

@RestController
@RequestMapping("/api/aula")
public class AulaController {

	@Autowired
	private AulaService auSer;
	
	@GetMapping
	public List<Aula> listarAulas(){
		return auSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aula> listarAulasId(@PathVariable int id){
		Optional<Aula> aula = auSer.findById(id);
		return aula.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Aula> registrarAula(@RequestBody Aula aula){
		Aula aulaRegistrada = auSer.save(aula);
		return ResponseEntity.status(HttpStatus.CREATED).body(aulaRegistrada);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aula> actualizarAula(@PathVariable int id, @RequestBody Aula aula){
		Aula aulaRegistrada = auSer.save(aula);
		if(aulaRegistrada!=null) {
			return ResponseEntity.ok().body(aulaRegistrada);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarAula(@PathVariable int id){
		auSer.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
