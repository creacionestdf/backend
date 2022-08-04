package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.Proyecto;
import com.porfolio.backend.repository.ProyectoRepository;

@Service
public class ProyectoService implements IProyectoService{

	@Autowired //anotation que genera una dependencia
	public ProyectoRepository Repository;
		
	@Override
	public List<Proyecto> getProyectos() {
		List<Proyecto>lista=Repository.findAll();
		return lista;
	}
	
	@Override
	public Proyecto saveProyecto(Proyecto obj) {
		return Repository.save(obj);
	}

	@Override
	public void deleteProyecto(Long id) {
		Repository.deleteById(id);
	}
	
	@Override
	public Proyecto findProyecto(Long id) {
		Proyecto obj=Repository.findById(id).orElse(null);
		return obj;
	}
	
	
}
