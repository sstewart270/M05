import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class M05Assignment2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // create a circle
        Circle circle = new Circle(150, 150, 75);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        // a pane to hold the circle
        Pane pane = new Pane(circle);

        // set the mouse pressed and released events
        pane.setOnMousePressed(e -> circle.setFill(Color.BLACK));
        pane.setOnMouseReleased(e -> circle.setFill(Color.WHITE));

        // set up the scene and stage
        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("M05Assignment2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
