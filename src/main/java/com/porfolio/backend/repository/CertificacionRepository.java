package com.porfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.porfolio.backend.model.Certificacion;

@Repository
public interface CertificacionRepository extends JpaRepository <Certificacion, Long>{}
