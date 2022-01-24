# About
A simple app that allows you to perform basic CRUD operations on clients, stored in your DB
# Technologies used
- Java 8
- Java EE
- JAX-RS
- CDI
- PostgreSQL
- JDBC
- Apache TomEE
# How to run the app
1. Clone the project to your IDE
2. Initialize database using src/main/resources/init_db.sql
3. Change config properties to the ones that fit your DB in the src/main/java/application/util/ConnectionUtil.java file
4. Add your favorite webserver to run/debug configuration
5. Run the app. To manage DB you can use the endpoints listed below
# Available endpoints
### (assuming you're running the project on your local web server)
- localhost:8080/client-service-1/clients/ - POST method, requires JSON with following parameters: {"fullName":"YOURFULLNAME", "mainPhoneNumber":"YOURMAINPHONENUMBER"}
- localhost:8080/client-service-1/clients/ - PATCH method, requires JSON with following parameters: {"clientId":"YOURID", "fullName":"YOURFULLNAME", "passport":"YOURPASSPORTID", "dateOfBirth":"YOURDATEOFBIRTH", "additionalPhoneNumber":"YOURADDITIONALPHONENUMBER"}
- localhost:8080/client-service-1/clients/{ID} - GET method, requires you to pass an id as a path variable
- localhost:8080/client-service-1/clients/{ID} - DELETE method, requires you to pass an id as a path variable

### P. S.
For logger to write logs into a file, your web server needs to have write access to the project's directory