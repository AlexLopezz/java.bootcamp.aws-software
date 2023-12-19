# Welcome to my maven_JSP-CRUD

## Technologies used: 
 * Java OpenJdk-17
 * IntelliJ Community Edition 
 * Smart Tomcat (**Plugin IntelliJ**)
 * Maven 3.9.6
 * Tomcat 8.5
 * Servlet 3.1
 * JSTL 2.1

# How to run it?
## First step: 
* You must change the PATH where the "database" file is stored, to do this go to: BootcampAWSoftware/maven_jsp-CRUD/src/main/java/database/conf/Connection.java there you will have the following method:
```
private void initPath(){
        if (System.getProperty("os.name").equals("Linux")) {
            this.PATH = "/home/alexdev/Documents/BootcampAWSoftware/maven_jsp-CRUD/src/main/java/database/myDB.txt";
        } else {
            this.PATH = "C:\\Users\\Alex\\Documents\\BootcampAWSoftware\\maven_jsp-CRUD\\src\\main\\java\\database\\myDB.txt";
        }
    }
```
You must modify the following subdirectories: 
**/home/alexdev/Documents/** (linux) or **C:\UsersAlex/Documents/**(Windows) by the subdirectory where the cloned or downloaded project is located on your local computer. 
**If you do not change the path, the project will not be able to run because the directory cannot be obtained globally due to the use of the Smart Tomcat Plugin**

## So... how do I run the project now?
* Its more important that, you have Tomcat 8.5 and Smart Tomcat Plugin installed.
#### Check if Smart Tomcat was installed: 
![Screenshot from 2023-12-15 23-34-22](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/0d5676cd-e4cf-4c95-b25a-7bf5ad294a31)

#### At the top right, we will find an option like this: 
![Screenshot from 2023-12-15 23-34-41](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/1f8acfd7-911b-4738-b68e-84644f07cdde)

### *Follow these indications:
##### ![Screenshot from 2023-12-15 23-34-51](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/38fc7c63-01c4-4175-99a0-eb75a32e0ebd)
##### ![Screenshot from 2023-12-15 23-35-01](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/4897aa03-afdf-4986-81eb-368960550e45)

### *Here, you must select the Tomcat installed on your local computer: 
![Screenshot from 2023-12-18 23-17-19](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/77476c8e-4477-4a22-9376-14a216d8a619)

![Screenshot from 2023-12-18 23-17-31](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/6acb8c74-5517-4239-a19b-a7918448476b)

### *Must select the module you want to run with Smart Tomcat: 
![Screenshot from 2023-12-18 23-17-46](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/6cdde43a-fcdd-4d3f-8994-710701eecac1)

### *The context path should look like this:
![Screenshot from 2023-12-18 23-18-03](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/ad41ccb6-d65f-4859-8fde-afdac5327455)

*You only need to modify the options:*
* Tomcat server
* Use classpath of module:
* Context path

### Close the window by clicking on the OK button.
![Screenshot from 2023-12-18 23-18-19](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/1d05ba35-9dac-42c1-b04b-42b7c68494ca)

### We click on the run button: 
![Screenshot from 2023-12-18 23-18-39](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/cc11f5ac-c313-4e54-8136-6449c82a5938)

### It will open a console in IntelliJ *with red letters*, that at the end of everything gives us a LINK, we click and finally it should load our project.
##### ![Screenshot from 2023-12-18 23-19-39](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/590423be-2416-46a6-b685-e1dce3f6f6f3)
##### ![Screenshot from 2023-12-19 09-17-42](https://github.com/AlexLopezz/BootcampAWSoftware/assets/90531107/98bc4e28-c942-4f6f-a93a-f9f7d34d0c2a)

