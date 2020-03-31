package course.idf;

public class task_3 {
    public static void main(String[] args) {
        int defaultDepth = 15;
        // Task 1
        printFancyHeader("Lesson 3. Task 1");
        for (int i = 0; i < 4; i++) {
            printFancyHeader("Triangle type" + (i + 1) + " depth = " + defaultDepth);
            buildTriangle(i + 1, defaultDepth);
        }
        // Task 2
        printFancyHeader("Lesson 3. Task 2. Type 1"); // using triangles type 1 + type 2
        buildTriangle(1, defaultDepth);
        buildTriangle(2, defaultDepth);
        printFancyHeader("Lesson 3. Task 2. Type 2"); // using triangles type 1 + type 3
        buildTriangle(1, defaultDepth);
        buildTriangle(3, defaultDepth);
        printFancyHeader("Lesson 3. Task 2. Type 3"); // using triangles type 4 + type 2
        buildTriangle(4, defaultDepth);
        buildTriangle(3, defaultDepth);
        printFancyHeader("Lesson 3. Task 2. Type 4"); // using triangles type 4 + type 2
        buildTriangle(4, defaultDepth);
        buildTriangle(2, defaultDepth);
        printFancyHeader("Lesson 3. Task 3. Build "); // using triangles type 4 + type 2
        int baseWidth = 12, increaseWidth = 4, maxRows = 4, maxFrameWidth = baseWidth + maxRows * increaseWidth;
        String[] rowFillers = {"*", "$", "%", "@"};
        for (int i = 0; i < maxRows; i++)
            buildChristmasTreeElement(baseWidth + i * increaseWidth, rowFillers[i], maxFrameWidth);
    }

    public static void buildChristmasTreeElement(int maxWidth, String rowFiller, int maxFrameWidth) {
        String space = " ";
        int evenTop = (maxWidth % 2 == 0) ? 2 : 1;
        int rowsToBuild = maxWidth / 2 + ((maxWidth % 2 == 0) ? 0 : 1);  // uneven width needs one more row
        int padding = (maxFrameWidth - maxWidth) / 2;  // in case we build a tree within pre-defined frame
        for (int i = 0; i < rowsToBuild; i++) {
            System.out.println(space.repeat(padding + rowsToBuild - 1 - i) + rowFiller.repeat(evenTop + i * 2) + space.repeat(padding + rowsToBuild - 1 - i));
        }
    }

    public static void buildChristmasTreeElement(int maxWidth, String rowFiller) {
        buildChristmasTreeElement(maxWidth, rowFiller, maxWidth);
    }

    public static void buildTriangle(int mode, int maxWidth) {
        /* mode 1 - left-up;    mode 2 - left-down
           mode 3 - right-down; mode 4 - right-up */
        String rowFiller = ".", space = " ";
        for (int i = 0; i < maxWidth; i++)
            if (mode == 1) System.out.println(rowFiller.repeat(i + 1));  // left-up
            else if (mode == 2) System.out.println(rowFiller.repeat(maxWidth - i) + space.repeat(i)); //left-down
            else if (mode == 3) System.out.println(space.repeat(i) + rowFiller.repeat(maxWidth - i)); // right-down
            else if (mode == 4)
                System.out.println(space.repeat(maxWidth - i - 1) + rowFiller.repeat(i + 1)); // right-up
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
