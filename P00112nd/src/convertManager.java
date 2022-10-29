
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Strongest
 */
class convertManager {
    //convert from 2 or 16 to 10
    public String convertToDecimal(String input, int inputBase) {
        BigInteger result = new BigInteger("0");
        BigInteger bigBase = BigInteger.valueOf(inputBase);
        String hex = "0123456789ABCDEF";
        
        
        for (int i = 0; i < input.length(); i++) {
            BigInteger numberAtIndex = BigInteger.valueOf(hex.indexOf(input.charAt(i)));
            BigInteger value = numberAtIndex.multiply(bigBase.pow(input.length() - i - 1));
            result = result.add(value);
        }
        String resultString = result.toString();
        return resultString;
    }
    //convert from 10 to 2 or 16
    public String convertDecimalToOther(String input, int outputBase){
        BigInteger decimalNumber = new BigInteger(input);
        BigInteger bigBase = BigInteger.valueOf(outputBase);
        String result = "";
        String hex = "0123456789ABCDEF";
        //loop until decimalnumber is equally or smaller than 0
        while(decimalNumber.compareTo(new BigInteger("0")) > 0){
            int remainder = decimalNumber.mod(bigBase).intValue();
            //inputNumber = (inputNumber - remainder) / outputBase;
            BigInteger bigRemainder = BigInteger.valueOf(remainder);
            decimalNumber = (decimalNumber.subtract(bigRemainder)).divide(bigBase);
            //char => String
            String numberAtIndex = String.valueOf(hex.charAt(remainder));
            result = numberAtIndex + result;
        }
        return result.toUpperCase();
    }

}
