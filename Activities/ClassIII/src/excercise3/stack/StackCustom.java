package excercise3.stack;

import java.util.Arrays;

public class StackCustom<T> extends AbstractStack<T> {
    public StackCustom() { super(); }

    @Override
    public void push(T t) {
        verifyLength();
        myStack[size++] = t;
    }

    @Override
    public T pop() {
        if(!isEmpty()) {
            size -=1;
            Object objToReturn = myStack[size];
            myStack[size] = null;

            return (T) objToReturn;
        }

        throw new RuntimeException("No es posible eliminar elementos de la Pila, esto debido a que esta vacia.");
    }


    private void verifyLength() {
        if(size == myStack.length)
            increaseCapacity();
    }
    private void increaseCapacity(){
        myStack= Arrays.copyOf(myStack, size*2);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
