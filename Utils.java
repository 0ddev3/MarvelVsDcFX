import java.util.ArrayList;
import javafx.scene.control.Alert;

// Utility class to handle common operations for the application
public class Utils {

    // Static list to store Fighter objects, accessible application-wide
    public static ArrayList<Fighter> fighters = new ArrayList<>();

    // Displays an error message in a dialog box.
    public static void showError(String title, String content) {
        Alert error = new Alert(Alert.AlertType.ERROR); // Creates a new error alert
        error.setTitle(title); // Sets the title of the alert
        error.setContentText(content); // Sets the content of the alert
        error.showAndWait(); // Displays the alert and waits for the user to close it
    }

    // Displays an informational message in a dialog box.
    public static void showInfo(String title, String content) {
        Alert info = new Alert(Alert.AlertType.INFORMATION); // Creates a new information alert
        info.setTitle(title); // Sets the title of the alert
        info.setContentText(content); // Sets the content of the alert
        info.showAndWait(); // Displays the alert and waits for the user to close it
    }

    //Checks if a fighter with the specified name already exists in the list.
    public static boolean isExist(String name) {
        // Loop through the list of fighters
        for (Fighter fighter : fighters) {
            // Check if the name matches (case insensitive)
            if (fighter.getName().equalsIgnoreCase(name)) {
                return true; // Return true if a match is found
            }
        }
        return false; // Return false if no match is found
    }
} // End of class