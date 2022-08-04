package com.porfolio.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porfolio.backend.model.Skill;
import com.porfolio.backend.repository.SkillRepository;

@Service
public class SkillService implements ISkillService {

	@Autowired // anotation que genera una dependencia
	public SkillRepository Repository;

	@Override
	public List<Skill> getSkills() {
		List<Skill> lista = Repository.findAll();
		return lista;
	}

	@Override
	public Skill saveSkill(Skill obj) {
		return Repository.save(obj);
	}

	@Override
	public void deleteSkill(Long id) {
		Repository.deleteById(id);

	}

	@Override
	public Skill findSkill(Long id) {
		Skill obj = Repository.findById(id).orElse(null);
		return obj;
	}

}
