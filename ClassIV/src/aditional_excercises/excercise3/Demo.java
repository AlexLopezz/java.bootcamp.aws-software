package aditional_excercises.excercise3;

public class Demo {
    public static void main(String[] args) {
        System.out.println("* Probando el metodo que pasa a String, reutilizando metodo de la clase anterior: ");
        System.out.println(Test.parserStrInRange(10,15));


        System.out.println("* Como haría para obtener un String concatenando n veces el número a concatenar?");
        String world = "Alex";
        int nTimes = 3;
        System.out.printf("/tLa palabra sera %s y se concatenara %d veces.\n", world, nTimes);
        System.out.println("* Resultado --> "+ Test.concating(world, nTimes));
    }
}
