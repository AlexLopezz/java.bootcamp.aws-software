package excercise2;

public interface IQueue<T> {
    void queue(T t);
    T dequeue();
    int size();
    boolean isEmpty();
}
