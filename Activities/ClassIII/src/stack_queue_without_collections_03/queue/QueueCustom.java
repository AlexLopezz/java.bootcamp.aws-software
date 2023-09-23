package stack_queue_without_collections_03.queue;

import java.util.Arrays;

public class QueueCustom<T> extends QueueAbstract<T> {

    public QueueCustom() { super(); }

    @Override
    public void queue(T t) {
        verifyLength();
        Node<T> nodeToAddQueue = new Node<>(t);

        if(!isEmpty()){
            top.next = nodeToAddQueue;
            top = nodeToAddQueue;

        }else {
            header = nodeToAddQueue;
            top = nodeToAddQueue;
        }

        myQueue[size++] = t;
    }

    @Override
    public T dequeue() {
        verifyLength();
        Node<T> aux;

        if(size() > 0) {
            aux = header;
            header = header.next;

            myQueue[0] = null;
            size--;

            return aux.element;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
       return super.toString();
    }
}
