package com.porfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolio.backend.model.Acercade;

@Repository
public interface AcercadeRepository extends JpaRepository <Acercade, Long>{}
