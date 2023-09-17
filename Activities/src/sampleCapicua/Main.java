package sampleCapicua;

import utils.SOLUTION_MODE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int reverseRecursive(int number, int reverse){
        if(number == 0)
            return reverse;

        int resto = number % 10;
        reverse = reverse * 10 + resto;
        return reverseRecursive((number / 10), reverse);
    }

    static int reverse(int number){
        int resto = 0, invertido = 0;
        while( number > 0 ) {
            resto = number % 10;
            invertido = invertido * 10 + resto;
            number /= 10;
        }

        return invertido;
    }
    static boolean isCapicua(int number) { return number == reverse(number); }
    static boolean isCapicuaRecursive(int number) { return number == reverseRecursive(number,0); }

    static void showConsoleIsCapicua(int number, boolean isCapicua, int reverse){
        String symbol = isCapicua? "==" : "!=";
        System.out.printf("\t* El numero %d. ¿Es capicua? %s", number, isCapicua? "SI." : "NO.");
        System.out.printf("--> %d %s %d\n", number, symbol , reverse);
    }
    static void verifyCapicua(int number, SOLUTION_MODE solutionMode){
        boolean capicua;

        switch (solutionMode){
            case TRADICIONAL -> {
                capicua = isCapicua(number);
                showConsoleIsCapicua(number, capicua, reverse(number));
            }
            case RECURSIVO -> {
                capicua = isCapicuaRecursive(number);
                showConsoleIsCapicua(number, capicua, reverseRecursive(number, 0));
            }
        }
    }


    public static void main(String[] args) {
        /* 1 - Número entero capicua.
            Construir un metodo que reciba un entero como parámetro y devuelva boolean indicando
            si es capicúa o no dicho número. (Version No Recursiva y Recursiva)
         */
        int number = 0;
        var read = new Scanner(System.in);

        try {
            System.out.print("> Ingrese un numero: ");
            number = read.nextInt();
            System.out.println("TRADICIONAL: ");
            verifyCapicua(number, SOLUTION_MODE.TRADICIONAL);
            System.out.println("RECURSIVO: ");
            verifyCapicua(number, SOLUTION_MODE.RECURSIVO);

        }catch (InputMismatchException ime){
            System.out.println("\t[X] Debe ingresar un numero, nada de letras ni simbolos especiales.");
        }
    }
}
