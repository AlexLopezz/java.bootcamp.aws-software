package excercise2;

import utils.Main;

import java.util.InputMismatchException;

public class TheProgram extends Main {
    public TheProgram() {
        super();
    }

    @Override
    public void run() {
        while (follow){
            try{
                int numberFactorial;
                switch (decisionMenuUser()){
                    case 1 -> {
                        numberFactorial = getNumberUser();
                        showFactorial(numberFactorial, factorialNumber(numberFactorial));
                    }
                    case 2 -> {
                        numberFactorial = getNumberUser();
                        showFactorial(numberFactorial, factorialNumberT(numberFactorial));
                    }
                }

            }catch (NumberFormatException nfe){
                System.out.println("\t[X] Debe ingresar un numero, nada de letras ni simbolos especiales.");
            }

            follow = checkDecisionFollowUser();
        }
    }

    @Override
    public int decisionMenuUser() {
        System.out.println(welcomeToUser);
        System.out.println("¿Que desea realizar?");
        System.out.println("1. Factorial de un numero. (Modo tradicional)");
        System.out.println("2. Factorial de un numero. (Generics)");

        return Integer.parseInt(read.next());
    }

    // Calculamos el factorial de un numero mediante un numero de entrada:
    public int factorialNumber(int number){
        if(number < 0)
            throw new InputMismatchException("No existe el factorial de un numero negativo.");

        if(number == 0 || number == 1) {
            return 1;
        }

        return number * factorialNumber(number - 1);
    }
    // Calculamos el factorial de un numero mediante Generics:
    public <T extends Integer> int factorialNumberT(T t){
        return factorialNumber(t);
    }

    public <T> int factorialNumberT(T t){
        if(t instanceof Integer number)
            return factorialNumberT(number);

        throw new InputMismatchException("Debe ingresar un numero entero.");
    }

    /**
     *  Este metodo mostrara por consola el factorial de un numero.
     * @param numberForFactorial numero a calcular el factorial.
     * @param factorial resultado del factorial de ese numero.
     */
    private void showFactorial(int numberForFactorial, int factorial){
        System.out.printf("* %d! = %d\n", numberForFactorial , factorial);
    }

}
