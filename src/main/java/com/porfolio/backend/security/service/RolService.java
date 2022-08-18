package com.porfolio.backend.security.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.security.entity.Rol;
import com.porfolio.backend.security.enums.RolNombre;
import com.porfolio.backend.security.repository.iRolRepository;

@Service
@Transactional
public class RolService {
	@Autowired
	iRolRepository irolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return irolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		irolRepository.save(rol);
	}
}

