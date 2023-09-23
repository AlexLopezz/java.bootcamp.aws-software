package stack_01;

public interface IStackeable<T>{
    boolean isEmpty();
    void push(T t);
    T pop();
    int length();
}
