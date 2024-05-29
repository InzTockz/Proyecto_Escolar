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

import com.escolar.entitys.Docente;
import com.escolar.services.DocenteService;

@RestController
@RequestMapping("/api/docente")
public class DocenteController {
	
	@Autowired
	private DocenteService docSer;
	
	@GetMapping
	public List<Docente> listarDocentes(){
		return docSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Docente> listarDocentePorId(@PathVariable int id){
		Optional<Docente> docente = docSer.findById(id);
		return docente.map(value -> ResponseEntity.ok().body(value)).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<Docente> registrarDocente(@RequestBody Docente docente){
		Docente guardarDocente = docSer.save(docente);
		return ResponseEntity.status(HttpStatus.CREATED).body(guardarDocente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Docente> actualizarDocente(@PathVariable int id, @RequestBody Docente docente){
		Docente actualizarDocente = docSer.update(id, docente);
		if(actualizarDocente != null) {
			return ResponseEntity.ok().body(actualizarDocente);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarDocente(@PathVariable int id){
		docSer.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
