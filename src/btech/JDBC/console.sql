show databases;
use rohit;
select * from students;
create table  account (
    ID int AUTO_INCREMENT PRIMARY KEY  NOT NULL   ,
    Acc_No int not null  ,
    Name varchar(20) NOT NULL ,
    Balance DOUBLE DEFAULT 1000.0
);
Insert into account(ID, Acc_No, Name,Balance) value
    (1,123123,'Varsha',2000.0);
 drop table account;
show databases ;
create database  if not exists Bus_Management;

use Bus_Management;
create table if not exists Bus(
    Bus_No int not null AUTO_INCREMENT PRIMARY KEY  ,
    BusID  int(4) not null  ,
    Bus_name varchar (15) not null ,
    Register_Date DATE not null ,
    Capacity int(2) not null,
    Fees_InRupees DOUBLE not null ,
    Available varchar(2),
    Starting_Point varchar(20),
    End_Point varchar(20)
);
create table if not exists Passenger(
    Pass_No int not null AUTO_INCREMENT,
    PassID int not null ,
    Pass_name varchar(15) not null ,
    Age int(2) not null ,
    DATEBooking DATE not null ,
    Amount DOUBLE not null ,
    FOREIGN KEY (Pass_No) REFERENCES Bus(Bus_No)
);
use Bus_Management;
drop table bus;
drop table passenger;
show tables ;
select * from bus;
select * from passenger;
desc table bus;

delete from bus where Bus_No=2;
DELETE FROM Passenger;

-- Drop the foreign key constraint
ALTER TABLE Passenger DROP FOREIGN KEY passenger_ibfk_1;
-- Truncate the Passenger table
truncate table bus;
-- Recreate the foreign key constraint
ALTER TABLE Passenger ADD CONSTRAINT passenger_ibfk_1 FOREIGN KEY (Pass_No) REFERENCES Bus(Bus_No);


INSERT INTO Bus (BusID, Bus_name, Register_Date, Capacity, Fees_InRupees,  Starting_Point, End_Point) VALUES (3322,'Test',2023-02-02,250,2500,'Delhi','Noida')