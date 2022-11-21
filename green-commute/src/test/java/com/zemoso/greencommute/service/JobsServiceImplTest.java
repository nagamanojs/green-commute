package com.zemoso.greencommute.service;

import com.zemoso.greencommute.dao.JobsDAO;
import com.zemoso.greencommute.entity.Job;
import com.zemoso.greencommute.exception.CityNotFoundException;
import com.zemoso.greencommute.exception.JobNotFoundException;
import com.zemoso.greencommute.exception.SkillsNotFoundException;
import com.zemoso.greencommute.service.JobsServiceImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JobsServiceImplTest {
//    @Rule
//    public MockitoRule mockitoRule= MockitoJUnit.rule();
    @Mock
    JobsDAO jobsDAO;
    @InjectMocks
    JobsServiceImpl jobsServiceImpl;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void getAllJobs(){
        when(jobsDAO.findAll()).thenReturn(Arrays.asList(new Job(),new Job()));
        assertThat(jobsServiceImpl.getAllJobs().size(),is(2));
    }
    @Test
    public void getByCity(){
        when(jobsDAO.findByCity("hyderabad")).thenReturn(Arrays.asList(new Job()));
        assertThat(jobsServiceImpl.getByCity("hyderabad").size(),is(1));
    }
    @Test
    public void deleteJob(){
        jobsServiceImpl.deleteJob(0);
        verify(jobsDAO,times(1)).deleteById(0);
    }
    @Test
    public  void saveJob(){
        Job job1=new Job();
        jobsServiceImpl.saveJob(job1);
        verify(jobsDAO,times(1)).save(job1);
    }

    @Test
    public void getJobById_withNoException(){
        Job newJob=new Job(1);
        when(jobsDAO.findById(1)).thenReturn(Optional.of(newJob));
        assertEquals(newJob,jobsServiceImpl.getJobById(1));
    }
    @Test(expected = JobNotFoundException.class)
    public void getJobById_withException(){

        when(jobsDAO.findById(10)).thenThrow(new JobNotFoundException("Job with id not found"));
        jobsServiceImpl.getJobById(10);
    }

    @Test(expected= CityNotFoundException.class)
    public void getAllJobsByCityAndSkills_jobsListEmpty() {
        when(jobsDAO.findByCity("mumbai")).thenReturn(Arrays.asList());
        List<Job> jobs=jobsServiceImpl.getByCity("mumbai");
        if (jobs.isEmpty()) {
            throw new CityNotFoundException("No jobs are found in current city");
        }
    }
    @Test(expected= CityNotFoundException.class)
    public void getAllJobsByCityAndSkills_jobsList() {
        when(jobsDAO.findByCity("mumbai")).thenReturn(Arrays.asList(new Job(1),new Job(2)));
        List<Job> jobs=jobsServiceImpl.getByCity("mumbai");

    }
    @Test(expected= SkillsNotFoundException.class)
    public void getAllJobsByCityAndSkills_matchedJobsEmpty() {
        List<String> skills=mock(List.class);
        System.out.println( skills.size());
        if(skills.size()==0){
            throw  new SkillsNotFoundException("not found");
        }



    }
}

