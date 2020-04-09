package course.idf;

public class task_2 {
    public static void main(String[] args) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(".".repeat(33));
        resultString.append(".".repeat(33));
        resultString.append(".".repeat(33));
        resultString.append(".".repeat(33));
        resultString.append(".".repeat(33));
        System.out.println(String.join("\n",resultString));
    }
}