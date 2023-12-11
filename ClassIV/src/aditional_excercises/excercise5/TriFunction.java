package aditional_excercises.excercise5;

import java.util.function.Function;

@FunctionalInterface
public interface TriFunction <T extends Long> {
    Function<Long, Function<Long, Function<Long, Long>>> eval();

}
