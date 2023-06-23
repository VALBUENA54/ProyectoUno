package juego.Controles;

import java.io.IOException;
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
    private ToggleGroup grupo1;

    @FXML
    private ToggleGroup grupo2;

    @FXML
    private Button siguienteButton;

    @FXML
    private Button btnSwitchWindow8;

    @FXML
    private Button verificarButton;

    @FXML
    private Text puntajeText;

    private int puntaje = 0;
    private int puntaje2= 0;

  
    @FXML
    private void initialize() {
        // Asignar identificador a la opción correcta
        btn1.setId("opcion1");
        btn2.setId("opcion2");
        btn3.setId("opcion3");
        btn4.setId("opcion1");
        btn5.setId("opcion2");
        btn6.setId("opcion3");

    }

    // Método para recibir el puntaje desde el controlador anterior
    public void setPuntaje(int puntaje) {
        puntajeText.setText("Puntaje anterior: " + puntaje);
        this.puntaje = puntaje;
    }

    @FXML
    private void switchWindow8(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Categorias.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            CategoriasController categoriasController = loader.getController();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnSwitchWindow8.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void verificarRespuestas2(ActionEvent event) {
        // Verificar la opción seleccionada
        String opcionSeleccionada1 = ((RadioButton) grupo1.getSelectedToggle()).getId();
        String opcionSeleccionada2 = ((RadioButton) grupo2.getSelectedToggle()).getId();

        int puntajeGrupo1 = 0;
        int puntajeGrupo2 = 0;

        // Verificar respuestas para el grupo 1
        if (opcionSeleccionada1.equals("opcion1")) {
            puntajeGrupo1 += 5;
        }

        // Verificar respuestas para el grupo 2
        if (opcionSeleccionada2.equals("opcion2")) {
            puntajeGrupo2 += 5;
        }

        // Calcular el puntaje total sumando los puntajes de los grupos
        int puntajeTotal = puntajeGrupo1 + puntajeGrupo2;

        // Acumular el puntaje
        puntaje2 += puntajeTotal;

        puntajeText.setText("Puntaje: " + puntaje2);

        // Redirigir a otra ventana después de verificar las respuestas
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Componentes.fxml"));
            Parent root = loader.load();

            ComponentesController componentesController = loader.getController();

            // Pasa el puntaje al controlador de la otra ventana (si es necesario)
            componentesController.setPuntaje(puntaje2);

            Scene scene = new Scene(root);
            Stage stage = (Stage) verificarButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
