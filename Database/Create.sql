create database creen_test_servlet;
use creen_test_servlet;

create table Degree
(
    id         bigint auto_increment,
    degreeName nvarchar(255) not null,
    primary key (id)
);

create table Contract
(
    id           bigint auto_increment,
    contractName nvarchar(100) not null,
    primary key (id)
);

create table Teacher
(
    id             bigint auto_increment,
    codeTeacher    varchar(100) unique not null,
    lastName       nvarchar(100)       not null,
    firstName      nvarchar(100)       not null,
    image          varchar(255)        null,
    salary         decimal(10, 2)      not null,
    firstDayOfWork date,
    degreeId       bigint              not null,
    contractId     bigint              not null,
    primary key (id),
    foreign key (degreeId) references Degree (id),
    foreign key (contractId) references Contract (id)
);

create table Acccount
(
    id       bigint auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    role     bit          not null,
    primary key (id)
);


insert into Degree(degreename)
values ('Cử nhân cao đẳng');
insert into Degree(DegreeName)
values ('Cử nhân đại học'),
       ('Thạc sĩ'),
       ('Tiến sĩ'),
       ('Phó giáo sư'),
       ('Giáo sư');
insert into Contract (ContractName)
values ('Part time'),
       ('Full time');
