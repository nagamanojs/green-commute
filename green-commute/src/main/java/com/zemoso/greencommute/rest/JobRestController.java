package com.zemoso.greencommute.rest;

import com.zemoso.greencommute.entity.Job;
import com.zemoso.greencommute.exception.JobNotFoundException;
import com.zemoso.greencommute.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class JobRestController  {
    @Autowired
    JobsService jobsService;
    @GetMapping("/jobs")
    public List<Job> getJobs(@RequestParam(name="city") Optional<String> cityName, @RequestParam(name="skill") Optional<List<String>> skills){
        if(cityName.isEmpty()&&skills.isEmpty()){
            return jobsService.getAllJobs();
        }
        else if(cityName.isPresent()&& skills.isEmpty()){
            return jobsService.getByCity(cityName.get());
        }
        String city = null;
        if(cityName.isPresent()){
            city=cityName.get();
        }
        return jobsService.getAllJobsByCityAndSkills(city, skills.get());
    }
    @GetMapping("/jobs/{id}")
    public Job getJobs(@PathVariable int id)  {
        Job job;
        try{
         job=jobsService.getJobById(id);
        }
        catch (Exception ex){
            throw new JobNotFoundException("Job with id not found:"+id);
        }
        return job;
    }
    @PutMapping("/jobs")
    public Job editJob(@RequestBody Job job){
        jobsService.saveJob(job);
        return job;
    }
    @PostMapping("/jobs")
    public void saveJob(@RequestBody Job job) {
        job.setId(0);

            jobsService.saveJob(job);
        }

    @DeleteMapping("/jobs/{id}")
    public void delete(@PathVariable int id){
        jobsService.deleteJob(id);
    }



}
