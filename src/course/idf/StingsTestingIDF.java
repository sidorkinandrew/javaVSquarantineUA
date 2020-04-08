package course.idf;

import java.util.HashSet;
import java.util.Set;

public class StingsTestingIDF {
    public static void main(String[] args) {
        // Програмні завдання 1. Опрацювання Strings:
        // - в тексті слова заданої довжини заміниті вказаним підрядком,
        //   довжина якого може не співпадати із довжиною слова;
        String inputText = "On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.";
        System.out.println("Почтаковий текст: \n" + inputText);
        int task1ReplaceWordLength = 5;
        String task1ReplaceWith = "{replaced inputText}";
        String[] splittedText = inputText.split(" ");
        printFancyHeader("Task1: в тексті слова заданої довжини заміниті вказаним підрядком,\n" +
                "довжина якого може не співпадати із довжиною слова;\n" +
                "використана довжина: " + task1ReplaceWordLength + " підрядок для заміни: " + task1ReplaceWith);
        for (int i = 0; i < splittedText.length; i++) {
            String aWord = splittedText[i].replaceAll("[,. :;-]", "");  // replace with a function
            if (aWord.length() == task1ReplaceWordLength) {
                splittedText[i] = task1ReplaceWith;
            }
        }
        System.out.println("Результат: " + String.join(" ", splittedText));
        // - в тексті після k-го символу вставити заданий підрядок;
        int task2SplitKSymbolsLength = 5;
        String task2AppendText = "{appended inputText}";
        StringBuilder new_text = new StringBuilder("");
        printFancyHeader("Task2: в тексті після k-го символу вставити заданий підрядок;\n" +
                "кількість символів: " + task2SplitKSymbolsLength + " рядок, який додається: " + task2AppendText);
        for (int i = 0; i <= inputText.length() / task2SplitKSymbolsLength; i++) {
            new_text.append(inputText.substring(i * task2SplitKSymbolsLength, Math.min((i + 1) * task2SplitKSymbolsLength, inputText.length())));
            new_text.append(task2AppendText);
        }
        System.out.println("Результат: " + new_text);
        // - після кожного слова тексту, що закінчується заданим підрядком, вставити вказане слово;
        String task3EndsWith = "ing";
        String task3AddWord = " {new word inserted}";
        printFancyHeader("Task3: після кожного слова тексту, що закінчується заданим підрядком, вставити вказане слово;\n" +
                "слово закінчується на: " + task3EndsWith + " підрядок, що додається: " + task3AddWord);
        splittedText = inputText.split(" ");
        for (int i = 0; i < splittedText.length; i++) {
            String aWord = splittedText[i].replaceAll("[,. :;-]", "");  // replace with a function
            if (aWord.endsWith(task3EndsWith)) {
                splittedText[i] = splittedText[i] + task3AddWord;
            }
        }
        System.out.println("Результат: " + String.join(" ", splittedText));
        printFancyHeader("Task4: знайти, скільки разів повторюється в тексті кожне слово, що зустрічається в ньому;");
        // - знайти, скільки разів повторюється в тексті кожне слово, що зустрічається в ньому;
        splittedText = inputText.split(" ");  // naive
        Set<String> wordSet = new HashSet<String>();
        for (String string : splittedText) {
            String aWord = string.replaceAll("[,. :;-]", "");  // replace with a function
            if (!wordSet.contains(aWord)) {
                System.out.println(aWord + " зустрічається " + inputText.split(aWord).length + " раз(ів)");
                wordSet.add(aWord);
            }
        }
        System.out.println("Разом у тексті є " + wordSet.size() + " унікальних слів");
        printFancyHeader("Task5: знайти без повторів слова тексту, в яких перша і остання букви співпадають;");
        // - знайти без повторів слова тексту, в яких перша і остання букви співпадають;
        wordSet = new HashSet<String>();
        for (String string : splittedText) {
            String aWord = string.replaceAll("[,. :;-]", "");  // replace with a function
            if (!wordSet.contains(aWord) & (aWord.charAt(0) == aWord.charAt(aWord.length() - 1))) {
                System.out.println(aWord + " починається і закінчується на " + aWord.charAt(0));
                wordSet.add(aWord);
            }
        }
        printFancyHeader("Task6: в тексті знайти всі слова максимальної та всі слова мінімальної довжини;");
        // - в тексті знайти всі слова максимальної та всі слова мінімальної довжини;
        int minWordLength = splittedText[0].length(), maxWordLength = splittedText[0].length();
        Set<String> minLengthWords = new HashSet<String>();
        minLengthWords.add(splittedText[0]);
        Set<String> maxLengthWords = new HashSet<String>();
        maxLengthWords.add(splittedText[0]);
        for (String aWord : splittedText) {
            aWord = aWord.replaceAll("[,. :;-]", "");  // replace with a function
            if (minWordLength > aWord.length()) {
                minWordLength = aWord.length();     // new minimum found
                minLengthWords.clear();             // dumping all previous minimal words
                minLengthWords.add(aWord);          // adding new one
            } else if (minWordLength == aWord.length()) {
                minLengthWords.add(aWord);
            }
            if (maxWordLength < aWord.length()) {
                maxWordLength = aWord.length();     // new maximum found
                maxLengthWords.clear();             // dumping all previous maximal words
                maxLengthWords.add(aWord);          // adding new one
            } else if (maxWordLength == aWord.length()) {
                maxLengthWords.add(aWord);
            }
        }
        System.out.println("всі слова мінімальної довжини: " + minLengthWords.toString());
        System.out.println("всі слова максимальної довжини: " + maxLengthWords.toString());
        printFancyHeader("Task 7: зробити великими перші букви у кожному слові тексту.");
        // - зробити великими перші букви у кожному слові тексту.
        for (String aWord: splittedText) {
            System.out.print(Character.toUpperCase(aWord.charAt(0)) + aWord.substring(1) + " ");
        }
        System.out.println();
    }

    public static void printFancyHeader(String aText) {
        String separator = "===================================================================";
        System.out.println(separator);
        System.out.println(aText);
        System.out.println(separator);
    }
}
