package stack_queue_without_collections_03.stack;

import stack_01.IStackeable;

import java.util.Arrays;

public abstract class AbstractStack<T> implements IStackeable<T> {
    protected int size;
    private final int INITIAL_SIZE = 5;
    protected Object[] myStack;

    public AbstractStack() {
        myStack = new Object[INITIAL_SIZE];
        size = 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder();

            sb.append("[");
            for (Object o : myStack) {
                if (o != null)
                    sb.append(o).append(", ");
            }
            sb.deleteCharAt(sb.length() - 2); //Eliminamos la ultima coma.
            sb.append("]");

            return sb.toString();
        }
        
        return null;
    }
}
