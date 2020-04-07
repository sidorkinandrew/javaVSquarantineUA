package course.idf;

public class task_2 {
    public static void main(String[] args) {
        String s = "-";
        boolean b = false;
        int x = 7, y = 8;
        if((x < 8) ^ (b = true)) s += "^";
        System.out.println(x+" "+y);
        if(!(x > 8) | ++y > 5) s += "|"; // no shortcut
        System.out.println(x+" "+y);
        if(++y > 9 && b == true) s += "&&";
        System.out.println(x+" "+y);
        if(y % 8 > 1 || y / (x - 7) > 1) s += "%"; //shortcut
        System.out.println(x+" "+y);
        System.out.println(s);
    }
}