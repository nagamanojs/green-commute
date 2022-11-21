package com.zemoso.greencommute.service;

import com.zemoso.greencommute.dao.JobsDAO;
import com.zemoso.greencommute.entity.Job;
import com.zemoso.greencommute.exception.CityNotFoundException;
import com.zemoso.greencommute.exception.JobNotFoundException;
import com.zemoso.greencommute.exception.SkillsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class JobsServiceImpl implements JobsService{
    @Autowired
    JobsDAO jobsDAO;
    @Override
    @Transactional
    public List<Job> getAllJobsByCityAndSkills(String cityName, List<String> skills) {
        List<Job> jobs= jobsDAO.findByCity(cityName);
        if(jobs.isEmpty()){
            throw new CityNotFoundException("No Jobs  are present in current city: "+cityName);
        }
        List<Job> matchedJobs=new ArrayList<>();
      for(Job job:jobs){
          if(skills.containsAll(job.skillsByName())){
              matchedJobs.add(job);
          }
      }
      if(matchedJobs.isEmpty()){
          throw new SkillsNotFoundException("Your Skills does not match with any job");
      }
      return  matchedJobs;
    }

    @Override
    @Transactional
    public Job getJobById(int id) {
         Optional<Job> job =jobsDAO.findById(id);
         Job tempJob=null;
         if(job.isPresent()){
            tempJob=job.get();
         }
         else{
             throw new JobNotFoundException("Job with id not found:"+id);
         }
         return tempJob;
    }

    @Override
    @Transactional
    public void saveJob(Job job) {
        jobsDAO.save(job);
    }

    @Override
    @Transactional
    public void deleteJob(int id) {
        jobsDAO.deleteById(id);

    }

    @Override
    @Transactional
    public List<Job> getByCity(String cityName) {
        return jobsDAO.findByCity(cityName);
    }

    @Override
    @Transactional
    public List<Job> getAllJobs() {
        return jobsDAO.findAll();
    }
}
