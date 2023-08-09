#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE employee_directory;
    \c employee_directory;

    --
    -- Table structure for table `employee`
    --


    CREATE TABLE employee (
    id serial PRIMARY KEY,
    first_name varchar(45),
    last_name  varchar(45),
    email varchar(45)
    );

    --
    -- Data for table `employee`
    --

    INSERT INTO employee (id, first_name, last_name, email) VALUES 
        (1, 'Leslie', 'Andrews', 'leslie@test.com'),
        (2, 'Emma', 'Baumgarten', 'emma@test.com'),
        (3, 'Avani', 'Gupta', 'avani@test.com'),
        (4, 'Yuri', 'Petrov', 'yuri@test.com'),
        (5, 'Juan', 'Vega', 'juan@test.com');

EOSQL
