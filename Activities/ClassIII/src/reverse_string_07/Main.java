package reverse_string_07;

public class Main {
    static String reverseStr(String string){
        if(string.isEmpty())
            return string;

        return reverseStr(string.substring(1)) + string.charAt(0);
    }

    public static void main(String[] args) {
        String test = "Alexander";

        System.out.println("test = " + reverseStr(test));
    }
}
