package com.porfolio.backend.service;


import java.util.List;

import com.porfolio.backend.model.Acercade;


public interface IAcercadeService {
	
	// TRAE todas las..
		public List<Acercade> getAcercade();

		// Da de alta una..
		public Acercade saveAcercade(Acercade obj);

		// BORRA una..
		public void deleteAcercade(Long id);

		// ENCUENTRA una..
		public Acercade findAcercade(Long id);

}
