package course.idf;

public class View {
    void displayTriangle(String[] prebuiltTriangle) {
        System.out.println(String.join("\n", prebuiltTriangle));
    }

    void displayTriangle(Model.Triangle prebuiltTriangleModel) {
        System.out.println(String.join("\n", prebuiltTriangleModel.builtTriangle));
    }

    void displayDoubleTriangles(String[] prebuiltTriangle1, String[] prebuiltTriangle2) {
        System.out.print(String.join("\n", prebuiltTriangle1));
        System.out.println(String.join("\n", prebuiltTriangle2));
    }

    void displayDoubleTriangles(Model.DoubleTriangle prebuiltDoubleTriangles) {
        for (int layer = 0; layer < prebuiltDoubleTriangles.firstTriangle.builtTriangle.length - 1; layer++) {
            System.out.println(prebuiltDoubleTriangles.firstTriangle.builtTriangle[layer]);
        }
        System.out.println(String.join("\n", prebuiltDoubleTriangles.secondTriangle.builtTriangle));
    }

    void displayChristmasTreeElement(Model.ChristmasTreeElement treeElement) {
        for (int layer = 0; layer < treeElement.firstTriangle.builtTriangle.length; layer++) {
            int firstTriangleLength = treeElement.firstTriangle.builtTriangle[layer].length();
            System.out.print(" ".repeat(treeElement.padding) + treeElement.firstTriangle.builtTriangle[layer].substring(0, firstTriangleLength - 1));
            System.out.println(treeElement.secondTriangle.builtTriangle[layer]);
        }
    }

    void displayChristmasTree(Model.ChristmasTree christmasTree) {
        for (int level = christmasTree.numLevels - 1; level > -1; level--) {
            displayChristmasTreeElement(christmasTree.treeElements[level]);
        }
    }
    void displayChristmasTreeParameters(Model.ChristmasTree christmasTree){
        System.out.println(christmasTree.numLevels + " " + christmasTree.rowFiller + " " + christmasTree.maxTreeWidth);
        for (Model.ChristmasTreeElement treeElement : christmasTree.treeElements) {
            System.out.println(treeElement.rowFiller + " " + treeElement.padding + " " + treeElement.maxTreeWidth + " " +
                    treeElement.firstTriangle.rowFiller + " " + treeElement.firstTriangle.maxWidth + " " + treeElement.secondTriangle.rowFiller + " " + treeElement.secondTriangle.maxWidth);
        }
    }
}
