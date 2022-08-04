package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.Certificacion;
import com.porfolio.backend.repository.CertificacionRepository;


@Service
public class CertificacionService implements ICertificacionService{

	@Autowired //anotation que genera una dependencia
	public CertificacionRepository certRepository;
		
	
	@Override
	public List<Certificacion> getCertificaciones() {
		List<Certificacion>lista=certRepository.findAll();
		return lista;
	}
		

	@Override
	public Certificacion saveCertificacion(Certificacion obj) {
		return certRepository.save(obj);
	}

		
	@Override
	public void deleteCertificacion(Long id) {
		certRepository.deleteById(id);
	}

	
	@Override
	public Certificacion findCertificacion(Long id) {
		Certificacion cert=certRepository.findById(id).orElse(null);
		return cert;
	}
	
}
