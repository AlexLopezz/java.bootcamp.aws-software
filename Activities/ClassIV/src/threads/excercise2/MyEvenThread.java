package threads.excercise2;

import java.util.ArrayList;
import java.util.List;

public class MyEvenThread extends MyBaseThread{
    private List<Integer> evenNumbers;

    public MyEvenThread() {
        super();
    }

    public MyEvenThread(List<Integer> numbers) {
        super(numbers);
    }

    private void extractEvenNumbers(){
        this.evenNumbers = new ArrayList<>();
        numbers.forEach(
                n -> {
                    if(n % 2 == 0)
                        evenNumbers.add(n);
                }
        );
    }

    public List<Integer> getEvenNumbers() {
        extractEvenNumbers();
        return evenNumbers;
    }

    public int getAddEvenNumbers(){
        return getEvenNumbers().stream().reduce(Integer::sum).orElseThrow();
    }

    @Override
    public void run() {
        System.out.println("----- "+this.getClass().getSimpleName()+" -----");
        System.out.println("Numeros de la lista --> "+ getNumbers());
        System.out.println("Los numeros pares de la lista son --> "+ getEvenNumbers());
        System.out.println("La suma de numeros pares da como resultado: "+ getAddEvenNumbers());
    }
}
