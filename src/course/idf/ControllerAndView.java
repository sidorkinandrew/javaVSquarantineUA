package course.idf;

public class ControllerAndView {
    public static void main(String[] args) {
        View taskView = new View();
        Controller taskController = new Controller();
/*      Model.Triangle task1Model = new Model.Triangle();
        for (task1Model.mode = 1; task1Model.mode < 5; task1Model.mode++) {
            taskController.buildTriangle(task1Model);
            taskView.displayTriangle(task1Model);
        }
        Model.DoubleTriangle task2Model = new Model.DoubleTriangle();
        int[][] task2modes = {{1, 1, 4, 4}, {2, 3, 3, 2}};
        for (int current_mode = 0; current_mode < task2modes[0].length; current_mode++) {
            task2Model.firstTriangle.mode = task2modes[0][current_mode];
            task2Model.secondTriangle.mode = task2modes[1][current_mode];
            taskController.buildDoubleTriangles(task2Model);
            taskView.displayDoubleTriangles(task2Model);
        }*/
        Model.ChristmasTree newYearTree = new Model.ChristmasTree(5, "*");
        taskController.buildChristmasTree(newYearTree);
        taskView.displayChristmasTree(newYearTree);
    }
}
