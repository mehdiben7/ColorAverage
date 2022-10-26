package ca.qc.mehdibenouhoud.coloraverage.view;

import ca.qc.mehdibenouhoud.coloraverage.ColorAverageController;
import ca.qc.mehdibenouhoud.coloraverage.ColorAverageModel;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ColorAverageView extends BorderPane {


    public ColorAverageView(ColorAverageModel model, ColorAverageController controller, Stage stage) {
        super();
        this.setCenter(new ImageSelectionView(model, controller, stage));
        this.setRight(new ColorView(model));
        this.setPadding(new Insets(20));
    }
}
