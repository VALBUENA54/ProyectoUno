package juego.Controles;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class CircuitosController {
    @FXML
    private RadioButton btn1;

    @FXML
    private RadioButton btn2;

    @FXML
    private RadioButton btn3;

    @FXML
    private RadioButton btn4;

    @FXML
    private RadioButton btn5;

    @FXML
    private RadioButton btn6;

    @FXML
    private Button btnswitchWindow8;

    @FXML
    private ToggleGroup grupo;

    @FXML
    private ToggleGroup grupo2;
       @FXML
    private Text puntajeText;

    // Método para recibir el puntaje desde el controlador anterior
    public void setPuntaje(int puntaje) {
        puntajeText.setText("Puntaje anterior: " + puntaje);
    }

    @FXML
    void switchWindow8(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Categorias.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnswitchWindow8.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }
