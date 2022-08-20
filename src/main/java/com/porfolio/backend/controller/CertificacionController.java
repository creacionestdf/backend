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

import com.porfolio.backend.service.ICertificacionService;
import com.porfolio.backend.model.Certificacion;

@RestController
@RequestMapping("/certificaciones")
@CrossOrigin(origins = "https://porfolioweb-14781.web.app")

public class CertificacionController {

	@Autowired
	private ICertificacionService ICertificacion;

	// Este metodo sirve para LISTAR todas las...
	@GetMapping("/traer")
	public List<Certificacion> getCertificacion() {
		return ICertificacion.getCertificaciones();
	}

	// Este metodo sirve para CREAR una...
	@PostMapping("/crear")
	public void createCertificacion(@RequestBody Certificacion cert) {
		ICertificacion.saveCertificacion(cert);
	}

	// Este metodo sirve para BORRAR una...
	@DeleteMapping("/borrar/{id}")
	public void deleteCertificacion(@PathVariable Long id) {
		ICertificacion.deleteCertificacion(id);

	}

	// Este metodo sirve para BUSCAR una...
	@GetMapping("/{id}")
	public ResponseEntity<Certificacion> obtenerCertificacionPorId(@PathVariable Long id) {
		Certificacion cert = ICertificacion.findCertificacion(id);
		return ResponseEntity.ok(cert);
	}

	//Este metodo sirve para EDITAR una...
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Certificacion> actualizarCertificacion(@PathVariable Long id,	@RequestBody Certificacion detalles) {
		Certificacion obj = ICertificacion.findCertificacion(id);

		obj.setLogo(detalles.getLogo());
		obj.setTitulo(detalles.getTitulo());
		obj.setEntidad(detalles.getEntidad());
		obj.setFecha(detalles.getFecha());
		obj.setDescripcion(detalles.getDescripcion());

		Certificacion Actualizada = ICertificacion.saveCertificacion(obj);

		return ResponseEntity.ok(Actualizada);

	}

	
}
