package multiplication_06;

import java.util.Scanner;

public class Main {
    //Metodo que calcula la multiplicacion de dos numeros, de manera recursiva.
    static int multiplication(int number, int number2){
        if(number2 < 0) {
            number *= -1;
            number2 = Math.abs(number2);
        }

        //Condicion de corte
        if(number2 != 0){
            return number + multiplication(number, (number2-1));
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int number, number2;
        try {
            System.out.print("> El numero: ");
            number = Integer.parseInt(read.next());
            System.out.print("> Se multiplica con: ");
            number2 = Integer.parseInt(read.next());

            System.out.println("\t* El resultado es: "+ multiplication(number, number2));
        }catch (RuntimeException re){
            System.out.println("Debe ingresar solamente numeros enteros decimales...");
        }
    }
}
