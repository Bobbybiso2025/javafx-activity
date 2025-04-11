package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;

import java.util.Optional;

public class TodoController {

    @FXML
    private ListView<String> todoList;

    // Called when the CREATE button is clicked
    @FXML
    private void onCreateClick() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Create Todo");
        dialog.setHeaderText("Add a new To-Do item");
        dialog.setContentText("Enter task:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(task -> {
            if (!task.trim().isEmpty()) {
                todoList.getItems().add(task.trim());
            } else {
                showAlert("Empty Task", "Please enter a valid task.");
            }
        });
    }

    // Called when the DELETE button is clicked
    @FXML
    private void onDeleteClick() {
        String selectedItem = todoList.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            todoList.getItems().remove(selectedItem);
        } else {
            showAlert("No Selection", "Please select an item to delete.");
        }
    }

    // Optional: Called when editing starts on a ListView item
    @FXML
    private void onListEdit(MouseEvent event) {
        // You can implement in-line editing logic here if needed
    }

    // Utility method for showing alerts
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
