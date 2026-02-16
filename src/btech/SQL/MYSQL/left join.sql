create database left_bank;
use left_bank;
create table customer
(
    custid varchar(10),
    fname varchar(10),
    mname varchar(10),
    lname varchar(10),
    city varchar(10),
    mob_num varchar(15),
    occupation varchar(10),
    dob date,
    constraint customer_custid_pk primary key (custid)
);

show tables;
desc left_bank.customer;
create table branch
(
    bid varchar(10),
    bname varchar(10),
    bcity varchar(10),
    constraint branch_bid_pk primary key (bid)
);
create table account
(
    acnumber varchar(10),
    custid varchar(10),
    bid varchar(10),
    opening_balance int (10),
    aod date,
    atype varchar(10),
    astatus varchar(10),
    constraint account_acnum_pk primary key (acnumber),
    constraint account_bid_fk foreign key (bid) references branch(bid),
    constraint account_custid_fk foreign key (custid) references customer(custid)
);

show tables;
describe customer;
describe account;
describe branch;

insert into customer (custid, fname, mname, lname, city, mob_num, occupation, dob)
values ('c001','Varsha',null,'gupta','delhi','2354488545','service','1924-12-23'),
       ('c002','Rohit',null,'gupta','delhi','2354477545','service','1924-12-23'),
       ('c003','Anil','chandra','nair','delhi','23544662345','service','1924-12-23'),
       ('c004','Amit',null,'sharma','delhi','23544655545','service','1924-12-23'),
       ('c005','Jasmine',null,null,'delhi','2356666545','service','1924-12-23');

select *
from customer;

insert into branch (bid, bname, bcity)
values ('b001','Jasmine','Delhi'),
       ('b002','laudi','Delhi'),
       ('b003','varsha','Delhi'),
       ('b004','Abla','Delhi'),
       ('b005','jasu','Delhi');

select *
from branch;

insert into account (acnumber, custid, bid, opening_balance, aod, atype, astatus)
values ('a001','c001','b001',1000,'2004-2-23','Deposit','active'),
       ('a002','c002','b002',1000,'1904-2-12','Savings','deactivate'),
       ('a003','c003','b003',1000,'2005-2-15','Savings','active'),
       ('a004','c004','b004',1000,'2023-2-20','Deposit','deactivate'),
       ('a005','c005','b005',1000,'2024-2-25','Deposit','suspended');

select *
from account;


select count(custid)
from account;

select count(acnumber)
from account;


select *
from  customer
left join account a on customer.custid = a.custid;

select *
from  customer
right join  account a on customer.custid = a.custid;


select *
from  customer
left join account a on customer.custid = a.custid
union
select *
from  customer
right join account a on customer.custid = a.custid;


select *
from  customer
left  outer join account a on customer.custid = a.custid;
select *
from  customer
right  outer join account a on customer.custid = a.custid;
