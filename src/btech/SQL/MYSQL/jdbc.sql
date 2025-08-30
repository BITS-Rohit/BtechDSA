show databases;
create database rohit;
use rohit;
SHOW TABLES ;
create Table students(
    id int AUTO_INCREMENT primary key,
    name varchar(25) not null,
    age int not null,
    marks double not null
);

insert into students(id, name, age, marks) value
    (1,'Rohit',19,89);
desc students;
show databases;
