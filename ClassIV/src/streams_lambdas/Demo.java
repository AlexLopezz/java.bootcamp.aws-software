package streams_lambdas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {
    static List<Student> testStudents() {
        return List.of(
                new Student(1,"Alex", 6.66, 22),
                new Student(2,"Jorge", 7, 21),
                new Student(3,"Nahuel", 4.16, 20),
                new Student(4,"Aldana", 2.56, 24),
                new Student(5,"Samira", 3.23, 32),
                new Student(6,"Marina", 9.16, 54),
                new Student(7,"Alexis", 10, 31),
                new Student(8,"Florencia", 9, 30),
                new Student(9,"Maria", 7, 21),
                new Student(10,"Carla", 8, 29),
                new Student(11,"Jorge", 7.89, 27),
                new Student(12,"Hernan", 9.76, 18),
                new Student(13,"Armando", 1, 19),
                new Student(14,"Ezequiel", 7.56, 60),
                new Student(15,"Agustin", 9, 40)
        );
    }

    static void showAllStudents(){
        System.out.println("a. Muestre todos los alumnos de la lista: ");
        testStudents().forEach(System.out::println);
        System.out.println("----------------------------------");
    }

    static void showSortedStudentsWithQualif(){
        System.out.println("b. Muestre todos los alumnos ordenados de menor a mayor por edad: ");
        testStudents().stream()
                .sorted(Student::compareTo)
                .forEach(p -> System.out.println("Person= "+p.name+", age= "+p.age));
        System.out.println("----------------------------------");
    }

    static void showStudentsStartWith(char w){
        System.out.println("c. Muestre aquellos alumnos cuyo nombre empieza con un caracter dado\n"+
        "(elegir el caracter en base a la lista de nombre que se utilizo");

        System.out.println("\t* Caracter elegido --> "+ w);
        testStudents().stream()
                .filter(p -> p.name.startsWith(String.valueOf(w).toUpperCase()))
                .forEach(System.out::println);
        System.out.println("----------------------------------");
    }

    static void showSumAllAgeStudents(){
        System.out.println("d. Sume la edad de todos los alumnos");
        int sumAllAge=  testStudents().stream()
                .map(p -> p.age)
                .reduce(Integer::sum).orElseThrow(()-> new RuntimeException("Verifique si todas las edades, esteen presentes."));
        System.out.println("\t> La suma de todas las edades de las personas de la lista, es --> "+ sumAllAge);
        System.out.println("----------------------------------");
    }

    static void showGroupByQualif(){
        System.out.println("e. Obtenga un mapa donde la clave sea la nota y el valor sea una lista de alumnos que tienen esa nota: ");
        Map<Double, List<Student>> mapTest = testStudents().stream()
                .collect(Collectors.groupingBy(Student::getQualification));

        mapTest.forEach((k,v) -> {
            System.out.println("* key= " + k + " value: ");
            v.forEach(p -> System.out.println("\t> "+ p));
        });
        System.out.println("----------------------------------");
    }
    public static void main(String[] args) {
        //a. Muestre todos los alumnos de la lista
        showAllStudents();

        //b. Muestre todos los alumnos ordenados de menor a mayor por edad
        showSortedStudentsWithQualif();

        /*c. Muestre aquellos alumnos cuyo nombre empieza
        con un caracter dado (elegir el caracter en base a la lista de nombre que se utilizo) */
        showStudentsStartWith('a');

        //d. Sume la edad de todos los alumnos
        showSumAllAgeStudents();

        //e. Obtenga un mapa donde la clave sea la nota y el valor sea una lista de alumnos que tienen esa nota
        showGroupByQualif();
    }
}