package stack_01;
import java.util.Stack;

public class StackeableCustom<T> implements IStackeable<T> {
    Stack<T> myStackCustom;

    public StackeableCustom() {
        this.myStackCustom = new Stack<>();
    }

    @Override
    public boolean isEmpty() {
        return myStackCustom.isEmpty();
    }

    @Override
    public void push(T o) {
        myStackCustom.push(o);
    }

    @Override
    public T pop() {
        return myStackCustom.pop();
    }

    @Override
    public int length() {
        return myStackCustom.size();
    }

    @Override
    public String toString() {
        return myStackCustom.toString();
    }
}
