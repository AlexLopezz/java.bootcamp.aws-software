package excercise8;
import java.util.Scanner;

public class Demo {



    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        TheProgram programDemo = new TheProgram();
        System.out.println("Comprobamos que funciona ambos metodos: ");

        System.out.print("Ingrese un numero: ");
        programDemo.setNumber(read.nextInt());

        System.out.println("* ¿Este numero es consecutivo de alguna sumatoria? "+ programDemo.isConsecutiveAddition());
        System.out.println("\t¿De que lista de numeros es consecutivo? --> "+ programDemo.getConsecutiveNumbers());

        System.out.println("* Probando la performance de cada metodo(Recursivo e iterativo)");

        System.out.println("\t> Tiempo en el que termina de ejecutarse el metodo iterativo: " + programDemo.getPerformanceLoopMethod());
        System.out.println("\t> Tiempo en el que termina de ejecutarse el metodo recursivo: " + programDemo.getPerformanceRecursiveMethod());
    }
}
