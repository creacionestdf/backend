package com.porfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.porfolio.backend.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository <Proyecto, Long>{}
