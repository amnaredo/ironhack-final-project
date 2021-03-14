# Full Stack Web Application with Microservices
### Cryptocurrency Portfolio Manager

### Backend Setup

1. Create all required databases with their respective names (see [databases.sql](databases.sql)).

2. Run each of the services as a regular Maven Spring Boot project: `mvn spring-boot:run`. The eureka server and the configuration server must be started before the other services.

3. Configuration of these services is outsourced in another repository, so there's no need to do manual configuration. (see [https://github.com/amnaredo/ironhack-final-project-config](https://github.com/amnaredo/ironhack-final-project-config)).

4. A collection of Postman requests is available to check the details for the REST API (see [coindex.postman_collection.json](coindex.postman_collection.json)).
**Make sure to use these requests to add a new user profile to the system before running the frontend! (You can add it manually too directly to the database table).**

