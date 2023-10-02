package optionals;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Demo {
    //Generar un método que reciba 3 parámetros booleanos y devuelva P1 && P2 && P3
    //Los parametros serán Boolean (pueden ser nulos)
    //Un parámetro nulo será considerado FALSE

    static Boolean testBoolean(Boolean p1, Boolean p2, Boolean p3){
        return Stream.of(p1, p2, p3)
                .allMatch(v -> Objects.requireNonNullElse(v, false));
    }

    //Definir el metodo anterior pero pensando en 3 Predicados genéricos y luego resolver el método anterior invocando este nuevo método genérico.
    static <T> Boolean genericBooleanTest(T p1, T p2, T p3){
        Predicate<T> testGeneric = v -> (boolean) Objects.requireNonNullElse(v, false);  //verificamos si el valor es null, si lo es... entonces tendra el valor de false.

        return testGeneric.test(p1) && testGeneric.test(p2) && testGeneric.test(p3); //Retornamos el resultado, en base a los resultados de los predicados
    }

    public static void main(String[] args) {
        Boolean resulTest = testBoolean(true, null, true);
        System.out.println("resulTest = " + resulTest);


        resulTest = genericBooleanTest(null, false, true);
        System.out.println("result generic test = "+ resulTest);

    }
}
