package course.idf;

public class Model {
    static class Triangle {
        public String[] builtTriangle;
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
        int maxTreeWidth;

        public void updateRowFiller(String rowFiller) {
            for (int level = 0; level < numLevels; level++) {
                this.treeElements[level].rowFiller = rowFiller;
                this.treeElements[level].firstTriangle.rowFiller = rowFiller;
                this.treeElements[level].secondTriangle.rowFiller = rowFiller;
            }
        }

        private void updateTreeMaxWidth(int maxTreeWidth) {
            for (int level = 0; level < this.numLevels; level++) {
                this.treeElements[level].maxTreeWidth = maxTreeWidth - level;
                this.treeElements[level].firstTriangle.maxWidth = maxTreeWidth - level;
                this.treeElements[level].secondTriangle.maxWidth = maxTreeWidth - level;
            }
        }

        public void updateNumLevelsPadding(int numLevels) {
            for (int level = 0; level < numLevels; level++) {
                this.treeElements[level].padding = this.maxTreeWidth - this.treeElements[level].maxTreeWidth;
            }
        }

        ChristmasTree(int numLevels, String rowFiller, int maxTreeWidth) {
            this.treeElements = new ChristmasTreeElement[numLevels];
            this.maxTreeWidth = maxTreeWidth;
            this.numLevels = numLevels;
            this.rowFiller = rowFiller;
            for (int level = 0; level < numLevels; level++) {
                this.treeElements[level] = new ChristmasTreeElement(rowFiller);
            }
            this.updateRowFiller(rowFiller);
            this.updateTreeMaxWidth(maxTreeWidth);
            this.updateNumLevelsPadding(numLevels);
        }
    }
}
