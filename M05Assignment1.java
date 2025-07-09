import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.File;

public class M05Assignment1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        // create a GridPane layout
        GridPane pane = new GridPane();

        // Load and display flag images from the local files
        ImageView flag1 = new ImageView(new Image(new File("flag1.gif").toURI().toString()));
        ImageView flag2 = new ImageView(new Image(new File("flag2.gif").toURI().toString()));
        ImageView flag6 = new ImageView(new Image(new File("flag6.gif").toURI().toString()));
        ImageView flag7 = new ImageView(new Image(new File("flag7.gif").toURI().toString()));

        // resize the images 
        flag1.setFitWidth(150); flag1.setFitHeight(100);
        flag2.setFitWidth(150); flag2.setFitHeight(100);
        flag6.setFitWidth(150); flag6.setFitHeight(100);
        flag7.setFitWidth(150); flag7.setFitHeight(100);

        // add flags to the grid in column and row 
        pane.add(flag1, 0, 0); 
        pane.add(flag7, 1, 0); 
        pane.add(flag6, 0, 1); 
        pane.add(flag2, 1, 1); 

        // set up the scene
        Scene scene = new Scene(pane);
        primaryStage.setTitle("M05Assignment1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
