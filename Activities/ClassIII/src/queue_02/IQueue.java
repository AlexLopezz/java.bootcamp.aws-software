package queue_02;

import utils.ICollectionable;

import java.util.Queue;

public interface IQueue<T> {
    void queue(T t);
    T dequeue();
    int size();
    boolean isEmpty();
}
