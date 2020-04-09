package course.idf;

public class Model {
    static class Triangle {
        public String builtTrangle;
        String rowFiller = ".";
        int maxWidth = 10;
        int mode = 1;
    /* mode 1 - left-up;    mode 2 - left-down
       mode 3 - right-down; mode 4 - right-up */
    }
    static class DoubleTriangle{
        Triangle firstTriangle = new Triangle();
        Triangle secondTriangle = new Triangle();
    }
}
