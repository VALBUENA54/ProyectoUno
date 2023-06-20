package juego.Controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TeoriaController {
    @FXML
    private Text puntosText;
    
    private int puntos = 0;

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
    private ToggleGroup grupo1;

    @FXML
    private ToggleGroup grupo2;

    @FXML
    private Button siguienteButton;

    @FXML
    private Button btnSwitchWindow6;
    
    

   @FXML
private void siguienteButtonClicked(ActionEvent event) {
    // Verificar las respuestas seleccionadas
    verificarRespuestas();

    // Continuar con la lógica para avanzar al siguiente paso del juego
}

private void verificarRespuestas() {
    int puntos = 0;

    // Verificar el grupo de preguntas 1
    RadioButton seleccion1 = (RadioButton) grupo1.getSelectedToggle();
    if (seleccion1 != null) {
        String respuestaSeleccionada1 = seleccion1.getText();
        if (respuestaSeleccionada1.equals("btn2")) {
            // La respuesta es correcta
            puntos += 1;
        }
    }

    // Verificar el grupo de preguntas 2
    RadioButton seleccion2 = (RadioButton) grupo2.getSelectedToggle();
    if (seleccion2 != null) {
        String respuestaSeleccionada2 = seleccion2.getText();
        if (respuestaSeleccionada2.equals("btn5")) {
            // La respuesta es correcta
            puntos += 1;
        }
    }

    // Actualizar los puntos acumulados
    this.puntos = puntos;
    puntosText.setText(Integer.toString(puntos));
}

    @FXML
    private void initialize() {
        siguienteButton.setDisable(true);

        grupo1.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            siguienteButton.setDisable(false);
        });

        grupo2.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            siguienteButton.setDisable(false);
        });
    }
    
    @FXML
    private void SwitchWindow6(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Categorias.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            CategoriasController categoriasController = loader.getController();

            // Pasar los puntos acumulados al controlador de la nueva ventana
            categoriasController.setPuntos(puntos);

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnSwitchWindow6.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

