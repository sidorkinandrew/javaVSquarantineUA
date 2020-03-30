package course.idf;

public class task1 {
    public static void main(String[] args) {
        System.out.println("0b"+decimalToBinary(123));

    }
    public static String decimalToBinary(int decimal) {
        return Integer.toBinaryString(decimal);
    }
    public static String decimalToHexadecimal(int dec) {
        return Integer.toHexString(dec);
    }
    public int  binaryToDecimal(String binaryString) {
        return Integer.parseInt(binaryString,2);
    }
    public int  hexadecimalToDecimal(String hexString) {
        return Integer.parseInt(hexString,16);
    }
}
