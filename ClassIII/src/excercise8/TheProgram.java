package excercise8;

import java.util.LinkedList;
import java.util.List;

public class TheProgram {
    private int number;
    private List<Integer> consecutiveNumbers;
    private long startTimeMethod;
    private long endTimeMethod;

    public TheProgram() {
        this.consecutiveNumbers = new LinkedList<>();
        startTimeMethod = 0;
        endTimeMethod = 0;
        number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private boolean isConsecutiveAdditionRecursive(int number, int add){
        if(add == number)
            return true;


        if(add > number)
            return false;

        return isConsecutiveAdditionRecursive(number, ++add);
    }
    public boolean isConsecutiveAddition(){
        int add = 0,
            auxLoop = 0;
        while (add < number){
            consecutiveNumbers.add(++auxLoop);
            add+= auxLoop;
            if(add == number)
                return true;
        }

        return false;
    }

    public List<Integer> getConsecutiveNumbers() {
        return consecutiveNumbers;
    }

    public List<Integer> showConsecutiveAdditionFrom(){
        int add = 0,
            auxLoop = 1;
        while (add < number){
            add+= auxLoop++;
            consecutiveNumbers.add(add);

            if(add == number)
                return consecutiveNumbers;
        }

        consecutiveNumbers.clear();
        throw new RuntimeException("Lo sentimos, este numero NO ES CONSECUTIVO de ninguna sumatoria de numeros.");
    }
    public boolean isConsecutiveAdditionR(){
        return isConsecutiveAdditionRecursive(number, 0);
    }

    public double getPerformanceLoopMethod(){
        startTimeMethod = System.currentTimeMillis();
        isConsecutiveAddition();
        endTimeMethod = System.currentTimeMillis();

        return castTimeToSeconds(endTimeMethod);
    }
    public double getPerformanceRecursiveMethod(){
        startTimeMethod = System.currentTimeMillis();
        isConsecutiveAdditionR();
        endTimeMethod = System.currentTimeMillis();

        return castTimeToSeconds(endTimeMethod);
    }

    private double castTimeToSeconds(long time){
        return (double) ((endTimeMethod - startTimeMethod)/1000);
    }
}
