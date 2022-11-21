package com.zemoso.greencommute.service;

import com.zemoso.greencommute.dao.SkillsDAO;
import com.zemoso.greencommute.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillsServiceImpl implements  SkillsService {
    @Autowired
    SkillsDAO skillsDAO;
    @Override
    @Transactional
    public Skill getSkillByName(String name) {
        return skillsDAO.findByName(name);

    }

}
