#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE instructor_directory;

    \c instructor_directory;


    -- Create table instructor_detail
    CREATE TABLE 
        instructor_detail 
    (
        id SERIAL PRIMARY KEY,
        youtube_channel varchar(128),
        hobby varchar(45)
    );

    -- Create table instructor
    CREATE TABLE 
        instructor 
    (
        id SERIAL PRIMARY KEY,
        first_name varchar(45),
        last_name varchar(45),
        email varchar(45),
        instructor_detail_id int,
        CONSTRAINT FK_DETAIL FOREIGN KEY (
            instructor_detail_id
            ) REFERENCES instructor_detail (id) 
            ON DELETE NO ACTION ON UPDATE NO ACTION
    );

    -- Create table course
    CREATE TABLE course (
        id SERIAL PRIMARY KEY,
        title VARCHAR(128) UNIQUE,
        instructor_id INT,
        
        CONSTRAINT FK_INSTRUCTOR
        FOREIGN KEY (instructor_id)
        REFERENCES instructor (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
    );

    -- Create table review
    CREATE TABLE review (
        id SERIAL PRIMARY KEY,
        comment VARCHAR(256),
        course_id INT,

        CONSTRAINT FK_COURSE
        FOREIGN KEY (course_id)
        REFERENCES course (id)
        ON DELETE NO ACTION ON UPDATE NO ACTION
    );

EOSQL
