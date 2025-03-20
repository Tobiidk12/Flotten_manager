package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import standard.GameMaster;

public class Test extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hallo JavaFX!");
        Button button = new Button("Click me!");
        HBox hbox = new HBox();
        hbox.getChildren().addAll(label, button);
        Scene scene = new Scene(hbox, 300, 200);

        stage.setScene(scene);
        stage.setTitle("JavaFX UI.Test");
        stage.show();
        button.setOnAction(event -> stage.close());

    }

    public static void main(String[] args) {
        launch();
    }
}
