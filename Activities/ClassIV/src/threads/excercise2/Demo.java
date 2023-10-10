package threads.excercise2;

import java.util.Arrays;
import java.util.List;

public class Demo {
    static List<Integer> numbers() {
        return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread myevenThr = new MyEvenThread(numbers());
        Thread myOddThr = new MyOddThread();



        myevenThr.start();
        Thread.sleep(1000);
        myOddThr.start();
    }
}