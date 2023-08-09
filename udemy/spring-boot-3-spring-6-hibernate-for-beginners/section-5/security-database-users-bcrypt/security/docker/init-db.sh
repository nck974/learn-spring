#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE employee_directory;

    \c employee_directory;

    CREATE TABLE employee (
        id SERIAL PRIMARY KEY,
        first_name varchar(45) DEFAULT NULL,
        last_name varchar(45) DEFAULT NULL,
        email varchar(45) DEFAULT NULL
    );
    
    INSERT INTO employee VALUES 
        (1,'Leslie','Andrews','leslie@luv2code.com'),
        (2,'Emma','Baumgarten','emma@luv2code.com'),
        (3,'Avani','Gupta','avani@luv2code.com'),
        (4,'Yuri','Petrov','yuri@luv2code.com'),
        (5,'Juan','Vega','juan@luv2code.com');

    CREATE TABLE users (
        username varchar(50) NOT NULL,
        password varchar(68) NOT NULL,
        enabled boolean NOT NULL,
        PRIMARY KEY (username)
    );
    
    INSERT INTO 
        users
    VALUES 
        ('test1','{bcrypt}\$2a\$12\$fcWs9tYwF7ZI30CpCXuupOX6P48LX5UTXC9ddzhy2Nr4oqIUSXACS',TRUE),
        ('test2','{bcrypt}\$2a\$12\$/rlSa3spSGKtWjsjjuZMoe0CtDZMdVkd2NKmz3tY7V5VhFUVkKz7i',TRUE),
        ('test3','{bcrypt}\$2a\$12\$WhJ.OCra4rYEPOmPsIcvcO01VPlZ6x.FdYfT4737I9eEoci7z05t.',TRUE);

    CREATE TABLE authorities (
        username varchar(50) NOT NULL,
        authority varchar(50) NOT NULL,
        CONSTRAINT authorities_pk PRIMARY KEY (username, authority),
        CONSTRAINT authorities_fk FOREIGN KEY (username) REFERENCES users (username)
    );

    INSERT INTO 
        authorities
    VALUES 
        ('test1','ROLE_EMPLOYEE'),
        ('test2','ROLE_EMPLOYEE'),
        ('test2','ROLE_MANAGER'),
        ('test3','ROLE_EMPLOYEE'),
        ('test3','ROLE_MANAGER'),
        ('test3','ROLE_ADMIN');

EOSQL
