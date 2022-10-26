package ca.qc.mehdibenouhoud.coloraverage.view;

import ca.qc.mehdibenouhoud.coloraverage.ColorAverageController;
import ca.qc.mehdibenouhoud.coloraverage.ColorAverageModel;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImageSelectionView extends VBox {
    private final ColorAverageModel model;
    private final ColorAverageController controller;
    private final Stage stage;

    private ImageView imageView() {
        ImageView imageView = new ImageView();
        imageView.imageProperty().bindBidirectional(model.imageProperty);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);

        return imageView;
    }

    private Label pathLabel() {
        Label l = new Label("Placeholder path text");
        l.setMaxWidth(200);
        l.textProperty().bind(model.imagePathProperty);

        return l;
    }

    private Button importChangeImageButton() {
        Button b = new Button("Import image");
        b.setOnAction(controller.getOnImportChangeButtonAction(stage));
        b.textProperty().bind(model.importChangeImageButtonLabel);
        return b;
    }

    private HBox imageSelectionControlBox() {
        HBox hBox = new HBox(pathLabel(), importChangeImageButton());
        hBox.setAlignment(Pos.BASELINE_CENTER);
        hBox.setSpacing(50);
        return hBox;
    }



    public ImageSelectionView(ColorAverageModel model, ColorAverageController controller, Stage stage) {
        super();
        this.stage = stage;
        this.model = model;
        this.controller = controller;
        this.getChildren().addAll(imageView(), imageSelectionControlBox());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
    }
}
