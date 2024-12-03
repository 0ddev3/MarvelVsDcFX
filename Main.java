/*
 Name: Yvette Boyd
 Date: 4/28/2024
 Email: myyvette17@gmail.com
 Course: 2280-001
 Title: Program 5
*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

// Main class that extends from Application, which is the base class for JavaFX applications
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file for the initial scene and create the scene
            Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);  // Set the scene on the stage
            stage.show();           // Show the stage with the loaded scene

            // Set up a handler that intercepts the window close request
            stage.setOnCloseRequest(event -> {
                event.consume();   // Consume the event to prevent default behavior
                logout(stage);     // Call the logout method when the window is trying to close
            });

        } catch (Exception e) {
            e.printStackTrace();   // Print stack trace if an exception occurs during the loading of the FXML
        }
    }

    // Method that shows a confirmation dialog when the user tries to close the application
    public void logout(Stage stage) {
        // Create a confirmation alert asking if the user wants to save before logging out
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        // Display the alert and wait for the user to click a button
        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully logged out");
            stage.close();  // Close the stage if the user confirms
        }
    }

    // Main method that launches the application
    public static void main(String[] args) {
        launch(args);
    }

} // End of class