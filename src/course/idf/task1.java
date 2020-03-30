package course.idf;

import java.math.BigInteger;

public class task1 {
    public static void main(String[] args) {
        /* convert numbers
        K (dec) = ... (bin) = ... (hex),
        L (hex) = ... (bin) = ... (dec),
        M (bin) = ... (hex) = ... (dec).
        where
            K (dec) L (hex) M (bin)
        01 3009     2AB     0011 0110 0000
        02 3555     4BA     0011 1101 1101
        03 2996     27E     0011 1100 1111
        04 4050     35B     0011 1011 1011
        05 3120     2B7     0010 0111 1001
        */
        printFancyHeader("Converting K(DEC) to BIN and HEX");
        int[] arrayOfK = {3009, 3555, 2996, 4050, 3120};
        for (int intNumber : arrayOfK) { // convert K(DEC) to BIN and HEX
            System.out.println(intNumber + " in BIN: 0b" + decimalToBinary(intNumber) + " in HEX: 0x" + decimalToHexadecimal(intNumber));
        }
        printFancyHeader("Converting L(HEX) to BIN and DEC");
        String[] arrayOfL = {"2AB", "4BA", "27E", "35B", "2B7"};
        for (String numberString : arrayOfL) { // convert L(HEX) to BIN and DEC
            System.out.println("0x"+numberString + " in BIN: 0b" + hexadecimalToBinary(numberString) + " in DEC: " + hexadecimalToDecimal(numberString));
        }
    }

    public static void printFancyHeader(String aText){
        System.out.println("==========================================");
        System.out.println(aText);
        System.out.println("==========================================");
    }
    public static String hexadecimalToBinary(String hexadecimalString) {
        return decimalToBinary(hexadecimalToDecimal(hexadecimalString));
    }

    public static String binaryToHexadecimal(String binaryString) {
        return decimalToHexadecimal(binaryToDecimal(binaryString));
    }

    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }

    public static String decimalToHexadecimal(int dec) {
        return Integer.toHexString(dec);
    }

    public static int binaryToDecimal(String binaryString) {
        return Integer.parseInt(binaryString, 2);
    }

    public static int hexadecimalToDecimal(String hexString) {
        return Integer.parseInt(hexString, 16);
    }
}
