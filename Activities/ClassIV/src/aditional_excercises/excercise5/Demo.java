package aditional_excercises.excercise5;

import java.security.cert.TrustAnchor;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo {

    public static void main(String[] args) {
        int testX = 5, testY = 5, testZ = 2;
        BiFunction<Integer, Integer, Integer> testBiFunction = (x,y) -> (2*x + 2*y);

        ICustomFunctionable<Integer> myCustomFunction = (x,y) -> (2*x + 2*y);

        System.out.println("Resultado BiFunction: "+ testBiFunction.apply(testX, testY));
        System.out.println("Resultado MyCustomFunction: "+ myCustomFunction.apply(testX, testY));

        //Intentando aplicar Currying, forma corta con expresiones lambda:
        Function<Integer, Function<Integer, Integer>> tryCurrying = a -> b -> (2*a) + (2*b);

        //Intendando apilcar Currying2, forma extendida:
        Function<Integer, Function<Integer, Integer>> tryCurrying2 = new Function<Integer, Function<Integer, Integer>>() {
            @Override
            public Function<Integer, Integer> apply(Integer x) {
                return new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer y) {
                        return (2*x) + (2*y);
                    }
                };
            }
        };


        System.out.println("Probando con Curry: --> " + tryCurrying.apply(testX).apply(testY));
        System.out.println("Probando con Curry2: --> " + tryCurrying2.apply(testX).apply(testY));



        //Probando triFunction metodo extendido:
        TriFunction<Long> tryTriFunction = new TriFunction<Long>() {
            @Override
            public Function<Long, Function<Long, Function<Long, Long>>> eval() {
                return x -> y -> z ->  (2*x + 3*y + 4*z);
            }
        };
        System.out.println("Probando triFunction: --> " + tryTriFunction.eval()
                .apply((long)testX)
                .apply((long)testY)
                .apply((long)testZ));



        //Probando triFunction metodo simplificado (lambda)
        TriFunction<Long> tryTriFunction2 = () -> x -> y -> z ->  (2*x + 3*y + 4*z);

        System.out.println("Probando con Curry2: --> " + tryTriFunction.eval()
                                                                        .apply((long)testX)
                                                                        .apply((long)testY)
                                                                        .apply((long)testZ));
    }


}
