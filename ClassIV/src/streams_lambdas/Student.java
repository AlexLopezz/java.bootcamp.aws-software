package streams_lambdas;

public class Student implements Comparable{
    public int id;
    public String dni;
    public String name;
    public String lastName;
    public String course;
    public double qualification;
    public int age;


    public Student() {
    }

    public Student(int id, String name, double qualification, int age) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.age = age;
    }

    public Student(int id, String dni, String name, String lastName, String course, double qualification, int age) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.course = course;
        this.qualification = qualification;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public double getQualification() {
        return qualification;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id= "+ id+", "+
                "name=" + name + ", "+
                "qualification=" + qualification + ", "+
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student p)
            return Integer.compare(this.age, p.age);

        return -1;
    }
}
