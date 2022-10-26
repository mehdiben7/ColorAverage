package ca.qc.mehdibenouhoud.coloraverage;

import javafx.beans.property.*;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;


public class ColorAverageModel {

    public Color getAverageColor(Image image) {
        return getAverageColor(getColors(image));
    }

    private Color getAverageColor(Color[] colors) {
        double r  = 0, g = 0, b = 0;
        int nbColors = colors.length;

        for(Color color: colors) {
            r += color.getRed();
            g += color.getGreen();
            b += color.getBlue();
        }

        return new Color(r/nbColors, g/nbColors, b/nbColors, 1);
    }

    private Color[] getColors(Image image) {
        ArrayList<Color> colors = new ArrayList<>();
        PixelReader pixelReader = image.getPixelReader();

        for(int i = 0; i < image.getWidth(); i++) {
            for(int j = 0; j < image.getHeight(); j++) {
                colors.add(pixelReader.getColor(i, j));
            }
        }

        return colors.toArray(new Color[0]); // TODO Check if conversion does not make it go away
    }

    private String getColorName(Color c) {
        if (c.getBrightness() < 0.2) {
            return "Black";
        } else if (c.getHue() < 30) {
            return "Red";
        } else if (c.getHue() < 90) {
            return "Yellow";
        } else if (c.getHue() < 150) {
            return "Green";
        } else if (c.getHue() < 210) {
            return "Cyan";
        } else if (c.getHue() < 270) {
            return "Blue";
        } else if (c.getHue() < 330) {
            return "Magenta";
        } else {
            return "Red";
        }
    }



    public Property<Image> imageProperty = new SimpleObjectProperty<>();
    public StringProperty imagePathProperty = new SimpleStringProperty();
    public Property<Paint> colorFillProperty = new SimpleObjectProperty<>();

    public Property<Color> colorProperty = new SimpleObjectProperty<>();
    public StringProperty rgbColorLabel = new SimpleStringProperty();
    public StringProperty hsvColorLabel = new SimpleStringProperty();
    public StringProperty hexColorLabel = new SimpleStringProperty();
    public StringProperty colorNameProperty = new SimpleStringProperty("RED");
    public StringProperty importChangeImageButtonLabel = new SimpleStringProperty("Import image");

    public BooleanProperty firstImageImported = new SimpleBooleanProperty(false);

    public ColorAverageModel() {

        this.firstImageImported.addListener((observableValue, oldValue, newValue) -> {
            String newButtonLabel = newValue ? "Change image" : "Import image";
            importChangeImageButtonLabel.set(newButtonLabel);
        });

        this.imageProperty.addListener((observableValue, image, newImage) -> colorProperty.setValue(getAverageColor(newImage)));

        this.colorProperty.addListener((observableValue, color, newColor) -> {
            colorFillProperty.setValue(newColor);
            //Assign a variable for each value of newColor rgb and round it to 2 decimals, and multiply them by 255
            int r = (int) Math.round(newColor.getRed() * 255);
            int g = (int) Math.round(newColor.getGreen() * 255);
            int b = (int) Math.round(newColor.getBlue() * 255);
            // set rgbColorLabel to the value of r, g, b
            // Use this format RGB(r, g, b)
            rgbColorLabel.set("RGB(" + r + ", " + g + ", " + b + ")");
            //Assign a variable for each value of newColor hsv and round it to 2 decimals
            int h = (int) Math.round(newColor.getHue());
            double s = Math.round(newColor.getSaturation());
            double v = Math.round(newColor.getBrightness());
            // set hsvColorLabel to the value of h, s, v
            // Use this format HSV(h, s, v)
            hsvColorLabel.set("HSV(" + h + ", " + s + ", " + v + ")");

            // Set the hex color label to the hex value of the color
            hexColorLabel.set("Hex: " + String.format("#%02X%02X%02X", (int)(newColor.getRed() * 255), (int)(newColor.getGreen() * 255), (int)(newColor.getBlue() * 255)));
            colorNameProperty.set(getColorName(newColor));
        });
    }
}
