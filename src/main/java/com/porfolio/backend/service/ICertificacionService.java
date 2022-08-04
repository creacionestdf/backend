package com.porfolio.backend.service;

import java.util.List;
import com.porfolio.backend.model.Certificacion;

public interface ICertificacionService {

	// TRAE todas las...
	public List<Certificacion> getCertificaciones();

	// Da de alta una...
	public Certificacion saveCertificacion(Certificacion obj);

	//BORRA una...
	public void deleteCertificacion(Long id);

	//ENCUENTRA una...
	public Certificacion findCertificacion(Long id);
}
