# Spring Workshops plan
## Workshops 1 - 09.01.2022 - [Intro]  ✔
## Workshops 2 - 22.01.2022 - [Beginner]  ✔
## Workshops 3 - 23.01.2022 - [Advanced]  ✔
## Workshops 4 - 29.01.2022 - [Advanced]  ✔
## Workshops 5 - 05.02.2022 - [Advanced]  ✔
## Workshops 6 - 06.02.2022 - [Extra]  ✔

# Modules

* BASIC WEBAPP
* SPRING BOOT AOP
* SPRING BOOT BATCH
* SPRING BOOT CACHE
* SPRING BOOT THYMELEAF
* SPRING BOOT JDBC-TEMPLATE
* SPRING BOOT JMS
* SPRING BOOT JPA
* SPRING BOOT MONGODB
* SPRING BOOT R `EST
* SPRING BOOT SCHEDULER
* SPRING BOOT TRANSACTIONS
* SPRING BOOT VALIDATOR

# TO COVER:
* Spring basics
* Spring core
* Spring MVC (JSP/Thymeleaf)
* Spring Boot
* Spring Data
* Spring Security
* Webservices
* Angular/React integration [optional]

# Intro

## Let's start!
1. Generate Sample Spring Project ✔️
2. Import to IDE ✔️
3. Try to build & Try to run ✔️
4. Check exposed method via browser ✔️
5. Try to expose actuator ✔️
6. Validate healthcheck ❌
7. Add CommandLineRunner ✔️
8. Try to print all beans ✔️
9. Change log level for some packages  ✔
10. Define log level for our package  ✔
11. Write simple junit test  ✔
12. Expose Greeting controller method + write test, for example mockMvc  ✔
13. Define DAO layer with 2 database types (H2, HARDCODED) chosen via factory ❌
14. Pass usage of dedicated db via property file ✔
15. Add dependency like lombok + define loggers ✔
16. Add scheduler for simple logging ✔
17. Chuck Norris Jokes! Log them in scheduler from website ✔
18. Add serialization/deserialization ✔
19. Implement Mapstruct mapping between dao & dto ✔
20. Add proper layers implementation ✔
21. Change properties file to yml file ❌
22. Different ways of autowiring beans ✔
23. Sample DB usage (List of Jokes?) ✔
24. Service Layer (RestTemplate, maybe HttpClient)  ✔
25. Tests for service layer  ✔
26. Chuck Norris Jokes Collector controller implementation ✔
    1. Usage of: http://api.icndb.com API ✔
    2. REST GET ✔
    3. REST POST ✔
    4. REST PUT ❌
    5. REST DELETE ❌
27. Load json data from file and use in test to compare values ❌
28. Save data to file in service ❌
29. Hexagonal architecture proposal for application (separated module) ❌
30. Validation request (POST) ✔
31. Deployment to Cloud: ❌
    1. https://www.heroku.com/
32. Repository ✔
33. Profiles on repository (Mock DB + H2) ✔
    1. Define different configurations for repos ✔
34. Basic tests  ✔
35. H2 DB schema via sql file ✔
36. Connect with Service ✔
37. Connect withDedicatedController  ✔
38. Pass custom properties via @Value annotation  ✔
39. Mapstruct usage ✔
40. Manual mapper  ✔
41. Implement Scheduler ✔
    1. save random jokes to DB  ✔
42. Aspects  ✔
    2. LogExecutionTimeAspect  ✔
    3. LogBefore some method  ✔
    4. Our own annotation  ✔ 
43. Validation (@Valid)
44. ConstraintViolation
45. JMS Listener + Producer
46. Thymeleaf + Form 
47. Mapstruct
    1. Add to project - do mapper
48. Validation Request/Response 
49. H2 Added
50. NoSQL - presentation 

LAST CLASSES:
* Reminder what we did (CSV Printer)
* BindingResult support in forms
* Reflection
* SpringSecurity - how to turn on
* NoSQL - MongoDB Workshops
* Cache + Cacheable
* jdbcTemplate autowired + execute
** pure insert
** pure select
* Transactional
* Add WebJars
50. Add webjar bootstrap:
```
<!-- https://mvnrepository.com/artifact/org.webjars/bootstrap -->
<dependency>
    <groupId>org.webjars</groupId>
    <artifactId>bootstrap</artifactId>
    <version>5.1.3</version>
