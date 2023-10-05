package aditional_excercises.excercise2;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Test {

    public static List<Integer> obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, Predicate<Integer> condicion){
        Predicate<Integer> condition = Optional
                .ofNullable(condicion).orElse(p ->  true);


        return IntStream.range(desde, hasta+1)
                .boxed()
                .filter(condition)
                .toList();
    }

    public static List<Integer> obtenerListaSecuencial(Integer desde, Integer hasta){
        return obtenerListaSecuencialCondicionada(desde, hasta, p -> true);
    }

    public static List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, List<Predicate<Integer>> condiciones){
        List<Integer> numbers = obtenerListaSecuencial(desde, hasta);

        return numbers.stream()
                .filter(n -> condiciones.stream()
                                        .allMatch(c -> c.test(n)))
                .toList();
    }

    public static List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer>... condicion){
        List<Predicate<Integer>> conditions = List.of(condicion);
        return obtenerListaSecuencialCondicionadaMultiple(desde, hasta, conditions);
    }

    /*
    Este metodo no me deja desarrollarlo, no entiendo muy bien el por que, pero lo que interpreto es que... Java entiende que esta firma
    de metodo ya existe y lo asimila con el metodo que se encuentra en la linea 14, sin importar que se trate de un arreglo...

    public List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer>[] condiciones){
        List<Predicate<Integer>> conditions = Arrays.asList(condiciones);

        return obtenerListaSecuencialCondicionadaMultiple(desde, hasta, conditions);
    }*/


}
