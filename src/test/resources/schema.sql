drop table if exists usr;
drop table if exists product;

create table usr
(
    id int auto_increment primary key,
    login varchar(255),
    name varchar(255),
    password varchar(255),
    status integer
    );

create table product
(
    id int auto_increment primary key,
    description varchar(255),
    logo text,
    name varchar(255)
    );