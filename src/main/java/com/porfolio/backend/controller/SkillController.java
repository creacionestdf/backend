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


import com.porfolio.backend.service.ISkillService;

import com.porfolio.backend.model.Skill;

@RestController
@RequestMapping("/skills")

public class SkillController {

	@Autowired
	private ISkillService Iservice;

	// Este metodo sirve para LISTAR todas las...
	@GetMapping("/traer")
	public List<Skill> getSkill() {
		return Iservice.getSkills();
	}

	// Este metodo sirve para CREAR una...
	@PostMapping("/crear")
	public void createSkill(@RequestBody Skill obj) {
		Iservice.saveSkill(obj);
	}

	// Este metodo sirve para BORRAR una...
	@DeleteMapping("/borrar/{id}")
	public void deleteSkill(@PathVariable Long id) {
		Iservice.deleteSkill(id);

	}

	// Este metodo sirve para BUSCAR una...
	@GetMapping("/{id}")
	public ResponseEntity<Skill> obtenerSkillPorId(@PathVariable Long id) {
		Skill obj = Iservice.findSkill(id);
		return ResponseEntity.ok(obj);
	}

	//Este metodo sirve para EDITAR una...
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Skill> actualizarSkill(@PathVariable Long id,	@RequestBody Skill detalles) {
		Skill obj = Iservice.findSkill(id);
		
		obj.setTitulo(detalles.getTitulo());
		obj.setVal(detalles.getVal());
		obj.setReminder(detalles.getReminder());
								
		Skill Actualizada = Iservice.saveSkill(obj);

		return ResponseEntity.ok(Actualizada);

	}
}
