package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.Experiencia;
import com.porfolio.backend.repository.ExperienciaRepository;


@Service
public class ExperienciaService implements IExperienciaService{
	
	@Autowired //anotation que genera una dependencia
	public ExperienciaRepository expRepository;

	@Override
	public List<Experiencia> getExperiencias() {
		List<Experiencia>listaExperiencias=expRepository.findAll();
		return listaExperiencias;
	}

	@Override
	public Experiencia saveExperiencia(Experiencia exp) {
		return expRepository.save(exp);
	}

	@Override
	public void deleteExperiencia(Long id) {
		expRepository.deleteById(id);
	}

	@Override
	public Experiencia findExperiencia(Long id) {
		Experiencia exp=expRepository.findById(id).orElse(null);
		return exp;
	}
	
	
	
	
	
}
