package JavaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

import static java.lang.System.out;

public class FXstart extends Application {
    @Override
    public void start(Stage stage)  {
        try {
            Parent node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("fxfile.fxml")));
            Scene scene = new Scene(node);
            stage.setTitle("No Panel");

            //Image TestPIC = new Image("image.jpg");
            //stage.getIcons().add(TestPIC);

            Group root = new Group();
            root.getChildren().add(root);// Add Node here (like text , Button, textfield etc
            stage.setScene(scene);
            stage.setResizable(false);
            out.println(stage.getOutputScaleX());
            stage.show();
        } catch (Exception e) {
            out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
