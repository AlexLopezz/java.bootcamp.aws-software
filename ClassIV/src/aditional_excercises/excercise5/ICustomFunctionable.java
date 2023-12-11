package aditional_excercises.excercise5;

@FunctionalInterface
public interface ICustomFunctionable<T extends Number> {
    T apply (T x, T y);
}
