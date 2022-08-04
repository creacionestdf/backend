package com.porfolio.backend.service;

import java.util.List;

import com.porfolio.backend.model.Proyecto;

public interface IProyectoService {
		// TRAE todas las..
		public List<Proyecto> getProyectos();

		// Da de alta una..
		public Proyecto saveProyecto(Proyecto obj);

		//BORRA una..
		public void deleteProyecto(Long id);

		//ENCUENTRA una..
		public Proyecto findProyecto(Long id);
}
