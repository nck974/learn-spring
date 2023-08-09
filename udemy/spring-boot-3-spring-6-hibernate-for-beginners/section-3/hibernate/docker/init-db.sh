#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE student_tracker;

    \c student_tracker;

    CREATE TABLE student (
        id SERIAL PRIMARY KEY,
        first_name varchar(45) DEFAULT NULL,
        last_name varchar(45) DEFAULT NULL,
        email varchar(45) DEFAULT NULL
    );
EOSQL
