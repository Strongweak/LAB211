
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
public class ConvertManager {
    public static String convert(String inputNumber, int inputBase, int outputBase) {
        String result = "";
        switch (inputBase) {
            case 1:
                result = convertFromBinary(inputNumber, outputBase);
                break;
            case 2:
                result = convertFromDecimal(inputNumber, outputBase);
                break;
            case 3:
                result = convertFromHexadecimal(inputNumber, outputBase);
                break;
        }
        return result;
    }    

    private static String convertFromBinary(String inputNumber, int outputBase) {
        String result = "";
        switch(outputBase){
            //convert from binary to itself
            case 1:
                result = inputNumber;
                break;
            //convert from binary to decimal    
            case 2:
                result = convertToDecimal(inputNumber,2);
                break;
            //convert from binary to hexadecimal    
            case 3: 
                result = convertdecimalToOther(convertToDecimal(inputNumber, 2), 16);
                break;
        }
        return result;
    }

    private static String convertFromDecimal(String inputNumber, int outputBase) {
        String result = "";
        switch(outputBase){
            //convert from decimal to binary
            case 1:
                result = convertdecimalToOther(inputNumber, 2);
                break;
            //convert from decimal to itself    
            case 2:
                result = inputNumber;
                break;
            //convert from decimal to hexadecimal    
            case 3: 
                result = convertdecimalToOther(inputNumber, 16);
                break;
        }
        return result;        
    }

    private static String convertFromHexadecimal(String inputNumber, int outputBase) {
        String result = "";
        switch(outputBase){
            //convert from hexadecimal to binary
            case 1:
                result = convertdecimalToOther(convertToDecimal(inputNumber,16), 2);
                break;
            //convert from hexadecimal to decimal    
            case 2:
                result = convertToDecimal(inputNumber,16);
                break;
            //convert from hexadecimal to itself     
            case 3:
                result = inputNumber;
                break;
        }
        return result;        
    }
    //convert from binary or hexadecimal to decimal
    public static String convertToDecimal(String inputNumber, int base) {
        BigInteger baseBigInteger = BigInteger.valueOf(base);
        String HEX = "0123456789ABCDEF";
        BigInteger result = new BigInteger("0");
        //loop length of number times
        for(int i = 0;i<inputNumber.length(); i++){
            BigInteger valueIndex = BigInteger.valueOf(HEX.indexOf(inputNumber.charAt(i)));
            BigInteger number = valueIndex.multiply(baseBigInteger.pow(inputNumber.length() - i - 1));
            result = result.add(number);
        }
        String resultString = result.toString();
        return resultString;
    }
    //convert from decimal to binary or hexadecimal
    private static String convertdecimalToOther(String decimalNumber, int base) {
        BigInteger decimalBigInteger = new BigInteger(decimalNumber);
        BigInteger baseBigInteger = BigInteger.valueOf(base);
        String HEX = "0123456789ABCDEF";
        String resultString = "";
        // loop until decimal number equal 0
        while(decimalBigInteger.compareTo(new BigInteger("0")) > 0){
            int remainder = decimalBigInteger.mod(baseBigInteger).intValue();
            resultString = HEX.charAt(remainder) + resultString + "";
            decimalBigInteger = decimalBigInteger.divide(baseBigInteger);
        }
        return resultString;
    }
}
