package com.zemoso.greencommute.dao;

import com.zemoso.greencommute.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsDAO extends JpaRepository<Skill,String> {
    Skill findByName(String name);
}
