import javafx.scene.control.Button;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

// Controller class for Scene1.fxml
public class Scene1Controller {

    // Define FXML components that are used in the Scene1.fxml
    @FXML private Button exitButton;
    @FXML private TextField tfName;
    @FXML private TextField tfHome;
    @FXML private TextField tfPowers;
    @FXML private RadioButton rbSuper;
    @FXML private ToggleGroup tg1;
    @FXML private RadioButton rbCitizen;
    @FXML private RadioButton rbHero;
    @FXML private ToggleGroup tg2;
    @FXML private RadioButton rbVillain;
    @FXML private RadioButton rbMarvel;
    @FXML private ToggleGroup tg3;
    @FXML private RadioButton rbDC;
    @FXML private Label lblIntelligence;
    @FXML private Label rbStrength;
    @FXML private Label lblStamina;
    @FXML private Label lblSpeed;
    @FXML private Label lblSkills;
    @FXML private Slider sliderIntelligence;
    @FXML private Slider sliderStrength;
    @FXML private Slider sliderStamina;
    @FXML private Slider sliderSpeed;
    @FXML private Slider sliderSkills;

    // Method to initialize values and set up listeners
    @FXML
    public void initialize() {
        // Listeners for slider changes to update labels dynamically
        sliderIntelligence.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblIntelligence.setText(String.valueOf(newValue.intValue()));
        });
        sliderStrength.valueProperty().addListener((observable, oldValue, newValue) -> {
            rbStrength.setText(String.valueOf(newValue.intValue())); // This should likely be a Label, not rbStrength
        });
        sliderStamina.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblStamina.setText(String.valueOf(newValue.intValue()));
        });
        sliderSpeed.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblSpeed.setText(String.valueOf(newValue.intValue()));
        });
        sliderSkills.valueProperty().addListener((observable, oldValue, newValue) -> {
            lblSkills.setText(String.valueOf(newValue.intValue()));
        });
    }

    // Handler for the search action to load another scene
    @FXML
    private void actionOnSearch(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
        stage.show();
    }

    // Handler for adding a new fighter with form validation
    @FXML
    private void actionOnAdd(ActionEvent event) {
        // Validate fields and show error if any field is empty
        if (tfName.getText().isEmpty() || tfHome.getText().isEmpty() || tfPowers.getText().isEmpty()) {
            Utils.showError("Add Fighter", "Please fill in all fields!");
        } else {
            // Construct fighter information from form data
            String type = rbSuper.isSelected() ? "Super" : "Citizen";
            String name = tfName.getText();
            String heroVillain = rbHero.isSelected() ? "Hero" : (rbVillain.isSelected() ? "Villain" : "Undefined");
            String universe = rbMarvel.isSelected() ? "Marvel" : "DC";
            String home = tfHome.getText();
            String powers = tfPowers.getText();
            int intelligence = (int) sliderIntelligence.getValue();
            int strength = (int) sliderStrength.getValue();
            int stamina = (int) sliderStamina.getValue();
            int speed = (int) sliderSpeed.getValue();
            int skills = (int) sliderSkills.getValue();

            // Check if the fighter already exists
            if (Utils.isExist(name)) {
                Utils.showError("Add Fighter", "Fighter " + name + " already exists!");
            } else {
                // Create a new Fighter object and add to the list
                Fighter fighter = new Fighter(type, name, heroVillain, universe, home, powers, intelligence, strength, stamina, speed, skills);
                Utils.fighters.add(fighter);
                Utils.showInfo("Add Fighter", "Successfully added!");
                clearFields(); // Clear the form fields after adding
            }
        }
    }

    // Handler for the exit button that shows a confirmation dialog
    @FXML
    private void actionOnExit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Utils.showInfo("Exit", "You successfully logged out");
            System.exit(0); // Terminate application
        }
    }

    // Utility method to clear all input fields and reset form state
    private void clearFields() {
        tfName.clear();
        tfHome.clear();
        tfPowers.clear();
        tg1.selectToggle(rbSuper);
        tg2.selectToggle(rbHero);
        tg3.selectToggle(rbMarvel);
        sliderIntelligence.setValue(1.0);
        sliderStrength.setValue(1.0);
        sliderStamina.setValue(1.0);
        sliderSpeed.setValue(1.0);
        sliderSkills.setValue(1.0);
    }

} // End of class