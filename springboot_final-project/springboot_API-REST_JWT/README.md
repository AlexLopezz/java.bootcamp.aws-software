# Welcome to my SpringBoot API-REST W/ JWT!
## Technologies used:
* Java openJdk-17
* IntelliJ CE
* H2-Database
* Lombok 1.18.24
* Maven 3.9.6
* Spring Web 3.1.2
* Spring Data JPA 3.0.7
* Spring Validation 3.0.7
* Spring Security 3.0.7

# How to run it? 
### Run project on IntelliJ 
* Terminal:
  * Open a new terminal and exec this command: ``` mvn clean spring-boot:run ```

### Login credentials: 
`{
    "username" : "admin",
    "password" : "admin"
}`

### Body for test
` {
  "username": "your_name",
  "password": "your_passwd",
  "role": "Administrator",
  "profession": "Backend Developer"
} `
* In field *'profession'* you must put any of these values: ["Backend Developer", "Frontend Developer", "Fullstack Developer", "QA Developer""]
* In field *'role'* you must put any of these values: ["Administrator", "Employee"]

# Demo (Postman)
[Demo postman.webm](https://github.com/AlexLopezz/java.bootcamp.aws-software/assets/90531107/0ddbc7cf-20db-45cf-92a2-43eaaf23ed21)

# via Swagger: http://localhost:8080/swagger
[Demo swagger.webm](https://github.com/AlexLopezz/java.bootcamp.aws-software/assets/90531107/c8f629e3-d5ba-4b35-b432-f2d0b5a30aea)

# via CURL
#### First, log in: 
   * [POST] ` curl --location 'http://localhost:8080/auth/login' \
--header 'Content-Type: application/json' \
--data '{
    "username" : "admin",
    "password" : "admin"
}' `

#### Now you can test smoothly: 
* [GET] ``` curl --location 'http://localhost:8080/users' \
--header 'Authorization: Bearer *your_token_here*' ```
* [POST] ``` curl --location 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer *your_token_here*' \
--data '{
  "username": "your_name",
  "password": "your_passwd",
  "role": "Administrator",
  "profession": "Backend Developer"
} ' ```

* [PUT] ``` curl --location --request PUT 'http://localhost:8080/users' \
--header 'Content-Type: application/json' \
--header 'Authorization: Bearer *your_token_here*' \
--data '{
    "id" : [0-999],
    "username": "your_name",
    "password": "your_passwd",
    "role": "Administrator",
    "profession": "Backend Developer"
}' ```
* [GET] ```curl --location --globoff 'http://localhost:8080/users/{dni}' \
--header 'Authorization: Bearer *your_token_here*' ```
* [DELETE] ``` curl --location --request DELETE 'http://localhost:8080/users/{dni}' \
--header 'Authorization: Bearer *your_token_here*' ```
