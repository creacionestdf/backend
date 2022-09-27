package com.porfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@CrossOrigin(origins="*")

public class AcercadeController {

	@Autowired 
	IAcercadeService Iservice;

	// Este metodo sirve para LISTAR todas las...
	@GetMapping("/traer")
	public ResponseEntity<List<Acercade>> getAcercade() {
		List<Acercade> li= Iservice.getAcercade();
		return new ResponseEntity<List<Acercade>>(li, HttpStatus.OK);
	}

	
	//Para CREAR una...
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/crear")
	public void createAcercade(@RequestBody Acercade obj) {
		Iservice.saveAcercade(obj);
	}

	
	// Este metodo sirve para BORRAR una...
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void deleteAcercade(@PathVariable Long id) {
		Iservice.deleteAcercade(id);

	}

	
	// Este metodo sirve para BUSCAR una...
	@GetMapping("/{id}")
	public  void obtenerAcercadePorId(@PathVariable Long id) {
		Iservice.findAcercade(id);
	}

	
	//Este metodo sirve para EDITAR una...
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Acercade> actualizarAcercade(@PathVariable Long id,	@RequestBody Acercade detalles) {
		Acercade obj = Iservice.findAcercade(id);
		
		obj.setObjetivo(detalles.getObjetivo());
		
		Acercade Actualizada = Iservice.saveAcercade(obj);
		
		return new ResponseEntity<Acercade>(Actualizada, HttpStatus.OK);

	}
}
