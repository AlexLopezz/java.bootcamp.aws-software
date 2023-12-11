package aditional_excercises.excercise1;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        /* Construir un Stream de numeros naturales que contenga todos los números pares mayores o iguales a 10 y menores o iguales a 20.
         Presentar en una lista de Integer en forma ordenada.
         Existen varias formas de realizar esto y me gustaría ver todas las opciones que se les ocurren. */

        //1era forma - Simple.
        Stream.of(10,12,14,16,18,20)
              .toList()
              .forEach(System.out::println);

        //2da forma - Simple, pero con elementos desordenados.
        Stream.of(14, 12, 10, 16,20, 18 )
              .sorted()
              .toList()
              .forEach(System.out::println);


        //3ra forma - Con iterate, un poco rebuscado el limit() pero funciona.
        System.out.println(Stream.iterate(10, n -> n + 2)
                                 .limit(6)
                                 .toList());

        //4ta forma - Aplicando filter. limit() + 1, no cuenta el 20.
        System.out.println(Stream.iterate(10, n -> n + 1)
                .limit(11)
                .filter(x -> x % 2 == 0)
                .toList());

        //5ta forma - Con enteros desordenados y fuera de los rangos. Aplicamos doble filter() y sorted()
        Stream.of(9,2,3,10,22,43,12,15,13,14,123,16,90,18,23,-1, -5, 20)
                .filter(v1 -> v1 >= 10 && v1 <= 20)
                .filter(v2 -> v2 % 2 == 0)
                .sorted()
                .toList()
                .forEach(System.out::println);


        //6ta forma - Con  un stream repleto de objetos diferentes, desordenados y repetidos.
        Stream.of("Hola","2",10,3.5,'c',22,43,12,12,15,13,14,14.2f,123,10,16,'9',0,18,23,16,-1.223, -5, 20)
                .filter(v -> v instanceof Integer && (Integer)v >= 10 && (Integer) v <= 20)
                .filter(v2 -> (Integer) v2 % 2 == 0)
                .sorted()
                .distinct()
                .toList()
                .forEach(System.out::println);

    }
}
