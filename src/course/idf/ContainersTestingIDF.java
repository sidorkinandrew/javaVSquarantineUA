package course.idf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ContainersTestingIDF {
    // Програмні завдання 2. Опрацювання масивів цілих чисел із утворенням колекцій:
    public static void main(String[] args) {
        int randomListSize = 100;
        List<Integer> inputArray = new ArrayList<>();
        Random randomGenerator = new Random();
        int randomNumbersRange = 20;
        for (int index = 0; index < randomListSize; index++) {
            inputArray.add(randomGenerator.nextInt(randomNumbersRange) - randomNumbersRange / 2);
        }
        System.out.println("Вхідний масив випадкових чисел" + inputArray.toString() + "\n" +
                "кількість чисел у масиві: " + randomListSize);
        printFancyHeader("Task1: масив розділити на дві колекції з від’ємних та додатніх чисел,");
        // - масив розділити на дві колекції з від’ємних та додатніх чисел,
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();
        for (Integer number : inputArray) {
            if (number > 0) {
                positiveNumbers.add(number);
            } else {
                negativeNumbers.add(number);
            }
        }
        System.out.println("Масив додатніх чисел: " + positiveNumbers.toString() + " кількість елементів: " + positiveNumbers.size());
        System.out.println("Масив від’ємних чисел: " + negativeNumbers.toString() + " кількість елементів: " + positiveNumbers.size());
        printFancyHeader("Task 2: з масиву видалити дублікати максимума та мінімума (уточнення: видалити саме\n" +
                "дублікати, тобто перші значення максимума та мінімума необхідно залишити).");
        // - з масиву видалити дублікати максимума та мінімума (уточнення: видалити саме
        // дублікати, тобто перші значення максимума та мінімума необхідно залишити).
        Integer minValue = Collections.min(inputArray);
        Integer maxValue = Collections.max(inputArray);
        System.out.println("Мінімальний елемент у масиві: " + minValue + " максимальний елемент - " + maxValue);
        boolean firstMax = true;
        int deletedMins = 0;
        boolean firstMin = true;
        int deletedMaxs = 0;
        int i = 0;
        while (true) {
            if (i++ == inputArray.size() - 1) {
                break;
            }
            if (firstMax & inputArray.get(i).equals(maxValue)) {
                firstMax = false;
            } else if (!firstMax & inputArray.get(i).equals(maxValue)) {
                inputArray.remove(i);
                deletedMins++;
            }
            if (firstMin & inputArray.get(i).equals(minValue)) {
                firstMin = false;
            } else if (!firstMin & inputArray.get(i).equals(minValue)) {
                inputArray.remove(i);
                deletedMaxs++;
            }
        }
        System.out.println("Результат: " + inputArray.toString());
        System.out.println("Було видалено: " + deletedMins + " мінімумів (дублікатів) та " + deletedMaxs + " максимумів (дублікатів).");
        printFancyHeader("Task 3: визначити середнє арифметичне елементів масиву та кількість елементів, що є");
        // - визначити середнє арифметичне елементів масиву та кількість елементів, що є більшими за середнє арифметичне.
        float averageValue = inputArray.stream().mapToInt(Integer::intValue).sum() / (float) inputArray.size();
        int countNumbersGreaterAverage = 0;
        for (Integer number : inputArray) {
            if (number > averageValue) {
                countNumbersGreaterAverage++;
            }
        }
        System.out.println("Середнє арифметичне елементів масиву: " + averageValue + ", " +
                "кількість елементів масиву, більших за середнє: " + countNumbersGreaterAverage);
        printFancyHeader("Task 4: визначити середні арифметичні двох масивів, утворити колекцію з елементів\n" +
                "обидвох масивів, що знаходяться в межах між значеннями середніх арифметичних.");
        // - визначити середні арифметичні двох масивів, утворити колекцію з елементів
        // обидвох масивів, що знаходяться в межах між значеннями середніх арифметичних.
        List<Integer> inputArray1 = new ArrayList<>();
        List<Integer> inputArray2 = new ArrayList<>();
        randomNumbersRange = 200;
        for (int index = 0; index < randomListSize * 2; index++) {  // generate array 1 x3 = 300 numbers
            inputArray1.add(randomGenerator.nextInt(randomNumbersRange) - randomNumbersRange / 2);
        }
        float averageValue1 = inputArray1.stream().mapToInt(Integer::intValue).sum() / (float) inputArray1.size();
        System.out.println("Масив 1: " + inputArray1.toString() + "\nКількість елеметнів: " + inputArray1.size() + "" +
                " середнє арифметичне масиву 1: " + averageValue1);
        for (int index = 0; index < randomListSize; index++) {  // generate array 2 x5 = 500 numbers
            inputArray2.add(randomGenerator.nextInt(randomNumbersRange) - randomNumbersRange / 2);
        }
        float averageValue2 = inputArray2.stream().mapToInt(Integer::intValue).sum() / (float) inputArray2.size();
        System.out.println("Масив 2: " + inputArray2.toString() + "\nКількість елеметнів: " + inputArray2.size() + "" +
                " середнє арифметичне масиву 2: " + averageValue2);
        List<Integer> resultingArray = new ArrayList<>();
        float minAverageValue = Math.min(averageValue1, averageValue2);
        float maxAverageValue = Math.max(averageValue1, averageValue2);
        for (Integer number : inputArray1) { // scan through the first array
            if (number > minAverageValue & number < maxAverageValue) {
                resultingArray.add(number);
            }
        }
        for (Integer number : inputArray2) { // scan through the second array
            if (number > minAverageValue & number < maxAverageValue) {
                resultingArray.add(number);
            }
        }
        System.out.println("Результат: " + resultingArray.toString() + "\nКількість елементів: " + resultingArray.size());
    }

    public static void printFancyHeader(String aText) {
        String separator = "===================================================================";
        System.out.println(separator);
        System.out.println(aText);
        System.out.println(separator);
    }
}
