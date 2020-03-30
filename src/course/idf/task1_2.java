package course.idf;

public class task1_2 {
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

        perform binary addition K+L, K+M, L+M
        */
        printFancyHeader("Converting K (dec) to (bin) and (hex)");
        int[] arrayOfK = {3009, 3555, 2996, 4050, 3120};
        for (int intNumber : arrayOfK) { // convert K (dec) to (bin) and (hex)
            System.out.println("Value K(dec): " + intNumber + " in BIN: 0b" + decimalToBinary(intNumber) + " in HEX: 0x" + decimalToHexadecimal(intNumber));
        }
        printFancyHeader("Converting L (hex) to (bin) and (dec)");
        String[] arrayOfL = {"2AB", "4BA", "27E", "35B", "2B7"};
        for (String numberString : arrayOfL) { // convert L (hex) to (bin) and (dec)
            System.out.println("Value L(hex): 0x" + numberString + " in BIN: 0b" + hexadecimalToBinary(numberString) + " in DEC: " + hexadecimalToDecimal(numberString));
        }
        printFancyHeader("Converting M (bin) to (hex) and (dec)");
        String[] arrayOfM = {"001101100000", "001111011101", "001111001111", "001110111011", "001001111001"};
        for (String numberString : arrayOfM) { // convert M (bin) to (hex) and (dec)
            System.out.println("Value M(bin): 0b" + numberString + " in HEX: 0x" + binaryToHexadecimal(numberString) + " in DEC: " + binaryToDecimal(numberString));
        }
        printFancyHeader("Performing binary addition for K+L");
        for (int i = 0; i < arrayOfK.length; i++) {
            String binaryNumber1 = decimalToBinary(arrayOfK[i]), binaryNumber2 = hexadecimalToBinary(arrayOfL[i]), binaryResult = binaryAddition(binaryNumber1, binaryNumber2);
            System.out.println("K (bin): " + binaryNumber1 + " + L (bin) " + binaryNumber2 + " equals to " + binaryResult);
            System.out.println("=> checking (dec) " + binaryToDecimal(binaryNumber1) + " + " + binaryToDecimal(binaryNumber2) + " = " + binaryToDecimal(binaryResult));
        }
        printFancyHeader("Performing binary addition for K+M");
        for (int i = 0; i < arrayOfK.length; i++) {
            String binaryNumber1 = decimalToBinary(arrayOfK[i]), binaryNumber2 = arrayOfM[i], binaryResult = binaryAddition(binaryNumber1, binaryNumber2);
            System.out.println("K (bin): " + binaryNumber1 + " + M (bin) " + binaryNumber2 + " equals to " + binaryResult);
            System.out.println("=> checking (dec) " + binaryToDecimal(binaryNumber1) + " + " + binaryToDecimal(binaryNumber2) + " = " + binaryToDecimal(binaryResult));
        }
        printFancyHeader("Performing binary addition for L+M");
        for (int i = 0; i < arrayOfL.length; i++) {
            String binaryNumber1 = hexadecimalToBinary(arrayOfL[i]), binaryNumber2 = arrayOfM[i], binaryResult = binaryAddition(binaryNumber1, binaryNumber2);
            System.out.println("L (bin): " + binaryNumber1 + " + M (bin) " + binaryNumber2 + " equals to " + binaryResult);
            System.out.println("=> checking (dec) " + binaryToDecimal(binaryNumber1) + " + " + binaryToDecimal(binaryNumber2) + " = " + binaryToDecimal(binaryResult));
        }
    }

    public static String binaryAddition(String binaryNumber1, String binaryNumber2) {
        StringBuilder binaryResult = new StringBuilder();
        int lengthNumber1 = binaryNumber1.length() - 1, lengthNumber2 = binaryNumber2.length() - 1, carryDigit = 0;
        while (lengthNumber1 >= 0 || lengthNumber2 >= 0) {
            int currentPartialSum = carryDigit;
            if (lengthNumber2 >= 0) currentPartialSum += binaryNumber2.charAt(lengthNumber2--) - '0';
            if (lengthNumber1 >= 0) currentPartialSum += binaryNumber1.charAt(lengthNumber1--) - '0';
            binaryResult.append(currentPartialSum % 2);
            carryDigit = currentPartialSum / 2;
        }
        if (carryDigit != 0) binaryResult.append(carryDigit);
        return binaryResult.reverse().toString();
    }

    public static void printFancyHeader(String aText) {
        String separator = "===================================================================";
        System.out.println(separator);
        System.out.println(aText);
        System.out.println(separator);
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
