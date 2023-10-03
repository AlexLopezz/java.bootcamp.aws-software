package aditional_excercises.excercise2;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    static List<Integer> obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, Predicate<Integer> condicion){
        Optional<Predicate<Integer>> eval = Optional.ofNullable(condicion);
        Stream<Integer> streamAux = IntStream.range(desde, (hasta+1)).boxed();

        eval.ifPresent(streamAux::filter);

        return streamAux.toList();
    }

    public List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, List<Predicate<Integer>> condiciones){
        return IntStream.range(desde, (hasta+1))
                .boxed()
                .filter(n -> condiciones.stream()
                                        .allMatch(c -> c.test(n)))
                .toList();
    }
    @SafeVarargs
    public final List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer>... condicion){
        return obtenerListaSecuencialCondicionadaMultiple(desde, hasta, List.of(condicion));
    }

    public List<Integer> obtenerListaSecuencial(Integer desde, Integer hasta){
        return obtenerListaSecuencialCondicionada(desde, hasta, null);
    }
}
