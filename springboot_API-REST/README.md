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
