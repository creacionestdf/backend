package com.porfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.porfolio.backend.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long>{}