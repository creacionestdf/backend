package com.porfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.porfolio.backend.model.Header;

@Repository
public interface HeaderRepository extends JpaRepository <Header, Long>{}
