package excercise2;


import java.util.ArrayList;
import java.util.List;

public class CustomQueue<T> implements IQueue<T> {
    List<T> myQueue;

    public CustomQueue() {
        this.myQueue = new ArrayList<>();
    }

    @Override
    public void queue(T t) {
        myQueue.add(t);
    }

    @Override
    public T dequeue() {
        T obj = myQueue.get(0);
        myQueue.remove(0);

        return obj;
    }

    @Override
    public int size() {
        return myQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return myQueue.size() > 0;
    }

    @Override
    public String toString() {
        return myQueue.toString();
    }
}
