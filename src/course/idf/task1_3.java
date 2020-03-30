package course.idf;

public class task1_3 {
    public static void main(String[] args) {
    /*  convert to IEEE-754
        {10314.7, -22.09, 0.017} */
        double[] arrayOfNumbers = {10314.7, -22.09, 0.017};
        for (double aNumber : arrayOfNumbers) {
            String conversionResult = IEEE754toBinary(aNumber);
            System.out.println(aNumber + " in IEEE-754 equals to " + conversionResult);
            System.out.println("re-checking back: " + binaryToIEEE754(conversionResult));
        }
    }

    private static double binaryToIEEE754(String binaryString) {
        if ((binaryString.length() == 64) && (binaryString.charAt(0) == '1')) {
            String negativeBinaryString = binaryString.substring(1);
            long longFromBinary = Long.parseLong(negativeBinaryString, 2);
            return -1 * Double.longBitsToDouble(longFromBinary);
        }
        long longFromBinary = Long.parseLong(binaryString, 2);
        return Double.longBitsToDouble(longFromBinary);
    }

    private static String IEEE754toBinary(double IEEE754Number) {
        long longBits = Double.doubleToLongBits(IEEE754Number);
        return Long.toBinaryString(longBits);
    }
}
