/*
!-- This is default schema used by spring security 
!-- You have to use the same table name and structure
 */

CREATE TABLE IF NOT EXISTS  table users(
    username varchar(50) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);

CREATE TABLE IF NOT EXISTS  authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);