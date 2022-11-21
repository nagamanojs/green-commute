package com.zemoso.greencommute.service;

import com.zemoso.greencommute.dao.SkillsDAO;
import com.zemoso.greencommute.entity.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.Mockito.*;
import com.zemoso.greencommute.service.SkillsService;
@RunWith(MockitoJUnitRunner.class)
public class SkillsServiceImplTest {
    @Mock
    SkillsDAO skillsDAO;

    @InjectMocks
    SkillsServiceImpl skillsService;
    @Test
    public void getSkillByName(){
        Skill skill=new Skill("python",1);
        when(skillsDAO.findByName("python")).thenReturn(skill);
        assertEquals(skill,skillsService.getSkillByName("python"));

    }

}
