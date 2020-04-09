package course.idf;

public class View {
    void displayTriangle(String[] prebuiltTriangle) {
        System.out.println(String.join("\n", prebuiltTriangle));
    }

    void displayTriangle(Model.Triangle prebuiltTriangleModel) {
        System.out.println(String.join("\n", prebuiltTriangleModel.builtTrangle));
    }

    void displayDoubleTriangles(String[] prebuiltTriangle1, String[] prebuiltTriangle2) {
        System.out.print(String.join("\n", prebuiltTriangle1));
        System.out.println(String.join("\n", prebuiltTriangle2));
    }

    void displayDoubleTriangles(Model.DoubleTriangle prebuiltDoubleTriangles) {
        for (int layer = 0; layer < prebuiltDoubleTriangles.firstTriangle.builtTrangle.length - 1; layer++) {
            System.out.println(prebuiltDoubleTriangles.firstTriangle.builtTrangle[layer]);
        }
        System.out.println(String.join("\n", prebuiltDoubleTriangles.secondTriangle.builtTrangle));
    }

}
