import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class M05Assignment3 extends Application {

    private Text text = new Text("Show Colors");

    public void start(Stage primaryStage) {
        // creation of the sliders
        Slider redSlider = createSlider();
        Slider greenSlider = createSlider();
        Slider blueSlider = createSlider();
        Slider opacitySlider = createSlider();
        opacitySlider.setMax(1.0);
        opacitySlider.setValue(1.0);

        // set up of the labels and layout
        GridPane sliderPane = new GridPane();
        sliderPane.setAlignment(Pos.CENTER);
        sliderPane.setHgap(10);
        sliderPane.setVgap(10);
        sliderPane.setPadding(new Insets(10));

        sliderPane.add(new Label("Red"), 0, 0);
        sliderPane.add(redSlider, 1, 0);
        sliderPane.add(new Label("Green"), 0, 1);
        sliderPane.add(greenSlider, 1, 1);
        sliderPane.add(new Label("Blue"), 0, 2);
        sliderPane.add(blueSlider, 1, 2);
        sliderPane.add(new Label("Opacity"), 0, 3);
        sliderPane.add(opacitySlider, 1, 3);

        // VBox layout
        VBox root = new VBox(20, text, sliderPane);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // bind the slider values to text color
        ChangeListener<Number> colorUpdater = (obs, oldVal, newVal) -> {
            updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider);
        };

        redSlider.valueProperty().addListener(colorUpdater);
        greenSlider.valueProperty().addListener(colorUpdater);
        blueSlider.valueProperty().addListener(colorUpdater);
        opacitySlider.valueProperty().addListener(colorUpdater);

        // initial color
        updateTextColor(text, redSlider, greenSlider, blueSlider, opacitySlider);

        // setting up the stage
        Scene scene = new Scene(root, 400, 250);
        primaryStage.setTitle("M05Assignment3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Slider createSlider() {
        Slider slider = new Slider(0, 255, 0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(85);
        return slider;
    }

    private void updateTextColor(Text text, Slider r, Slider g, Slider b, Slider o) {
        text.setFill(Color.rgb(
            (int) r.getValue(),
            (int) g.getValue(),
            (int) b.getValue(),
            o.getValue()
        ));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
