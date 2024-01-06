# Welcome to my SpringBoot MVC DB CRUD!
## Technologies used:
* Java openJdk-17
* IntelliJ CE
* Lombok 1.18.24
* Maven 3.9.6
* Spring Web 3.1.2
* Spring Data JPA 3.1.2
* Spring Validation 3.1.2
* Docker
  * mariadb:11.2


# How to run it? 
### Docker - mariadb
* Must create a new container from mariadb:11.2 w this command:
``` docker run -d -p 3306:3306 -e MYSQL_DATABASE=myDB -e MYSQL_ROOT_PASSWORD=root --rm --name mariadb mariadb:11.2 ```

### Run project on IntelliJ 
* Terminal:
  * Open a new terminal and exec this command: ``` mvn clean spring-boot:run ```

### Body for test
` {
"dni": "string of numbers",
"name": "your_name",
"lastName": "your_lastname",
"dateBirth": "yyyy-MM-dd",
"profession": "any existing profession"
} `
* In field *'profession'* you must put any of these values: ["Backend Developer", "Frontend Developer", "Fullstack Developer", "QA Developer""]


### Demo (Postman)


### via CURL
* [GET] ``` curl --location 'http://localhost:8080/user' ```
* [POST] ``` curl --location 'http://localhost:8080/user' \
  --header 'Content-Type: application/json' \
  --data '{
  "dni": "string of numbers",
  "name": "your_name",
  "lastName": "your_lastname",
  "dateBirth": "yyyy-MM-dd",
  "profession": "any existing profession"
  }'   ```

* [PUT] ``` curl --location --request PUT 'http://localhost:8080/user' \
  --header 'Content-Type: application/json' \
  --data '{
  "dni": "string of numbers",
  "name": "your_name",
  "lastName": "your_lastname",
  "dateBirth": "yyyy-MM-dd",
  "profession": "any existing profession"
  }' ```
* [GET] ```curl --location 'http://localhost:8080/user/{dni}' ```
* [DELETE] ``` curl --location --request DELETE 'http://localhost:8080/user/{dni}' ```