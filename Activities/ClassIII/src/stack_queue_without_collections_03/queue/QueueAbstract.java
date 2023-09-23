package stack_queue_without_collections_03.queue;

import queue_02.IQueue;

import java.util.Arrays;

public abstract class QueueAbstract<T> implements IQueue<T> {
    protected Node<T> header;
    protected Node<T> top;
    protected int size;
    private final int INITIAL_SIZE = 5;

    protected Object[] myQueue;

    public QueueAbstract() {
        myQueue = new Object[INITIAL_SIZE];
        size = 0;
    }
    public Node<T> header(){
        return header;
    }
    public Node<T> top(){
        return top;
    }

    void increaseCapacity(){
        myQueue= Arrays.copyOf(myQueue, (size + INITIAL_SIZE));
    }

    protected void verifyLength() {
        if(size() == myQueue.length)
            increaseCapacity();
    }

    @Override
    public String toString() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder();

            sb.append("[");
            for (Object o : myQueue) {
                if (o != null)
                    sb.append(o).append(", ");
            }
            sb.deleteCharAt(sb.length()-2); //Eliminamos la ultima coma.
            sb.append("]");

            return sb.toString();
        }

        return null;
    }
}
