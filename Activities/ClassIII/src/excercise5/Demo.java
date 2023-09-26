package excercise5;

import java.util.Scanner;

public class Demo {
    // Calculamos el factorial de un numero mediante Generics:
    static <I extends Integer> long factorialNumberT(I i){
        int number = i.intValue();
        if(number < 0){
            throw new RuntimeException("No se puede calcular el factorial de un numero negativo.");
        }

        if(number == 0 || number == 1)
            return 1;

        return number * factorialNumberT(number - 1);
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("> Ingrese un numero: ");
        Integer i = Integer.parseInt(read.next());

        System.out.printf("\t--> El factorial del numero %d es: %d\n", i, factorialNumberT(i));
    }
}
