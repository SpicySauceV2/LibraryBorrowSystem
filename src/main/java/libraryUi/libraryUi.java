package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class libraryUi extends Application {

    private Library library = new Library(); // HashMap-based library
    private TableView<LibraryItems> table = new TableView<>();
    private ObservableList<LibraryItems> data = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
        // ===== Create sample items =====
        Book book1 = new Book("B001", "Java Programming", false, 14, "John Smith");
        Book book2 = new Book("B002", "Data Structures", false, 14, "Jane Doe");
        Dvd dvd1 = new Dvd("D001", "Inception", false, 7, "Christopher Nolan", 148, "Sci-Fi");
        Dvd dvd2 = new Dvd("D002", "The Matrix", false, 7, "The Wachowskis", 136, "Sci-Fi");

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(dvd1);
        library.addItem(dvd2);

        data.addAll(book1, book2, dvd1, dvd2);

        // ===== Table Columns =====
        TableColumn<LibraryItems, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getId()));

        TableColumn<LibraryItems, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(cell.getValue().getTitle()));

        TableColumn<LibraryItems, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(cell -> {
            if (cell.getValue() instanceof Book)
                return new javafx.beans.property.SimpleStringProperty("Book");
            else
                return new javafx.beans.property.SimpleStringProperty("DVD");
        });

        TableColumn<LibraryItems, String> borrowedCol = new TableColumn<>("Borrowed");
        borrowedCol.setCellValueFactory(cell -> new javafx.beans.property.SimpleStringProperty(
                String.valueOf(cell.getValue().isBorrowed())));

        table.getColumns().addAll(idCol, titleCol, typeCol, borrowedCol);
        table.setItems(data);

        // ===== Buttons for Borrow / Return =====
        Button borrowBtn = new Button("Borrow Selected");
        Button returnBtn = new Button("Return Selected");

        borrowBtn.setOnAction(e -> {
            LibraryItems selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                if (!selected.isBorrowed()) {
                    selected.setBorrowed(true);
                    table.refresh();
                } else {
                    showAlert("Item is already borrowed!");
                }
            } else {
                showAlert("Select an item first!");
            }
        });

        returnBtn.setOnAction(e -> {
            LibraryItems selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                if (selected.isBorrowed()) {
                    selected.setBorrowed(false);
                    table.refresh();
                } else {
                    showAlert("Item is not borrowed!");
                }
            } else {
                showAlert("Select an item first!");
            }
        });

        HBox buttonBox = new HBox(10, borrowBtn, returnBtn);

        // ===== Layout =====
        VBox root = new VBox(20, table, buttonBox);
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}