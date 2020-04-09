package course.idf;

public class Controller {
    void buildDoubleTriangles(Model.DoubleTriangle modelData) {
        modelData.firstTriangle.builtTrangle = buildTriangle(modelData.firstTriangle.mode,
                modelData.firstTriangle.maxWidth, modelData.firstTriangle.rowFiller);
        modelData.secondTriangle.builtTrangle = buildTriangle(modelData.secondTriangle.mode,
                modelData.secondTriangle.maxWidth, modelData.secondTriangle.rowFiller);

    }

    void buildTriangle(Model.Triangle modelData) {
        modelData.builtTrangle = buildTriangle(modelData.mode, modelData.maxWidth, modelData.rowFiller);
    }

    String buildTriangle(int mode, int maxWidth, String rowFiller) {
        StringBuilder resultString = new StringBuilder();
        String space = " ";
        for (int i = 0; i < maxWidth; i++)
            if (mode == 1) resultString.append(rowFiller.repeat(i + 1) + "\n");  // left-up
            else if (mode == 2)
                resultString.append(rowFiller.repeat(maxWidth - i) + space.repeat(i) + "\n"); //left-down
            else if (mode == 3)
                resultString.append(space.repeat(i) + rowFiller.repeat(maxWidth - i) + "\n"); // right-down
            else if (mode == 4)
                resultString.append(space.repeat(maxWidth - i - 1) + rowFiller.repeat(i + 1) + "\n"); // right-up
        return resultString.toString();
    }
}
