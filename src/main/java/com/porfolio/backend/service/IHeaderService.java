package com.porfolio.backend.service;

import java.util.List;

import com.porfolio.backend.model.Header;

public interface IHeaderService {

	//Metodo para traer todas las Experiencias
		public List<Header> getHeader();
				
		//Metodo para dar de alta una Experiencia
		public Header saveHeader(Header obj);
				
		//Metodo para borrar una Experiencia
		public void deleteHeader(Long id);
			
		//Metodo para encontrar una Experiencia
		public Header findHeader(Long id);
}
