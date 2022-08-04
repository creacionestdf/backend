package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.Header;
import com.porfolio.backend.repository.HeaderRepository;

@Service
public class HeaderService implements IHeaderService{

	@Autowired //anotation que genera una dependencia
	public HeaderRepository Repository;
	
	@Override
	public List<Header> getHeader() {
		List<Header> lista = Repository.findAll();
		return lista;
	}

	@Override
	public Header saveHeader(Header obj) {
		return Repository.save(obj);
	}

	@Override
	public void deleteHeader(Long id) {
		Repository.deleteById(id);
	}

	@Override
	public Header findHeader(Long id) {
		Header obj = Repository.findById(id).orElse(null);
		return obj;
	}
		
}
