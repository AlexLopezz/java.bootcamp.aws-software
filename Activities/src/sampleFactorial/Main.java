package sampleFactorial;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    // Calculamos el factorial de un numero mediante un numero de entrada:
    static int factorialNumber(int number){
        if(number < 0)
            throw new InputMismatchException("No existe el factorial de un numero negativo.");

        if(number == 0 || number == 1) {
            return 1;
        }

        return number * factorialNumber(number - 1);
    }
    // Calculamos el factorial de un numero mediante Generics:
    static <T extends Integer> int factorialNumberT(T t){
        return factorialNumber(t);
    }
    static <T> int factorialNumberT(T t){
        if(t instanceof Integer number)
            return factorialNumberT(number);

        throw new InputMismatchException("Debe ingresar un numero entero.");
    }

    /**
     *  Este metodo mostrara por consola el factorial de un numero.
     * @param numberForFactorial numero a calcular el factorial.
     * @param factorial resultado del factorial de ese numero.
     */
    static void showFactorial(int numberForFactorial, int factorial){
        System.out.printf("* %d! = %d\n", numberForFactorial , factorial);
    }


    public static void main(String[] args) {
        /* 2 - Factorial:
        Metodo que recibe un entero y devuelve el factorial del mismo.
        (¿lo podemos hacer también con tipos genéricos?) */

        var read = new Scanner(System.in);
        int numberForFactorial = 0;
        try {
            System.out.print("> Ingrese un numero: ");
            numberForFactorial = read.nextInt();
            showFactorial(numberForFactorial, factorialNumber(numberForFactorial));

            System.out.print("> Ingrese de nuevo un numero: ");
            numberForFactorial = read.nextInt();
            showFactorial(numberForFactorial, factorialNumberT(numberForFactorial));


            Double numberDoubleFactorial = (double) numberForFactorial;
            showFactorial(numberForFactorial, factorialNumberT(numberDoubleFactorial));

        }catch (NumberFormatException nfe) {
            System.out.println("Ocurrio un error: Debe ingresar un numero.");
        }catch (InputMismatchException ime){
            System.out.printf("Ocurrio un error: %s\n", ime.getMessage());
        }finally {
            System.out.println("--- Este programa finalizara ---");
        }


    }
}
