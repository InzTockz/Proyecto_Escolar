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

import com.escolar.entity.AulaAsignada;
import com.escolar.services.AulaAsignadaService;

@RestController
@RequestMapping("api/aulaasignada")
public class AulaAsignadaController {

	@Autowired
	private AulaAsignadaService auasSer;
	
	@GetMapping
	public List<AulaAsignada> listarAuAsig(){
		return auasSer.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AulaAsignada> listarAuAsigId(@PathVariable int id){
		Optional<AulaAsignada> aulaasig = auasSer.findById(id);
		return aulaasig.map(auasig -> ResponseEntity.ok().body(auasig)).orElse(null);
	}
	
	@PostMapping
	public ResponseEntity<AulaAsignada> registrarAulaAsig(@RequestBody AulaAsignada aulaasig){
		AulaAsignada aulaasignadaRegistrada = auasSer.save(aulaasig);
		return ResponseEntity.status(HttpStatus.CREATED).body(aulaasignadaRegistrada);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<AulaAsignada> actualizarAulaAsig(@PathVariable int id, @RequestBody AulaAsignada aulaasig){
		AulaAsignada actualizarAulaAsig = auasSer.update(id, aulaasig);
		if(actualizarAulaAsig!=null) {
			return ResponseEntity.ok().body(actualizarAulaAsig);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarAulaAsig(@PathVariable int id){
		auasSer.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
