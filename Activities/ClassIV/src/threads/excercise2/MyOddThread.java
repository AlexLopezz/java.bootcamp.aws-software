package threads.excercise2;

import java.util.ArrayList;
import java.util.List;

public class MyOddThread extends MyBaseThread{
    private List<Integer> oddNumbers;
    public MyOddThread() {
        super();
    }

    public MyOddThread(List<Integer> numbers) {
        super(numbers);
    }

    private void extractOddNumbers(){
        this.oddNumbers = new ArrayList<>();
        numbers.forEach(
                n -> {
                    if(n % 2 != 0)
                        oddNumbers.add(n);
                }
        );
    }

    public List<Integer> getOddNumbers() {
        extractOddNumbers();
        return oddNumbers;
    }

    public int getSumOddNumbers(){
        return oddNumbers.stream().reduce(Integer::sum).orElseThrow();
    }
    @Override
    public void run() {
        System.out.println("----"+ this.getClass().getSimpleName() +"----");
        System.out.println("> Numeros de la lista --> "+ getNumbers());
        System.out.println("> Numeros impares de la lista --> "+ getOddNumbers());
        System.out.println("> La suma de numeros impares da como resultado: "+ getSumOddNumbers());
    }
}
