drop table if exists usr;
drop table if exists product;
drop table if exists mark;
drop table if exists usr_mark;
drop table if exists product_mark;

create table if not exists usr
(
    id       int auto_increment primary key,
    login    varchar(255),
    name     varchar(255),
    password varchar(255),
    status   integer
    );

create table if not exists product
(
    id          int auto_increment primary key,
    description varchar(255),
    logo        text,
    name        varchar(255)
    );

create table if not exists mark
(
    id         int auto_increment primary key,
    mark       integer,
    product_id integer,
    user_id    integer
);

create table if not exists mark
(
    id         int auto_increment primary key,
    mark       integer,
    product_id integer,
    user_id    integer
);

create table if not exists product_mark
(
    product_id integer,
    marks_id   integer
);

create table if not exists usr_mark
(
    usr_id   integer,
    marks_id integer
);