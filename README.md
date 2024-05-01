# INTELYGENZ TECHNICAL TEST

## Statement

Implement a REST endpoint that fetches a list of integers saved in DB. You can find the data loaded into memory in the data.sql file. After that, process that list of integers with a service that should return a sorted list of integers based on the following criteria:
The higher number of ones in the binary representation of the integer, the closer to index 0 the element is. In case two or more numbers have the same number of ones in their binary representation, the smaller decimal number comes first in the sorted list.
Example:

For the input: [1, 15, 5, 7, 3] the output should be: [15, 7, 3, 5, 1]

Explanation:

Decimal	binary

1	1

15	1111

5	101

7	111

3	11

The decimal number whose binary representation contains the most ones is 15 (1111 in binary), so it goes first (index = 0). Next is 7, with three ones in its binary representation. Then there are 2 numbers whose binary representation contains the same number of ones, these decimals are 5 and 3, both with 2 ones. In this case, the number 3 goes first (closer to index = 0) because its decimal representation is smaller (3 < 5).

The final REST endpoint should return the result of the processed list of integers.
Choose your build tool

For building the application you can choose whichever tool you are most comfortable with between Maven and Gradle. You will find build scripts for both inside the project.

As for the Java version you can use the one that is already set for the project or upgrade to a more recent one if you miss some feature you would like to use. Bear in mind that the Java version that we set for this project, rather than a restriction itself, aims to replicate the version that

## Architecture
To propose the structure to follow in this service, the concept of hexagonal architecture and DDD is taken into account to guarantee scalability:
- **Domain:** This layer contains the domain entities, which represent the key business concepts and their relationships, as well as the associated business logic. These entities are infrastructure and implementation agnostic, allowing you to focus on business rules and constraints.
- **Application:** This layer contains the use cases, which represent the actions or functionalities that the application can perform. Use cases coordinate communication between input ports (interfaces that represent actions that can be performed from the outside) and output ports (interfaces that represent actions that the application can perform to the outside, such as interacting with databases). of data or external services).
- **Infrastructure:** This layer contains the adapters and the implementation of the output ports, as well as the configuration and interaction with external services. Adapters are responsible for converting external requests into calls to use cases and for converting use case responses into responses understandable by external systems.

## Technologies
I have used Spring Boot since there is no clear requirement, it is the framework with which I have worked the most:

- Spring Boot is used as the core framework to create the application.
- H2 is used as an in-memory database.

## Design
Several design decisions have been made to keep the application simple and scalable:

- **Application:** The application layer defines the input and output ports, handling the main use case.
- **Domain:** The domain layer represents the data that is stored and loaded. The model consists of Java records for immutability.
- **Infrastructure:** This layer contains Spring Bean definitions for dependency injection. Also, infrastructure includes:
  - The REST controller that handles incoming requests. Within this REST section, we also find the mapper to map between the domain model and the endpoint output model. MapStruct is used for mapping.
  - The JPA adapter that uses DTO to map between the domain model and the H2 database. MapStruct is used for mapping.
- **Database:** The database model is designed for the requirements of the task, but additional optimizations could be made to achieve not using an in-memory database.

## How to test the service

To do this, you must execute the following commands:
```console
mvn clean package
docker build -t intelygenz-test .
docker run -p 8080:8080 intelygenz-test
```
It can also be tested by importing the project into your favorite IDE and running IntelygenzTestApplication.java.

Once it is running, the requests can be executed. An example of a request could be:
```console
curl --location --request GET 'http://localhost:8080/v1/orderedIntegersByBinaryValue'
```