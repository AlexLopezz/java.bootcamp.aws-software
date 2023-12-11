package utils;

import java.util.Scanner;

public abstract class Main implements IProgramable {
    protected Scanner read;
    protected boolean follow;
    protected String welcomeToUser = "¡Bienvenido @user!";

    public Main() {
        read = new Scanner(System.in);
        follow = true;
    }

    public int getNumberUser() {
        System.out.print("> Ingrese un numero: ");
        return Integer.parseInt(read.next());
    }

    public boolean checkDecisionFollowUser() {
        System.out.println("\n*¿Desea volver a intentarlo?");
        System.out.println("\t*'SI' para seguir intentando.");
        System.out.println("\t*Cualquier tecla para finalizar el programa.");
        System.out.print("*Respuesta: ");

        return read.next().equalsIgnoreCase("si");
    }
}
