package ca.qc.mehdibenouhoud.coloraverage.view;

import ca.qc.mehdibenouhoud.coloraverage.ColorAverageModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

public class ColorView extends VBox {

    private final ColorAverageModel model;

    private Rectangle colorSquare() {
        Rectangle colorSquare = new Rectangle();
        colorSquare.fillProperty().bind(model.colorFillProperty);
//        colorSquare.setFill(Color.RED);
        colorSquare.setWidth(20);
        colorSquare.setHeight(20);
        return colorSquare;
    }

    private Label rgbLabel() {
        // Creates a label and bind its text to the model's colorRGBProperty
        Label rgbLabel = new Label();
        rgbLabel.textProperty().bind(model.rgbColorLabel);
        return rgbLabel;
    }

    private Label hsvLabel() {
        // Creates a label and bind its text to the model's hsvColorLabel
        Label hsvLabel = new Label();
        hsvLabel.textProperty().bind(model.hsvColorLabel);
        return hsvLabel;
    }

    private Label hexLabel() {
        // Creates a label and bind its text to the model's hexColorLabel
        Label hexLabel = new Label();
        hexLabel.textProperty().bind(model.hexColorLabel);
        return hexLabel;
    }

    private VBox colorDescription() {
        VBox vBox = new VBox(rgbLabel(), hsvLabel(), hexLabel());
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.setSpacing(10);

        return vBox;
    }

    private HBox colorPreviewView() {
        HBox hBox = new HBox(colorSquare(), colorDescription());
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(5);
        return hBox;
    }

    private Label thisColorIsLabel() {
        return new Label("This image is: ");
    }

    private Label colorLabel() {
        Label l = new Label("placeholder");
        l.textProperty().bind(model.colorNameProperty);
        l.textFillProperty().bind(model.colorFillProperty);


        return l;
    }

    private VBox thisColorIs() {
        VBox vBox = new VBox(thisColorIsLabel(), colorLabel());
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        return vBox;
    }


    public ColorView(ColorAverageModel model) {
        this.model = model;
        this.getChildren().addAll(colorPreviewView(), thisColorIs());
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);

    }
}
