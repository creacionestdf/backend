package com.porfolio.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.porfolio.backend.service.IHeaderService;
//import com.porfolio.backend.model.Acercade;
import com.porfolio.backend.model.Header;


@RestController
@RequestMapping("/perfil")
@CrossOrigin(origins="*")
public class HeaderController {

	@Autowired
	private IHeaderService Iservice;

	// Este metodo sirve para LISTAR todas las...
	@GetMapping("/traer")
	@ResponseBody
	//@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Header>> getHeader() {
		List<Header> li=Iservice.getHeader();
		return new ResponseEntity<List<Header>>(li, HttpStatus.OK);
	}

	// Este metodo sirve para CREAR una...
	@PostMapping("/crear")
	public void createHeader(@RequestBody Header obj) {
		Iservice.saveHeader(obj);
	}

	// Este metodo sirve para BORRAR una...
	@DeleteMapping("/borrar/{id}")
	public void deleteHeader(@PathVariable Long id) {
		Iservice.deleteHeader(id);

	}

	// Este metodo sirve para BUSCAR una...
	@GetMapping("/{id}")
	public ResponseEntity<Header> obtenerHeaderPorId(@PathVariable Long id) {
		Header obj = Iservice.findHeader(id);
		return ResponseEntity.ok(obj);
	}

	//Este metodo sirve para EDITAR una...
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Header> actualizarHeader(@PathVariable Long id,	@RequestBody Header detalles) {
		Header obj = Iservice.findHeader(id);
		
		obj.setBanner(detalles.getBanner());
		obj.setLogo(detalles.getLogo());
		obj.setFoto(detalles.getFoto());
		obj.setNombre(detalles.getNombre());
		obj.setApellido(detalles.getApellido());
		obj.setEmail(detalles.getEmail());
		obj.setCompania(detalles.getCompania());
		obj.setResidencia(detalles.getResidencia());
				
		Header Actualizada = Iservice.saveHeader(obj);

		return ResponseEntity.ok(Actualizada);

	}
}
