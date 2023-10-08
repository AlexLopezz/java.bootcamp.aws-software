package aditional_excercises.excercise4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Demo {

    public static String[] testDemo(String text){
        Stream<String> stream = Stream.of(text.replaceAll("[.,;\n]", "").split(" "));

        return stream
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String text = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec laoreet porttitor mi rutrum tincidunt.\s
                Mauris sodales arcu mauris, et blandit ex mattis eu. Sed non consequat sapien. Cras convallis nec ante et semper.\s
                Cras quis pharetra urna, a lacinia purus. Fusce risus eros, tristique sit amet tellus ac, faucibus porttitor.
                """;

        String[] textStr = testDemo(text);

        Arrays.asList(textStr).forEach(System.out::println);
    }
}
