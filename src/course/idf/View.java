package course.idf;

public class View {
    void displayTriangle(String prebuiltTriangle) {
        System.out.println(prebuiltTriangle);
    }

    void displayTriangle(Model.Triangle prebuiltTriangleModel) {
        System.out.println(prebuiltTriangleModel.builtTrangle);
    }

    void displayDoubleTriangles(String prebuiltTriangle1, String prebuiltTriangle2) {
        System.out.print(prebuiltTriangle1);
        System.out.println(prebuiltTriangle2);
    }

    void displayDoubleTriangles(Model.DoubleTriangle prebuiltDoubleTriangles) {
        int makeFirstTrianglePerfect = prebuiltDoubleTriangles.firstTriangle.builtTrangle.length() - prebuiltDoubleTriangles.firstTriangle.maxWidth - 1;
        System.out.print(prebuiltDoubleTriangles.firstTriangle.builtTrangle.substring(0, makeFirstTrianglePerfect));
        System.out.println(prebuiltDoubleTriangles.secondTriangle.builtTrangle);
    }

}
