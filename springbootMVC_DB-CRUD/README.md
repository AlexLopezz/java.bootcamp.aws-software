# Welcome to my SpringBoot MVC DB CRUD!
## Technologies used:
* Java openJdk-17
* IntelliJ CE
* Dbeaver CE
* Maven 3.9.6
* Spring Boot 3.1.5
* Spring Boot Data JPA
* Spring Boot Validation 3.1.5
* Docker
  * mariadb:11.2
* Lombok

# How to run it? 
### Docker - mariadb
* Must create a new container from mariadb:11.2 w this command:
``` docker run -d -p 3306:3306 --rm --name mariadb mariadb:11.2 ```

### Dbeaver CE 
* Follow these steps in the dbeaver app: 

 [Connect mariadb - dbeaverCE.webm](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/b5856fcb-4337-47c3-897e-10f65cda9a31)

 [Create a new database mariadb - dbeaver.webm](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/b974b4ff-bfca-46e6-b610-5a46cea91e6e)

### Run project on IntelliJ 
* Terminal:
  * Open a new terminal and exec this command: ``` mvn clean spring-boot:run ```
* IntelliJ Graphical Option:

[Run SpringBoot project.webm](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/8214495f-2dd1-48d0-bad9-4b97020714e9)

### After running the project, you must go to the browser and type the following link: [http://localhost:8080](http://localhost:8080/)

###### Done!
![image](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/8836ab56-50c1-46b7-af12-7238afb9d7bd)
