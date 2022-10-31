package com.porfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.porfolio.backend.model.ImageModel;

@Repository
public interface Imagen2Repository extends JpaRepository <ImageModel, Long>{}

