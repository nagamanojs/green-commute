package com.zemoso.greencommute.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "skills")
@Data
@NoArgsConstructor
public class Skill {
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="skill_id")
    int skillId;
    @JsonBackReference
    @ManyToMany(mappedBy = "skillsList")
    List<Job> jobList;

     public Skill(String name,int skillId){
        this.name=name;
        this.skillId=skillId;
    }



    public String toString(){
        return "["+name+","+skillId+"]";
    }
}
