show databases;
create database Sex;
use Sex;


create table Mens (
    Mens_ID varchar(10),
    Fitness char(10),
    Names varchar(20),
    Size int(10)
);

insert into Mens (Mens_ID, Fitness, Names, Size)
values
    ('M001','Strong','Johnny',7),
    ('M002','Strong','John cina',6),
    ('M003','Average','Little Johnny',4),
    ('M004','Strong','Ronaldo',9);

TRUNCATE Mens;

select * from Mens;

select names from Mens where Fitness = 'Average';

Create Table Woman (
    Woman_ID varchar(10),
    Fitness char(10),
    Names varchar(20),
    Deepness int(10)
);

insert into Woman (Woman_ID, Fitness, Names, Deepness)
values
    ('W001','Strong','Ryu',7),
    ('W002','Strong','Megumi',6),
    ('W003','Average', 'Little Megumi',4),
    ('W004','Strong','EROTIC QUEEN',9);
select * from Woman;

show databases;
# use xyz;
# show tables;
# desc account;
# select * from xyz.account;
# select * from xyz.test_company;
# DROP DATABASE xyz;

# desc sys.sys_config;
use Sex;
select * from Woman;
select * from Mens;

UPDATE Mens
SET Size =8 where Names='John cina';

# SELECT * from Mens order by Size DESC;
SELECT Names,Size from Mens order by Size;

select *
from Mens m
    join Woman w on m.Mens_ID=w.Woman_ID;

select * from Mens
left join Mens m on Mens.Mens_ID = m.Mens_ID;

select Mens.Mens_ID , Woman.Woman_ID
from Woman , Mens
INNER JOIN sex.mens m on Mens.Mens_ID = m.Mens_ID;

select Mens.Mens_ID, Woman.Woman_ID, Mens.Names,Woman.Names
from Mens
LEFT OUTER JOIN Woman on Mens.Mens_ID= Woman_ID;

select Mens.Mens_ID, Woman.Woman_ID, Mens.Names,Woman.Names
from Mens
RIGHT JOIN sex.woman on Woman.Woman_ID = Woman_ID;

# select Names from Mens
# Minus
# select Names from Woman;
show databases;

use rohit;
show tables;
create Table JDBC(
    id int AUTO_INCREMENT primary key,
    name varchar(25) not null,
    age int not null,
    marks double not null
);
drop table JDBC;
desc jdbc;
select  * from Sex.Woman;

CREATE USER "jdbc" IDENTIFIED BY "root";
select user,host from mysql.user;
