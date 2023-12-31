# Learn spring

This repository contains my steps learning spring.

## Day 1

1. Buy Udemy course "Spring Boot 3, Spring 6 & Hibernate for Beginners".
1. Udemy Section 1: NEW - Spring Boot 3 Quick Start.

## Day 2

1. Test the creation of a first project:
    1. Create a first project using [the spring project initializer](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.1&packaging=jar&jvmVersion=17&groupId=dev.nichoko&artifactId=first-project&name=first-project&description=Demo%20project%20for%20Spring%20Boot&packageName=dev.nichoko.first-project&dependencies=web,security,actuator).
    1. Import the project.
    1. Run the project with `mvn spring-boot:run`.
    1. Check initial `pom.xml`.
    1. Make use of the actuator endpoints `info` and `health`.
    1. Create first rest endpoint.
    1. Pass custom properties from the `application.properties`.
    1. Enable `spring-boot-devtools` to allow auto refresh for development.
1. Udemy Section 1: NEW - Inversion of control and Dependency Injection.
    1. Inversion of control: Objects created by spring.
    1. Dependency injection: Parameters provided by spring.
    1. Can be done by java annotations or by java source code.

## Day 3

1. Udemy Section 2 (32..45).

## Day 4

1. Udemy Section 2 finished (46..60).
1. Practice project:
    1. Create a project an make use of dependency injection.
    1. Use constructor and setters to `autowire` a class.
    1. Import from a different package within the same application using `scanBasePackages`.
    1. Manage priority with `qualifier` or `primary`.
    1. Add global lazy initialization with `spring.main.lazy-initialization`.
    1. Add bean scopes `Singleton` and `Prototype`.
    1. Declare a new `Bean` in a `Configuration` instead of using a `Component`.

## Day 5

1. Udemy Section 3 (60..88):
1. Practice project:
    1. Create a postgres database and connect.
    1. Create new `Entity` with some fields.
    1. Create a `DAO` (Data Access Object) interface.
    1. Create DAO implementation to save in the database.
    1. Create DAO implementation to read in the database.

## DAY 6

1. Udemy Section 4 (89..113):
1. Practice project:
    1. Create DAO implementation to query in the database.
    1. Create DAO implementation to delete from the database.
1. Practice project REST.
    1. Create a new project with spring web and dev tools.
    1. Create an endpoint to return a list of elements or a single element.

## Day 7

1. Practice project REST:
    1. Implement error handling with `ExceptionHandler` and `ControllerAdvice`.

## Day 8

1. Udemy Section 4 (113..118)

## Day 9

1. Udemy Section 4 (118..123)
1. Practice project REST + DAO:
    1. Initialize project with web + dao + dev tools + postgres driver.
    1. Create entity.
    1. Create DAO.
    1. Create DAOImpl.
    1. Create REST endpoint.

## Day 10

1. Udemy Section 5 (123..141).
1. Practice project REST + DAO:
    1. Create a service.
    1. Create all rest endpoints.
    1. Test endpoints with postman.
    1. Make use of Data JPA to remove DAO and DaoImpl.

## Day 11

1. Practice project Spring Security:
    1. Create basic authentication users in memory (hardcoded).
    1. Protect endpoints based on roles.
    1. Disable csrf.
    1. Create basic authentication users with database in plain text.
    1. Create basic authentication users with database using bcrypt.
    1. Create basic authentication users with custom database tables.

## Day 12

1. Udemy Section 6 (159..163).
1. Udemy Section 9 (219..228).
1. Practice project JPA + table mappings:
    1. Create new sql table with relations one to one.
    1. Create entity with relations one to one.

## Day 13

1. Udemy Section 9 (228..267).
1. Practice project JPA + table mappings:
    1. Perform JPA operations to relations one to one.
    1. Apply different cascading types.

## Day 14

1. Udemy Section 9 (268..279).
1. Practice project JPA + table mappings:
    1. Perform JPA operations to relations one to many and many to one.

