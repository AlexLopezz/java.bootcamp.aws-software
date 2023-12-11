package aditional_excercises.excercise2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    /* Si pudieron realizar correctamente el anterior, ahora creemos un método como el siguiente:
                List obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, Predicate condicion)

       * Como establecerían la posibilidad de recibir múltiples predicados condicionales?
        List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, List<Predicate<Integer>> condiciones)
        List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer>[] condiciones)
        List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer> ... condicion)
     */

    public static void main(String[] args) {
        Test t = new Test();

        /*
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        Predicate<Integer> oddPredicate = n -> n % 2 != 0;
        Predicate<Integer> biggerThanPredicate = n -> n > 80;

        List<Predicate<Integer>> predicateList = new LinkedList<>(){};
        predicateList.add(evenPredicate); //Predicate para numeros pares...

        Integer desde = 50,
            hasta = 100;

        t.obtenerListaSecuencialCondicionadaMultiple(desde, hasta, predicateList).forEach(System.out::println); //Probamos el primer metodo
        t.obtenerListaSecuencialCondicionadaMultiple(desde, hasta, biggerThanPredicate, oddPredicate).forEach(System.out::println); //Probamos el segundo metodo
        */




    }
}
