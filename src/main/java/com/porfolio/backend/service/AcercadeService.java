package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.Acercade;
import com.porfolio.backend.repository.AcercadeRepository;


@Service
public class AcercadeService implements IAcercadeService {

	@Autowired AcercadeRepository Repository;

	@Override
	public List<Acercade> getAcercade() {
		List<Acercade> lista = Repository.findAll();
		return lista;
	}

	@Override
	public Acercade saveAcercade(Acercade obj) {
		return Repository.save(obj);
	}

	@Override
	public void deleteAcercade(Long id) {
		Repository.deleteById(id);
		
	}

	@Override
	public Acercade findAcercade(Long id) {
		Acercade obj = Repository.findById(id).orElse(null);
		return obj;
	}
	
		
	
}
