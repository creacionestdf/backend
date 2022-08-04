package com.porfolio.backend.service;

import java.util.List;

import com.porfolio.backend.model.Skill;

public interface ISkillService {

	// TRAE todas las..
	public List<Skill> getSkills();

	// Da de alta una..
	public Skill saveSkill(Skill obj);

	// BORRA una..
	public void deleteSkill(Long id);

	// ENCUENTRA una..
	public Skill findSkill(Long id);
}
