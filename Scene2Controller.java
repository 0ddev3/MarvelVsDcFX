import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

// Controller class for Scene2.fxml
public class Scene2Controller {

    // FXML annotation to inject the TextField component from the FXML file
    @FXML
    private TextField tfName;

    // Handler for the search button click event
    @FXML
    private void actionOnSearch(ActionEvent event) {
        // Check if the text field is empty and show an error if it is
        if (tfName.getText().isEmpty()) {
            Utils.showError("Search Fighter", "Please enter name!");
        } else {
            // Get the name entered in the text field
            String name = tfName.getText();
            Fighter searchedFighter = null;
            // Search for a fighter with the specified name in the list
            for (Fighter fighter : Utils.fighters) {
                if (fighter.getName().equalsIgnoreCase(name)) {
                    searchedFighter = fighter;
                    break;
                }
            }
            // Show message depending on whether the fighter was found or not
            if (searchedFighter == null) {
                Utils.showError("Search Fighter", "No fighter found!");
            } else {
                // Display the details of the found fighter
                Utils.showInfo("Search Fighter", searchedFighter.toString());
            }
        }
    }

    // Handler for the back button to navigate back to the previous scene
    @FXML
    private void actionOnBack(ActionEvent event) throws IOException {
        // Load the Scene1.fxml file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
        // Get the current stage from the action event
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create a new scene with the loaded layout and set it to the stage
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show(); // Display the stage with the new scene
    }

} // End of class