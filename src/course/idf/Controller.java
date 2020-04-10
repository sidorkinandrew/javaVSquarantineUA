package course.idf;

public class Controller {
    void buildChristmasTree(Model.ChristmasTree christmasTree){
        for (Model.ChristmasTreeElement treeElement: christmasTree.treeElements) {
            buildChristmasTreeElement(treeElement);
        }
    }
    void buildChristmasTreeElement(Model.ChristmasTreeElement treeElement){
        treeElement.firstTriangle.rowFiller = treeElement.rowFiller;
        treeElement.secondTriangle.rowFiller = treeElement.rowFiller;
        buildTriangle(treeElement.firstTriangle);
        buildTriangle(treeElement.secondTriangle);
    }

    void buildDoubleTriangles(Model.DoubleTriangle modelData) {
        modelData.firstTriangle.builtTrangle = buildTriangle(modelData.firstTriangle.mode,
                modelData.firstTriangle.maxWidth, modelData.firstTriangle.rowFiller);
        modelData.secondTriangle.builtTrangle = buildTriangle(modelData.secondTriangle.mode,
                modelData.secondTriangle.maxWidth, modelData.secondTriangle.rowFiller);

    }

    void buildTriangle(Model.Triangle modelData) {
        modelData.builtTrangle = buildTriangle(modelData.mode, modelData.maxWidth, modelData.rowFiller);
    }

    String[] buildTriangle(int mode, int maxWidth, String rowFiller) {
        String[] resultString = new String[maxWidth];
        String space = " ";
        for (int i = 0; i < maxWidth; i++)
            if (mode == 1) resultString[i] = rowFiller.repeat(i + 1);  // left-up
            else if (mode == 2)
                resultString[i] = rowFiller.repeat(maxWidth - i) + space.repeat(i); //left-down
            else if (mode == 3)
                resultString[i] = space.repeat(i) + rowFiller.repeat(maxWidth - i); // right-down
            else if (mode == 4)
                resultString[i] = space.repeat(maxWidth - i - 1) + rowFiller.repeat(i + 1); // right-up
        return resultString;
    }
}