## Day 15

1. Udemy Section 9 (280..302).
1. Practice project JPA + table mappings:
    1. Perform JPA operations to relations many to many.

## Day 16

1. Udemy section 10 (303-339).
1. Practice project AOP:
    1. Create empty project.
    1. Use `spring-boot-starter-aop`.
    1. Use `@Before` annotation of aop to execute code before other methods using `Pointcut` expressions.

## Day 17

1. Udemy section 10 (339-365).
1. Finish udemy course.
1. Practice project AOP:
    1. Create `Pointcut` declarations.
    1. Combine `Pointcut` declarations.
    1. Make use of `JoinPoint` to read arguments and signature.
    1. Order advices.
    1. Use `@After`, `@AfterThrow`, `@Around` aspects.

## Day 18

1. Finish Practice project AOP:
    1. Create logging aspects for controller, service and dao centralized in an aspect.

## Day 19

1. Start project `diogenes` from scratch.
    1. Create a new project from [spring.io](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.1.2&packaging=jar&jvmVersion=17&groupId=dev.nichoko&artifactId=diogenes&name=diogenes&description=A%20home%20inventory%20app&packageName=dev.nichoko.diogenes&dependencies=devtools,data-jpa,postgresql,web,flyway) with JPA, flyway, postgres, web and dev tools.
    1. Setup database:
        1. Create a new database in docker with a specific user.
        1. Setup the initial database with two tables related one to one with `flyway`.
    1. Initialize spring properties to connect to the database and apply the migrations.

## Day 20

1. Project `diogenes`:
    1. Create entities of the database with `JPA`.
    1. Make use of `Spring data REST` to create CRUD endpoints.

## Day 21

1. Project `diogenes`:
    1. Discard `Spring data REST` because is to coupled with `HATEOS`.
    1. Continue the project with repository, service, controller architecture with a major refactoring.
    1. Remove `keycloak` to simplify project.

## Day 22

1. Project `diogenes`:
    1. Create `Category` entity, service, and controller.
    1. Create unit tests for `Category`.

## Day 23

1. Project `diogenes`:
    1. Update item to contain the `OneToOne` relation and update services and controller to require a valid category for an item.
    1. New bug: Unit tests are failing for getting and updating items.

## Day 24

1. Project `diogenes`:
    1. Allow cross origin requests to be used by angular frontend.

## Day 25

1. Project `diogenes`:
    1. Allow cross origin to all clients using the angular frontend.

## Day 26

1. Project `diogenes`:
    1. Extend items filter to allow filtering by the id of the join table of the model.
    1. Improve test coverage.

## Day 27

1. Learn how to set up redundant endpoints with different content types.
1. Project `diogenes`:
    1. Receive files and models together in a controller to receive images.

## Day 28

1. Project `diogenes`:
    1. Start storing files within the filesystem and make it configurable.
    1. Create an endpoint to retrieve images.
    1. Change service to alter the filenames stored in the database.

## Day 29

1. Project `diogenes`:
    1. Create an endpoint to delete and to update the images associated to an item.
    1. Make use of a file system repository to store the images.

## Day 30

1. Research JWT workflow in spring.

## Day 31

1. Project `diogenes`:
    1. First implementation of using JWT.

## Day 32

1. Project `diogenes`:
    1. Continue working on JWT. In memory authentication works but the roles are not working yet.

## Day 33

1. Project `diogenes`:
    1. Fix issue with authentication roles, getRoles builds over prefixing `ROLE_` in one authority.

## Day 34

1. Project `diogenes`:
    1. Recreate authentication using mostly spring methods to authenticate and authorize the user. Use custom JWT implementation.

## Day 35

1. Project `diogenes`:
    1. Update content types to return plain tokens.

## Day 36

1. Project `diogenes`:
    1. Create flyway scripts to set up default users and roles on the first initialization of the database.
