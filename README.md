# HRtab
How to start:
clone project=> 
mvn clean install=>
start application
data.sql contains few employees
or you can use postman to test some other endpoints.

RESTful web service
The web application must be implemented using following technology stack:
1. Java 7 or 8
2. Spring Framework - https://spring.io
3. Hibernate ORM 5 - http://hibernate.org
4. JavaScript SPA - AngularJS
5. DBMS - HSQLDB or similar
Web service interface
The web service provides access to the employees database and expose following REST
interface:
1. GET
a. /employee/{id} - returns details of employee by given ID
b. /employees - returns list of all employees
c. /department/{id} - returns details of department by given ID
d. /departments - return list of all departments
e. /department/{id}/employees - returns all employees associated with given
department
2. POST
a. /employee - creates new employee from JSON string and returns her ID
b. /department - creates new department from JSON string and returns its ID
3. PUT
a. /employee/{id} - update information about employee with given ID
b. /department/{id} - updated information about department with given ID
c. /employee/{e_id}/department/{d_id} - assign given employee to the given
department
4. DELETE
a. /employees/{id} - deletes employee with given ID
b. /departments/{id} - deletes department with given ID
The database schema
The database will have two tables with many-to-many relationship:
1. EMPLOYEE​- holds information about users
a. id
b. first_name
c. last_name
d. birthdate
e. gender
f. tax_number
2. DEPARTMENT​- holds information about organisation department
a. id
b. name
The JavaScript SPA
The frontend single page application (SPA) should be implemented using AngularJS and
provide following functionality:
1. Allows to create employee
2. Allows to create department
3. Allows to show employee details
4. Allows to show department details
5. Allows to update employee details
6. Allows to update department details
7. Allows to delete particular employee
8. Allows to delete particular department
9. Allows to list all employees
10. Allows to list all departments
11. Allows to assign given employee to specific department
