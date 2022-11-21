package com.zemoso.greencommute.service;

import com.zemoso.greencommute.entity.Job;

import java.util.List;

public interface JobsService {
    List<Job> getAllJobsByCityAndSkills(String cityName, List<String> skills);
    Job getJobById(int id);
    void saveJob(Job job);
    void deleteJob(int id);
    List<Job> getByCity(String city);
    List<Job> getAllJobs();




}
