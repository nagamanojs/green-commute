package com.zemoso.greencommute.dao;

import com.zemoso.greencommute.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JobsDAO extends JpaRepository<Job,Integer> {
    List<Job> findByCity(String cityName);

}
