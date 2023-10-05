package aditional_excercises.excercise3;
import java.util.Collections;
import java.util.Objects;
import java.util.stream.Collectors;

import static aditional_excercises.excercise2.Test.obtenerListaSecuencial;

public class Test {
    public static String parserStrInRange(Integer d, Integer h){
        return obtenerListaSecuencial(d,h).stream()
                .map(Objects::toString)
                .collect(Collectors.joining("-> "));
    }

    public static String concating(String world, Integer nTimes){
        return String.join("", Collections.nCopies(nTimes, world));
    }
}
