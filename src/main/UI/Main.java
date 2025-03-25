package main.UI;

import javafx.scene.control.cell.PropertyValueFactory;
import main.Raumschiffe.Jaeger;
import main.Raumschiffe.Kreuzer;
import main.Raumschiffe.Raumschiff;
import main.Raumschiffe.Schlachtschiff;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.standard.Flotte;
import main.standard.GameMaster;
import main.standard.Spieler;
import main.utilities.Printer;
import main.utilities.UI_Utilities;


public class Main extends Application {


    public void start(Stage stage) {
        nameWindow(stage);

    }


    public static void main(String[] args) {
        launch();
    }

    public static void nameWindow(Stage stage) {
        stage.setTitle("FlottenManager");

        GridPane gridpane = new GridPane();


        gridpane.setPadding(new Insets(10, 10, 10, 10));

        gridpane.setVgap(5);
        gridpane.setHgap(5);

        Label welcomeLabel = new Label("Welcome to Flotten Manager");
        Label enterName = new Label("Enter Name");
        Button button = new Button("Exit");
        TextField textField = new TextField();

        gridpane.add(welcomeLabel, 1, 0);
        gridpane.add(enterName, 1, 1);
        gridpane.add(button, 0, 0);
        gridpane.add(textField, 1, 2);


        Scene scene = new Scene(gridpane, 300, 200);

        stage.setScene(scene);

        stage.show();

        textField.setOnAction(e -> {
            String textFieldText = textField.getText();
            Printer.print(textFieldText);
            Spieler.create().setName(textFieldText);
            menuWindow(stage);
        });

        button.setOnAction(e -> stage.close());
    }


    public static void menuWindow(Stage stage) {

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 500, 350);
        stage.setScene(scene);

        ListView<String> listView = new ListView<>();

        listView.setStyle("-fx-font-size: 24px; " +
                "-fx-text-fill: #000000; ");

        listView.getItems().add("Buy a new ship");
        listView.getItems().add("Remove a ship");
        listView.getItems().add("Show all current ships");
        listView.getItems().add("Do a checkup on a ship");
        listView.getItems().add("Modify a ship");
        listView.getItems().add("Show available enemies");
        listView.getItems().add("Simulate attack");

        borderPane.setCenter(listView);

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int index = listView.getSelectionModel().getSelectedIndex() + 1;
            switch (index) {
                case 1:
                    //coming_soon_window(stage);
                    buyShip(stage);
                    //buyShip();
                    break;
                case 2:
                    //coming_soon_window(stage);
                    removeShip(stage);
                    break;
                case 3:
                    UI_Utilities.showShips(stage,Flotte.getInstance().getSchiffe());
                    //Flotte.getInstance().showFlotte();
                    break;
                case 4:
                   // coming_soon_window(stage);
                     checkup(stage);
                    break;
                case 5:
                    coming_soon_window(stage);
                    //  modify();
                    break;
                case 6:
                    coming_soon_window(stage);
                    //  attackEnemy();
                    break;
                case 7:
                    //  simulate_attack();
                    coming_soon_window(stage);
                    break;
                case 8:
                    System.exit(0);

            }
        });


    }



    public static void coming_soon_window(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Label comingSoon = new Label("Coming Soon");

        comingSoon.setStyle("-fx-font-size: 24px; " +
                "-fx-text-fill: #000000; ");

        HBox hbox = new HBox(comingSoon);
        hbox.setAlignment(Pos.CENTER);


        Button button = new Button("Get Back");
        borderPane.setTop(hbox);
        borderPane.setCenter(button);

        Scene scene = new Scene(borderPane, 500, 350);
        stage.setScene(scene);
        button.setOnAction(e -> menuWindow(stage));


    }

    public static void buyShip(Stage stage) {

        ObservableList<String[]> angebot = FXCollections.observableArrayList(
                new String[]{"Jaeger", "250","1000","150"},
                new String[]{"Kreuzer", "1000","500","150"},
                new String[]{"Schlachtschiff", "1000","1000","300"}
        );


        TableView<String[]> tableView = new TableView<>();

        // Spalten definieren
        TableColumn<String[], String> NameC = new TableColumn<String[], String>("Name");
        TableColumn<String[], String> shieldPowerC = new TableColumn<String[], String>("ShieldPower");
        TableColumn<String[], String> attackPowerC = new TableColumn<String[], String>("AttackPower");
        TableColumn<String[], String> priceC = new TableColumn<String[], String>("Price");

        // Spalte implmentieren
        NameC.setCellValueFactory(cellData -> {
            String inhalt = cellData.getValue()[0];
            return new SimpleStringProperty(inhalt);
        });
        shieldPowerC.setCellValueFactory(cellData -> {
            String inhalt = cellData.getValue()[1];
            return new SimpleStringProperty(inhalt);
        });


        attackPowerC.setCellValueFactory(cellData -> {
            String inhalt = cellData.getValue()[2];
            return new SimpleStringProperty(inhalt);
        });
        priceC.setCellValueFactory(cellData -> {
            String inhalt = cellData.getValue()[3];
            return new SimpleStringProperty(inhalt);
        });

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.getColumns().addAll(NameC, shieldPowerC, attackPowerC, priceC);
        tableView.setItems(angebot);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(tableView);
        Scene scene = new Scene(borderPane, 800, 350);
        stage.setScene(scene);



        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int index = tableView.getSelectionModel().getSelectedIndex() +1;

            switch (index) {
                case 1:
                    if (Spieler.create().credits > 150) {
                        Spieler.create().credits = Spieler.create().credits - 150;
                        Flotte.getInstance().addSchiff(new Jaeger("Jaeger"));
                        menuWindow(stage);
                        break;
                    } else {
                        UI_Utilities.messageWindow(stage,"you have not enough credits");

                        break;
                    }

                case 2:
                    if (Spieler.create().credits > 150) {
                        Spieler.create().credits = Spieler.create().credits - 150;
                        Flotte.getInstance().addSchiff(new Kreuzer("Kreuzer"));
                        menuWindow(stage);
                        break;
                    } else {
                        UI_Utilities.messageWindow(stage,"you have not enough credits");

                        break;
                    }

                case 3:
                    if (Spieler.create().credits > 300) {
                        Spieler.create().credits = Spieler.create().credits - 300;
                        Flotte.getInstance().addSchiff(new Schlachtschiff("Schlachtschiff"));
                        menuWindow(stage);
                        break;
                    } else {
                        UI_Utilities.messageWindow(stage,"you have not enough credits");

                        break;
                    }

            }

        });

    }


    public static void removeShip(Stage stage) {

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
        tableView.getItems().addAll(Flotte.getInstance().getSchiffe());
        borderPane.setTop(menuButton);
        borderPane.setCenter(tableView);
        stage.setScene(scene);


        menuButton.setOnAction(e -> main.UI.Main.menuWindow(stage));

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            GameMaster.removeShip(index);
            main.UI.Main.menuWindow(stage);

        });

    }


    public static void checkup(Stage stage) {

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
        tableView.getItems().addAll(Flotte.getInstance().getSchiffe());
        borderPane.setTop(menuButton);
        borderPane.setCenter(tableView);
        stage.setScene(scene);


        menuButton.setOnAction(e -> main.UI.Main.menuWindow(stage));

        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int index = tableView.getSelectionModel().getSelectedIndex();
            GameMaster.checkup(index);
            main.UI.Main.menuWindow(stage);

        });

    }

}
