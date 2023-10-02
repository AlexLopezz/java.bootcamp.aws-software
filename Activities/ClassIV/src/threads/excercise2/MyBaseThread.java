package threads.excercise2;
import java.util.List;

public abstract class MyBaseThread extends Thread{
    protected final List<Integer> numbers;

    public MyBaseThread() {
        this.numbers = List.of(1,2,3,4,5,6,7,8,9,10);
    }

    public MyBaseThread(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
