package excercise3;

import utils.Main;

public class TheProgram extends Main {
    public TheProgram() {
        super();
    }

    @Override
    public void run() {

        while (follow) {
            try{
                switch (decisionMenuUser()) {
                    case 1 -> convertNumberToBinary();
                    case 2 -> convertBinaryToNumber();
                    default -> System.out.println("X No elegio ninguna opcion disponible.");
                }
            }catch (RuntimeException re){
                System.out.println("X Debe elegir una opcion disponible del menu. (1 o 2 en este caso).");
            }

            follow = checkDecisionFollowUser();
        }
    }

    @Override
    public int decisionMenuUser() {
        System.out.println("¡Bienvenido @user!");
        System.out.println("¿Que desea realizar?");
        System.out.println("1. Convertir numero decimal a binario");
        System.out.println("2. Convertir binario a numero decimal");
        System.out.print("Respuesta: ");

        return Integer.parseInt(read.next());
    }

    public double toBinary(int decimalNumber){
        StringBuilder sb = new StringBuilder();
        int quotient = decimalNumber;

        while (quotient > 0){
            sb.append(quotient % 2);
            quotient /= 2;
        }

        return Double.parseDouble(sb.reverse().toString());
    }
    public int toDecimal(double binaryNumber){
        var binaryNumberArray = Integer.valueOf((int)binaryNumber).toString().toCharArray();
        int decimalNumberToReturn = 0,
                length = binaryNumberArray.length-1,
                pow = length;

        for(int i= 0; i <= length; i++){
            decimalNumberToReturn += Character.getNumericValue(binaryNumberArray[i]) * Math.pow(2, pow);
            pow--;
        }


        return decimalNumberToReturn;
    }

    private void convertBinaryToNumber() {
        try {
            int number = getNumberUser();
            if (!verifyBinaryNumber(number))
                System.out.println("X Debe ingresar un numero binario.");

            System.out.printf("\tEl numero %d en decimal es: %d\n", number, toDecimal(number));
        }catch (NumberFormatException nfe){
            System.out.println("X Debe ingresar un numero... Nada de simbolos, ni letras.");
        }
    }
    private void convertNumberToBinary(){
        try {
            int number = getNumberUser();

            System.out.printf("\tEl numero %d en binario es: %d\n", number, (int) toBinary(number));
        }catch (NumberFormatException nfe){
            System.out.println("X Debe ingresar un numero... Nada de simbolos, ni letras.");
        }
    }
    public boolean verifyBinaryNumber(double binaryNumber){
        String binaryNumberStr = String.valueOf((int)binaryNumber);

        for(int i= 0; i < binaryNumberStr.length(); i++){
            if(binaryNumberStr.charAt(i) != '1' && binaryNumberStr.charAt(i) != '0'){
                return false;
            }
        }

        return true;
    }
}
