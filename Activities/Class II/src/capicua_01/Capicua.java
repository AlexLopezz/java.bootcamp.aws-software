package capicua_01;

import utils.SOLUTION_MODE;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        executeProgram();
    }

    static void executeProgram(){
        boolean follow = true;

        while (follow){
            try {
                switch (decisionMenuUser()) {
                    case 1 -> verifyCapicua(getNumberUser(), SOLUTION_MODE.TRADICIONAL);
                    case 2 -> verifyCapicua(getNumberUser(), SOLUTION_MODE.RECURSIVO);
                    default -> System.out.println("X No ingreso ninguna opcion disponible.");
                }
            }catch (InputMismatchException ime){
                System.out.println("\t[X] Debe ingresar un numero, nada de letras ni simbolos especiales.");
            }

            follow = checkDecisionFollowUser();
        }
    }

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



    static int decisionMenuUser(){
        System.out.println("¡Bienvenido @user!");
        System.out.println("¿Que desea realizar?");
        System.out.println("1. Verificar numero si es capicua (Tradicional)");
        System.out.println("2.  Verificar numero si es capicua (Recursivo)");
        System.out.print("Respuesta: ");

        return Integer.parseInt(read.next());
    }
    static int getNumberUser(){
        System.out.print("> Ingrese un numero: ");
        return read.nextInt();
    }
    static boolean checkDecisionFollowUser(){
        System.out.println("\n*¿Desea volver a intentarlo?");
        System.out.println("\t*'SI' para seguir intentando.");
        System.out.println("\t*Cualquier tecla para finalizar el programa.");
        System.out.print("*Respuesta: ");

        return read.next().equalsIgnoreCase("si");
    }
}
