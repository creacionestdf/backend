package com.porfolio.backend.service;

import java.util.List;
import com.porfolio.backend.model.Experiencia;

public interface IExperienciaService {
	//Metodo para traer todas las Experiencias
	public List<Experiencia> getExperiencias();
			
	//Metodo para dar de alta una Experiencia
	public Experiencia saveExperiencia(Experiencia exp);
			
	//Metodo para borrar una Experiencia
	public void deleteExperiencia(Long id);
		
	//Metodo para encontrar una Experiencia
	public Experiencia findExperiencia(Long id);
	
}
