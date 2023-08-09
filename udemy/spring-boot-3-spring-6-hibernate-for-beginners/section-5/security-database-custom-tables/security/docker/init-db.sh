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

    CREATE TABLE members (
        user_id varchar(50) NOT NULL,
        pw varchar(68) NOT NULL,
        active boolean NOT NULL,
        PRIMARY KEY (user_id)
    );
    
    INSERT INTO 
        members
    VALUES 
        ('test1','{bcrypt}\$2a\$12\$fcWs9tYwF7ZI30CpCXuupOX6P48LX5UTXC9ddzhy2Nr4oqIUSXACS',TRUE),
        ('test2','{bcrypt}\$2a\$12\$/rlSa3spSGKtWjsjjuZMoe0CtDZMdVkd2NKmz3tY7V5VhFUVkKz7i',TRUE),
        ('test3','{bcrypt}\$2a\$12\$WhJ.OCra4rYEPOmPsIcvcO01VPlZ6x.FdYfT4737I9eEoci7z05t.',TRUE);

    CREATE TABLE roles (
        user_id varchar(50) NOT NULL,
        role varchar(50) NOT NULL,
        CONSTRAINT user_id_pk PRIMARY KEY (user_id, role),
        CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES members (user_id)
    );

    INSERT INTO 
        roles
    VALUES 
        ('test1','ROLE_EMPLOYEE'),
        ('test2','ROLE_EMPLOYEE'),
        ('test2','ROLE_MANAGER'),
        ('test3','ROLE_EMPLOYEE'),
        ('test3','ROLE_MANAGER'),
        ('test3','ROLE_ADMIN');

EOSQL
