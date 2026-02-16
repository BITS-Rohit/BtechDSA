show databases;
create database if not exists rohit;
use rohit;
create table datad(
my_id int,
my_name varchar(100),
course_name varchar (40)
);
show tables;
describe datad;
alter table datad add gender varchar (10);
show tables;
use rohit;

describe datad;
insert into datad (my_id,my_name,course_name,gender)
values(001,'Radhe radhe', 'none','M');
insert into datad (my_id,my_name,course_name,gender)
values(002,'Sujal', 'medical','M');
insert into datad (my_id,my_name,course_name,gender)
values(003,'vipul', 'Meechanics','M');
insert into datad (my_id,my_name,course_name,gender)
values(004,'Jasmine', 'medical','F');
insert into datad (my_id,my_name,course_name,gender)
values(005,'Rohit', 'Cse','M');
insert into datad (my_id,my_name,course_name,gender)
values(005,'Rohit', 'IT','M');

describe datad;
select  course_name,my_name from datad;
delete from datad where my_name = 'rohit' and course_name = 'IT';
select * from datad;
select * from datad where not my_name='rohit';
use rohit;
SElect * from datad where my_name like 'R%';