package course.idf;

public class Model {
    static class Triangle {
        public String[] builtTrangle;
        String rowFiller = ".";
        int maxWidth = 10;
        int mode = 1;
    /* mode 1 - left-up;    mode 2 - left-down
       mode 3 - right-down; mode 4 - right-up */
    }

    static class DoubleTriangle {
        Triangle firstTriangle = new Triangle();
        Triangle secondTriangle = new Triangle();
    }

    static class ChristmasTreeElement {
        public String rowFiller;
        public int maxTreeWidth = 10;
        public int padding = 0;
        Triangle firstTriangle;
        Triangle secondTriangle;

        ChristmasTreeElement(String rowFiller) {
            this.firstTriangle = new Triangle();
            this.secondTriangle = new Triangle();
            this.firstTriangle.mode = 4;
            this.secondTriangle.mode = 1;
            this.rowFiller = rowFiller;
        }
    }

    static class ChristmasTree {
        int numLevels;
        ChristmasTreeElement[] treeElements;
        String rowFiller;

        public void setRowFiller(String rowFiller) {
            this.rowFiller = rowFiller;
            for (int level = 0; level < numLevels; level++) {
                this.treeElements[level].rowFiller = rowFiller;
                this.treeElements[level].firstTriangle.rowFiller = rowFiller;
                this.treeElements[level].secondTriangle.rowFiller = rowFiller;
            }
        }

        public void setNumLevels(int numLevels) {
            this.numLevels = numLevels;
            for (int level = 0; level < numLevels; level++) {
                this.treeElements[level].padding = (numLevels - level) * 2;
            }
        }

        ChristmasTree(int numLevels, String rowFiller) {
            this.treeElements = new ChristmasTreeElement[numLevels];
            for (int level = 0; level < numLevels; level++) {
                this.treeElements[level] = new ChristmasTreeElement(rowFiller);
            }
            this.setRowFiller(rowFiller);
            this.setNumLevels(numLevels);
        }

    }
}
