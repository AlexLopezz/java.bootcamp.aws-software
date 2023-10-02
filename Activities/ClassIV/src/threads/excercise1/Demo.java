package threads.excercise1;

import java.util.Arrays;
import java.util.List;

public class Demo {
    /**
     *  Este metodo mostrara los numeros que contenga la lista...
     *  con un retardo de 3 segundos.
     * @param numbers lista de enteros.
     */
    static void getNumbersSleep3(List<Integer> numbers) {
        numbers.forEach(n -> {
            System.out.println(n);
            try {
                Thread.sleep(3000);//miliseconds to seconds --> 3000 miliSeconds == 3 seconds...
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,17,18,19,20);
        getNumbersSleep3(numbers);
    }
}
