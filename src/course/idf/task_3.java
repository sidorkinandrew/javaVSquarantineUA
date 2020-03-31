package course.idf;

public class task_3 {
    public static void main(String[] args) {
        // Task 1
        printFancyHeader("Lesson 3. Task 1");
        for (int i = 0; i < 4; i++) {
            printFancyHeader("Triangle type"+(i+1)+" depth = 10");
            buildTriangle(i+1, 10);
        }
        // Task 2
        printFancyHeader("Lesson 3. Task 2. Type 1");
        buildTriangle(1, 10);
        buildTriangle(2, 10);
        printFancyHeader("Lesson 3. Task 2. Type 2");
        buildTriangle(1, 10);
        buildTriangle(3, 10);
        printFancyHeader("Lesson 3. Task 2. Type 3");
        buildTriangle(4, 10);
        buildTriangle(3, 10);
        printFancyHeader("Lesson 3. Task 2. Type 4");
        buildTriangle(4, 10);
        buildTriangle(2, 10);
    }

    public static void buildTriangle(int mode, int depth) {
        /* mode 1 - left-up;    mode 2 - left-down
           mode 3 - right-down; mode 4 - right-up */
        String rowFiller = ".", space = " ";
        for (int i = 0; i < depth; i++)
            if (mode == 1) System.out.println(rowFiller.repeat(i + 1));  // left-up
            else if (mode == 2) System.out.println(rowFiller.repeat(depth - i) + space.repeat(i)); //left-down
            else if (mode == 3) System.out.println(space.repeat(i) + rowFiller.repeat(depth - i)); // right-down
            else if (mode == 4) System.out.println(space.repeat(depth - i - 1) + rowFiller.repeat(i + 1)); // right-up
    }

    public static void buildTriangle(int mode) {
        buildTriangle(mode, 10);
    }

    public static void printFancyHeader(String aText) {
        String separator = "===================================================================";
        System.out.println(separator);
        System.out.println(aText);
        System.out.println(separator);
    }

}