</dependency>
```
---------------------

## 3 layers app
# Sample controllers ✔
# Sample DB with repo for H2

## Generate sample Spring Boot App
## Chuck Norris Jokes collector
## Rest API for this
### @Cacheable
### @Async
### Validations
## 3 layers app
### Transactions
## Mapstruct to use mapping between DAO and DTO
## @Scheduler
## Save jokes on MongoDB App using MongoClient
### make json from object
## Turn On H2, use JDBC repository to save data to the sql DB
### using ActiveMQ
## tests, tests, tests!
### unit
### integration
### mockMvc
### cucumber *** -> extra
## @Aspect to calculate invocation time
## Write extra tools to export data to the PDF, CSV, EXCEL formats
## Use testcontainers to avoid SQL database *** -> extra

# Tasks

`Task 1 - REST-SERVICE`

Rest Controller with get method exposed on /greeting address + parameter support

deps:
* spring-boot-starter-web
* spring-boot-starter-test
* com.jayway.jsonpath

`Task 2 - SPRING BOOT`

Hello Controller + prompting in console all beans definition

deps:
* spring-boot-starter-web
* spring-boot-starter-actuator
* spring-boot-starter-test
* spring-test

`Task 3 - JDBC-TEMPLATE`

use JDBCTemplate to:
* drop table if exists
* create tables 
* use select
* batch insert sample
* map data between object and db

deps:
* spring-boot-starter-jdbc

`Task 4 - JPA`

Save entity via repository / spring data by manager in dao layer

deps:
* spring-boot-starter-data-jpa
* spring-data
* com.h2database

`Task 5 - SCHEDULER`

Scheduler + cron expressions

deps:
spring-context

`Task 6 - TRANSACTIONS`

Simple app + @Transactional usage

deps:
* com.h2database

`Task 7 - ASYNC`

Async methods + restTemplate usage

deps:
* spring-web

`Task 8 - BATCH`

Based on:
http://malsolo.com/blog4java/?p=260

we will write app which will import data from csv and save them in db using jobs

Usage:
* JdbcBatchItemWriter
* ItemProcessor
* FlatFileItemReader
* jdbcTemplate
* JobExecutionListenerSupport

deps:
* spring-boot-starter-batch

`Task 9 - CACHE`

Simple task to add @Cacheable mechanism

deps:
* spring-boot-starter-cache

`Task 10 - VALIDATOR`

Write simple validator extending class WebMvcConfigureAdapter + integration tests + annotations javax.validation.constraints

deps:
* spring-boot-starter-thymeleaf
* hibernate-validator 

`Task 11 - MongoDB`
Connector to MongoDB

`Task 12 - JMS`

Refactor architecture to use JMS

deps:
* spring-boot-starter-activemq
* activemq-broker
* jackson-databind

`Task 13 - FILE-UPLOADER`

File Uploader which will:
* download file chosen via form
* list downloaded files
* download file sent by user
* delete chosen files

deps:
* spring-boot-starter-thymeleaf


# Theory

## Why do we even need Spring -> https://www.youtube.com/watch?v=ySXlsZDJMgc
## Docs: https://docs.spring.io/spring-boot/docs/current/reference/html/index.html
## IoC
## Dependency Injections
## Annotations vs Xml
## Configuration
## ApplicationContext
## Beans
## Component etc.
## Autowired
## Polymorphism in Spring

# More Theory

## DDD
## TDD
## BDD
## Tests categories

# Implementation
## Generate sample Spring Boot App
## Chuck Norris Jokes collector
## Rest API for this
### @Cacheable
### @Async
### Validations
## 3 layers app
### Transactions
## Mapstruct to use mapping between DAO and DTO
## @Scheduler
## Save jokes on MongoDB App using MongoClient
### make json from object
## Turn On H2, use JDBC repository to save data to the sql DB
### using ActiveMQ
## tests, tests, tests!
### unit
### integration
### mockMvc
### cucumber *** -> extra
## @Aspect to calculate invocation time
## Write extra tools to export data to the PDF, CSV, EXCEL formats
## Use testcontainers to avoid SQL database *** -> extra
### DataFaker to generate many fake data for reports: https://jworks.io/datafaker-an-alternative-to-production-data/

# Architecture
## 3 layers
## hexagonal -> https://www.baeldung.com/hexagonal-architecture-ddd-spring
## how to test architecture -> https://www.archunit.org/
## Add JMS usage to architecture (Producer, Consumer)
## Different implementations (queue vs topic) and usage for consumed messages: save to DB, save to PDF, save to excel, send via mail.

# Alternatives:
## Picocontainer
## Micronaut
## Dagger2 

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Web Starter](https://docs.spring.io/spring-boot/docs/{bootVersion}/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

# Group work ideas:

## Spring Mail
### Jokes rank app. 
### Sending mails with jokes.
### Exporting data to dedicated format (PDF, EXCEL, CSV)
### Implementing frontend (thymeleaf can be used)