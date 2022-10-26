package ca.qc.mehdibenouhoud.coloraverage;

import ca.qc.mehdibenouhoud.coloraverage.view.ColorAverageView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorAverage extends Application {
    @Override
    public void start(Stage stage) {
        ColorAverageModel colorAverageModel = new ColorAverageModel();
        ColorAverageController colorAverageController = new ColorAverageController(colorAverageModel);
        ColorAverageView p = new ColorAverageView(colorAverageModel, colorAverageController, stage);
        Scene scene = new Scene(p, 600, 350);
//        stage.setResizable(false);
        stage.setTitle("ColorAverage");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }


}
