package com.porfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.porfolio.backend.service.IExperienciaService;
import com.porfolio.backend.model.Experiencia;

@RestController
@RequestMapping("/experiencias")

public class ExperienciaController {
	
	@Autowired
	private IExperienciaService IExperiencia;
	
	@GetMapping("/traer")
	public List<Experiencia>getExperiencia(){
		return IExperiencia.getExperiencias();
	}
	
	@GetMapping("/hola")
	public String saludar() {
		return "Hola rodrigo";
	}
	
	//
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/crear")
	public void createExperiencia(@RequestBody Experiencia exp) {
		IExperiencia.saveExperiencia(exp);
	}
	
	//
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/borrar/{id}")
	public void deleteExperiencia(@PathVariable Long id) {
		IExperiencia.deleteExperiencia(id);
		
	}
	
	//Este metodo sirve  para buscar una experiencia
	@GetMapping("/{id}")
	public ResponseEntity<Experiencia> obtenerExperienciaPorId(@PathVariable Long id){
		Experiencia exp=IExperiencia.findExperiencia(id);
		return ResponseEntity.ok(exp);
	}
		
	//
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Experiencia> actualizarExperiencia(@PathVariable Long id, @RequestBody Experiencia detallesExp){
		Experiencia exp=IExperiencia.findExperiencia(id);
				
		exp.setImagen(detallesExp.getImagen());
		exp.setTitulo(detallesExp.getTitulo());
		exp.setCargo(detallesExp.getCargo());
		exp.setJornada(detallesExp.getJornada());
		exp.setTiempo(detallesExp.getTiempo());
		exp.setDireccion(detallesExp.getDireccion());
		exp.setDescripcion(detallesExp.getDescripcion());
		exp.setReminder(detallesExp.getReminder());
		
		Experiencia expActualizada = IExperiencia.saveExperiencia(exp);
				
		return ResponseEntity.ok(expActualizada);
	
	}
	
	
	
	//Este metodo sirve para editar una experiencia
	@PutMapping("/editar/{id}")
	public Experiencia editExperiencia(
			@PathVariable Long id, 
			
			@RequestParam("img") String newImagen,
			@RequestParam("tit") String newTitulo,
			@RequestParam("car") String newCargo,
			@RequestParam("jor") String newJornada,
			@RequestParam("tmp") String newtiempo,
			@RequestParam("dir") String newDireccion,
			@RequestParam("desc") String newDescripcion,
			@RequestParam("rem") Boolean newReminder	
	){
		
		//Busca la Experiencia en cuestion
		Experiencia exp= IExperiencia.findExperiencia(id);
		
		
		//esto tambien puede ir en service
		//para desacoplar mejor aun el codigo en un nuevo metodo
		
		exp.setImagen(newImagen);
		exp.setTitulo(newTitulo);
		exp.setCargo(newCargo);
		exp.setJornada(newJornada);
		exp.setTiempo(newtiempo);
		exp.setDireccion(newDireccion);
		exp.setDescripcion(newDescripcion);
		exp.setReminder(newReminder);
		
		IExperiencia.saveExperiencia(exp);
				
		//retorna la nueva Experiencia
		return exp;
		
		
	}
	
}
