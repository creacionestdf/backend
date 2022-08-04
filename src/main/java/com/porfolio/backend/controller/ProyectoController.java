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


import com.porfolio.backend.service.IProyectoService;

import com.porfolio.backend.model.Proyecto;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")

public class ProyectoController {

	@Autowired
	private IProyectoService Iservice;

	// Este metodo sirve para LISTAR todas las...
	@GetMapping("/traer")
	public List<Proyecto> getProyectos() {
		return Iservice.getProyectos();
	}

	// Este metodo sirve para CREAR una...
	@PostMapping("/crear")
	public void createProyecto(@RequestBody Proyecto obj) {
		Iservice.saveProyecto(obj);
	}

	// Este metodo sirve para BORRAR una...
	@DeleteMapping("/borrar/{id}")
	public void deleteProyecto(@PathVariable Long id) {
		Iservice.deleteProyecto(id);

	}

	// Este metodo sirve para BUSCAR una...
	@GetMapping("/{id}")
	public ResponseEntity<Proyecto> obtenerProyectoPorId(@PathVariable Long id) {
		Proyecto obj = Iservice.findProyecto(id);
		return ResponseEntity.ok(obj);
	}

	//Este metodo sirve para EDITAR una...
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Proyecto> actualizarProyecto(@PathVariable Long id,	@RequestBody Proyecto detalles) {
		Proyecto obj = Iservice.findProyecto(id);
		
		obj.setTitulo(detalles.getTitulo());
		obj.setFecha(detalles.getFecha());
		obj.setDescripcion(detalles.getDescripcion());
		obj.setLogo(detalles.getLogo());
		obj.setLink(detalles.getLink());
				
		Proyecto Actualizada = Iservice.saveProyecto(obj);

		return ResponseEntity.ok(Actualizada);

	}
}
