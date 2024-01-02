# Welcome to my Spring Boot MongoDB CRUD!
### Technologies used: 
* Java OpenJDK-17
* InteliiJ CE
* NoSQLBooster
* Spring Boot 3.1.5
* Lombok 1.18.24
* Thymeleaf 3.1.5
* Spring Validation 3.1.2
* Docker
  * mongodb:4.2 

# How to run it?
### Docker - MongoDB
* ``` docker run -d -e MONGO_INITDB_DATABASE=mongoCRUD -p 27017:27017 --name mongoDB mongo:4.2 ```

### InteliiJ - Run project
###### Terminal 
``` mvn clean spring-boot:run ```
###### IntelliJ Graphical Option
[RunProject.webm](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/06de6184-b062-4e79-944b-04048152526c)

#### After running the project, you must go to the browser and type the following link: http://localhost:8080
###### Done!!!
![image](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/f204d837-4e7e-4359-9b49-cea5201ab29f)
