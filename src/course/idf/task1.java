package course.idf;

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
        System.out.println("0b"+decimalToBinary(123));

    }
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }
    public static String decimalToHexadecimal(int dec) { return Integer.toHexString(dec); }
    public int  binaryToDecimal(String binaryString) {
        return Integer.parseInt(binaryString,2);
    }
    public int  hexadecimalToDecimal(String hexString) {
        return Integer.parseInt(hexString,16);
    }
}
