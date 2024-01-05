# Welcome to my SpringBoot CXF RS-CRUD!
## Technologies used:
* Java openJdk-17
* IntelliJ CE
* Postman
* Maven 3.9.6
* Spring Web 3.1.5
* Spring Data JPA 3.1.5
* CXF JAX-RS 4.0.3
* Jakarta 3.1.0
* Jackson Jakarta 2.15.3
* Lombok 1.18.24
* H2-Database 2.2.220

##### [IMPORTANT] For testing, it is necessary to have Postman or any testing program installed, which supports JSON request and response.


| ENDPOINT           | METHOD       | DESCRIPTION                      |
|--------------------|--------------|----------------------------------|
| ../api/user        | GET          | Get all database users           |
| ../api/user        | POST         | Save user into database          |
| ../api/user        | PUT          | Modify existing user in database | 
| ../api/user/{dni}  | GET          | Get user by DNI                  |
| ../api/user/{dni}  | DELETE       | Delete user by DNI               |


# How to run it?
`mvn clean spring-boot:run`

### Body for test POST or PUT:
` {
"dni": "string of numbers",
"name": "your_name",
"lastName": "your_lastname",
"dateBirth": "yyyy-MM-dd",
"profession": "any existing profession"
} `
* In field *'profession'* you must put any of these values: ["Backend Developer", "Frontend Developer", "Fullstack Developer"]

### Demo (Postman) 
[2024-01-04 20-56-12.webm](https://github.com/AlexLopezz/java.bootcamp.aws-software/assets/90531107/e7a7db3f-0f6b-4e68-b629-eb501228b7b9)


### It is also possible to make queries via **CURL**
  * [GET] ``` curl --location 'http://localhost:8080/api/user' ```
  * [POST] ``` curl --location 'http://localhost:8080/api/user' \
    --header 'Content-Type: application/json' \
    --data '{
    "dni": "string of numbers",
    "name": "your_name",
    "lastName": "your_lastname",
    "dateBirth": "yyyy-MM-dd",
    "profession": "any existing profession"
    }'   ```
    
  * [PUT] ``` curl --location --request PUT 'http://localhost:8080/api/user' \
    --header 'Content-Type: application/json' \
    --data '{
    "dni": "string of numbers",
    "name": "your_name",
    "lastName": "your_lastname",
    "dateBirth": "yyyy-MM-dd",
    "profession": "any existing profession"
    }' ```
  * [GET] ```curl --location 'http://localhost:8080/api/user/{dni}' ```
  * [DELETE] ``` curl --location --request DELETE 'http://localhost:8080/api/user/{dni}' ```
