package ca.qc.mehdibenouhoud.coloraverage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

public class ColorAverageController {

    private final ColorAverageModel model;


    public EventHandler<ActionEvent> getOnImportChangeButtonAction(Window stage) {
        return actionEvent -> {
            System.out.println("Button pressed");
            if(!model.firstImageImported.get()) model.firstImageImported.set(true);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Import an image");
            FileChooser.ExtensionFilter imagesExtensionFilter = new FileChooser.ExtensionFilter("Images (.jpg, .jpeg, .png, .gif)", "*.jpg", "*.png", "*.jpeg", "*.gif");
            fileChooser.getExtensionFilters().add(imagesExtensionFilter);
            File imageFile = fileChooser.showOpenDialog(stage);
            model.imagePathProperty.set(imageFile.toURI().toString());
            Image image = new Image(imageFile.toURI().toString());
            model.imageProperty.setValue(image);

        };
    }

    public ColorAverageController(ColorAverageModel model) {
        this.model = model;
    }
}
