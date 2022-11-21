create schema if not exists `green_commute_db`;
use  `green_commute_db`;
create table `jobs`(
	id int auto_increment not null,
	title varchar(100),company varchar(45) not null,
	locality varchar(45),
	city varchar(45) not null,
    pincode int(6),
    bike tinyint(1),
    bus tinyint(1),
    car tinyint(1),
    train tinyint(1),
    created_time datetime,
    primary key(id)
    );

create table skills (
	name varchar(100) not null,
    primary key(name)
);
create table job_skills(
	id int,
    name varchar(100),
    primary key(id,name),
    constraint `fk_job_skills_jobs`
    foreign key(id) references jobs(id) on update no action on delete no action,
    constraint `fk_job_skills_skill`
    foreign key(name) references skills(name) on update no action on delete no action        
);
    
    
