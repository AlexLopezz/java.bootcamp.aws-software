package excercise1;

import utils.Main;
import utils.SOLUTION_MODE;


public class TheProgram extends Main {
    public TheProgram() {
        super();
    }

    @Override
    public int decisionMenuUser() {
        System.out.println(welcomeToUser);
        System.out.println("¿Que desea realizar?");
        System.out.println("1. Verificar numero si es capicua (Tradicional)");
        System.out.println("2. Verificar numero si es capicua (Recursivo)");
        System.out.print("Respuesta: ");

        return Integer.parseInt(read.next());
    }

    @Override
    public void run(){
        while (follow){
            try {
                switch (decisionMenuUser()) {
                    case 1 -> verifyCapicua(getNumberUser(), SOLUTION_MODE.TRADICIONAL);
                    case 2 -> verifyCapicua(getNumberUser(), SOLUTION_MODE.RECURSIVO);
                    default -> System.out.println("X No ingreso ninguna opcion disponible.");
                }
            }catch (RuntimeException re){
                System.out.println("\t[X] Debe ingresar un numero, nada de letras ni simbolos especiales.");
            }

            follow = checkDecisionFollowUser();
        }
    }

    public int reverse(int number){
        int resto = 0, invertido = 0;
        while( number > 0 ) {
            resto = number % 10;
            invertido = invertido * 10 + resto;
            number /= 10;
        }

        return invertido;
    }
    public int reverseRecursive(int number, int reverse){
        if(number == 0)
            return reverse;

        int resto = number % 10;
        reverse = reverse * 10 + resto;
        return reverseRecursive((number / 10), reverse);
    }
    public boolean isCapicua(int number) { return number == reverse(number); }
    public boolean isCapicuaRecursive(int number) { return number == reverseRecursive(number,0); }

    private void showConsoleIsCapicua(int number, boolean isCapicua, int reverse){
        String symbol = isCapicua? "==" : "!=";
        System.out.printf("\t* El numero %d. ¿Es capicua? %s", number, isCapicua? "SI." : "NO.");
        System.out.printf("--> %d %s %d\n", number, symbol , reverse);
    }
    private void verifyCapicua(int number, SOLUTION_MODE solutionMode){
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
}