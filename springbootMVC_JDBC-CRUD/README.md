# Welcome to my Spring Boot MVC JDBC CRUD!
### Technologies used: 
* Java OpenJDK-17
* IntelliJ CE
* Dbeaver CE
* Lombok 1.18.24
* Spring Boot 3.1.5
* Spring Validation 3.1.2
* Spring Boot Data JPA
* Thymeleaf 3.1.5
* Docker
  * mariadb:11.2
 
### How to run it?
## Docker
  * Open a new terminal and exec this command: ``` docker run -d -p 3306:3306 -e MYSQL_DATABASE=jdbc -e MYSQL_ROOT_PASSWORD=root --rm --name mariadb mariadb:11.2 ```

## IntteliJ
 ### Terminal:
   ``` mvn clean spring-boot:run ```

 ### IntelliJ Graphical Option:

[Screencast from 21-12-23 08:58:08.webm](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/11e77a8c-9f09-4bfb-a513-87a012050751)

#### After running the project, you must go to the browser and type the following link: http://localhost:8080
## Done!!! 
![image](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/a5075669-341d-42a0-bd48-56ff7bc76337)

