package conversor_03;

import java.util.Arrays;
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
                    case 1 -> convertNumberToBinary();
                    case 2 -> convertBinaryToNumber();
                    default -> System.out.println("X No elegio ninguna opcion disponible.");
                }
            }catch (NumberFormatException n){
                System.out.println("X Debe elegir las opciones a traves de los numeros del menu.(1 o 2 en este caso.)");
            }

           follow = checkDecisionFollowUser();
        }

    }

    static int decisionMenuUser(){
        System.out.println("¡Bienvenido @user!");
        System.out.println("¿Que desea realizar?");
        System.out.println("1. Convertir numero decimal a binario");
        System.out.println("2. Convertir binario a numero decimal");
        System.out.print("Respuesta: ");

        return Integer.parseInt(read.next());
    }
    static void convertBinaryToNumber() {
        System.out.print("> Ingrese un numero binario(Solo 0 y 1): ");
        double number = read.nextDouble();

        if(verifyBinaryNumber(number)) {

            System.out.printf("\tEl numero %d en decimal es: %d\n", (int) number, Conversor.toDecimal(number));
        }else {
            System.out.println("X Debe ingresar un numero binario.");
        }
    }
    static void convertNumberToBinary(){
        System.out.print("> Ingrese un numero entero decimal: ");
        int number = read.nextInt();

        System.out.printf("\tEl numero %d en binario es: %d\n", number, (int) Conversor.toBinary(number));
    }
    static boolean checkDecisionFollowUser(){
        System.out.println("\n*¿Desea volver a intentarlo?");
        System.out.println("\t*'SI' para seguir intentando.");
        System.out.println("\t*Cualquier tecla para finalizar el programa.");
        System.out.print("*Respuesta: ");

        return read.next().equalsIgnoreCase("si");
    }


    static boolean verifyBinaryNumber(double binaryNumber){
        String binaryNumberStr = String.valueOf((int)binaryNumber);

        for(int i= 0; i < binaryNumberStr.length(); i++){
            if(binaryNumberStr.charAt(i) != '1' && binaryNumberStr.charAt(i) != '0'){
                return false;
            }
        }

        return true;
    }
}
