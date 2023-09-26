package excercise7;

public class Demo {
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
