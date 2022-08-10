package com.porfolio.backend.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porfolio.backend.service.IAcercadeService;
import com.porfolio.backend.model.Acercade;


@RestController
@RequestMapping("/acercade")
@CrossOrigin(origins = "https://porfolioweb-14781.web.app:8080")

public class AcercadeController {

	@Autowired
	private IAcercadeService Iservice;

	// Este metodo sirve para LISTAR todas las...
	@GetMapping("/traer")
	public List<Acercade> getAcercade() {
		return Iservice.getAcercade();
	}

	// Este metodo sirve para CREAR una...
	@PostMapping("/crear")
	public void createAcercade(@RequestBody Acercade obj) {
		Iservice.saveAcercade(obj);
	}

	// Este metodo sirve para BORRAR una...
	@DeleteMapping("/borrar/{id}")
	public void deleteAcercade(@PathVariable Long id) {
		Iservice.deleteAcercade(id);

	}

	// Este metodo sirve para BUSCAR una...
	@GetMapping("/{id}")
	public ResponseEntity<Acercade> obtenerAcercadePorId(@PathVariable Long id) {
		Acercade obj = Iservice.findAcercade(id);
		return ResponseEntity.ok(obj);
	}

	//Este metodo sirve para EDITAR una...
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Acercade> actualizarAcercade(@PathVariable Long id,	@RequestBody Acercade detalles) {
		Acercade obj = Iservice.findAcercade(id);
		
		obj.setObjetivo(detalles.getObjetivo());
		
		Acercade Actualizada = Iservice.saveAcercade(obj);
		
		return ResponseEntity.ok(Actualizada);

	}
}
