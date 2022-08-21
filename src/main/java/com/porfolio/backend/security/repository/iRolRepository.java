package com.porfolio.backend.security.repository;

import com.porfolio.backend.security.entity.Rol;
import com.porfolio.backend.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol>findByRolNombre(RolNombre rolNombre);
}
