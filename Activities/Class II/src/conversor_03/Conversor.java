package conversor_03;

public class Conversor {
    static double toBinary(int decimalNumber){
        StringBuilder sb = new StringBuilder();
        int quotient = decimalNumber;

        while (quotient > 0){
            sb.append(quotient % 2);
            quotient /= 2;
        }

        return Double.parseDouble(sb.reverse().toString());
    }

    static int toDecimal(double binaryNumber){
        var binaryNumberArray = Integer.valueOf((int)binaryNumber).toString().toCharArray();
        int decimalNumberToReturn = 0,
                length = binaryNumberArray.length-1,
                pow = length;

        for(int i= 0; i <= length; i++){
            decimalNumberToReturn +=  Character.getNumericValue(binaryNumberArray[i]) * Math.pow(2, pow);
            pow--;
        }


        return decimalNumberToReturn;
    }
}
