package utilities;

import Raumschiffe.Raumschiff;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import standard.Flotte;

import java.util.Vector;

public class UI_Utilities {

    public static void showShips(Stage stage, Vector<Raumschiff> schiffe) {
    BorderPane borderPane = new BorderPane();
    Scene scene = new Scene(borderPane, 800, 350);

    Button menuButton = new Button("Back to Menu");

    // Erstellung einer TableView mit Raumschiff als Typ, weil TableView ein generic hat.
    TableView<Raumschiff> tableView = new TableView<Raumschiff>();
    //Definieren der Ersten spalte, der erste Generic input ist der Datentype des input objekts, der Zweite Generic input ist der anzuzeigende datentyp.
    TableColumn<Raumschiff, String> NameC = new TableColumn<Raumschiff, String>("Name");
    TableColumn<Raumschiff, Integer> shieldPowerC = new TableColumn<Raumschiff, Integer>("ShieldPower");
    TableColumn<Raumschiff, Integer> oShieldPowerC = new TableColumn<Raumschiff, Integer>("Max ShieldPower");
    TableColumn<Raumschiff, Integer> attackPowerC = new TableColumn<Raumschiff, Integer>("AttackPower");
    TableColumn<Raumschiff, Integer> priceC = new TableColumn<Raumschiff, Integer>("Price");

    //Implementieren der Ersten spalte bzw füllen. dafür wird eine get Methode verwendet. vom Input der PropertyValueFactory wird ein methoden aufruf gemacht.
    // Bei dem Methodenaufruf wird der Inhalt des strings verwendet von dem der erste buchstabe groß gemacht wird und dann get davor geschrieben wird.
    // in diesem Fall wird getName aufgerufen.
    // Wichtig!!! die Getter Methoden müssen definiert werden
    NameC.setCellValueFactory(new PropertyValueFactory<>("name"));
    shieldPowerC.setCellValueFactory(new PropertyValueFactory<>("shieldPower"));
    oShieldPowerC.setCellValueFactory(new PropertyValueFactory<>("oShieldPower"));
    attackPowerC.setCellValueFactory(new PropertyValueFactory<>("attackPower"));
    priceC.setCellValueFactory(new PropertyValueFactory<>("price"));


    //Spalten werden zur Tabelle hinzugefügt.
    tableView.getColumns().add(NameC);
    tableView.getColumns().add(shieldPowerC);
    tableView.getColumns().add(oShieldPowerC);
    tableView.getColumns().add(attackPowerC);
    tableView.getColumns().add(priceC);

// Es werden nur so viele spalten angezeigt wie hinzugefügt werden, normalerweise wir immer eine leere angezeigt.
    tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    // Style tableView
    tableView.setStyle("-fx-font-size: 24px; " +
            "-fx-text-fill: #000000; ");

    //Add Data to tableView
    tableView.getItems().addAll(schiffe);
    borderPane.setTop(menuButton);
    borderPane.setCenter(tableView);
    stage.setScene(scene);


        menuButton.setOnAction(e -> UI.Main.menuWindow(stage));

}




public static void messageWindow(Stage stage, String message) {

    BorderPane borderpane = new BorderPane();
        Label label = new Label(message);
        label.setStyle("-fx-font-size: 24px;");
        borderpane.setCenter(label);
    Button menuB = new Button("Back to Menu");
    borderpane.setTop(menuB);
        Scene scene = new Scene(borderpane, 400, 300);
        stage.setScene(scene);
        menuB.setOnAction(event -> {
            UI.Main.menuWindow(stage);
        });



}


}
