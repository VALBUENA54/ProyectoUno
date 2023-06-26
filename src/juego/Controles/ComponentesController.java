package juego.Controles;

import java.io.IOException;
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

public class ComponentesController {
    private int respuesta = 0;
    private int puntaje3 = 0;
    private int puntajeTotal = 0;

    @FXML
    private Button verificarButton;
    @FXML
    private Button siguienteButton;

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
    private Button btnswitchWindow7;

    @FXML
    private ToggleGroup grupo1;

    @FXML
    private ToggleGroup grupo2;

    @FXML
    private Text puntajeText;

    // Método para recibir el puntaje desde el controlador anterior
    public void setPuntaje(int respuesta) {
        puntajeText.setText("Puntaje anterior: " + respuesta);
        this.respuesta = respuesta;
    }

    @FXML
    void switchWindow7(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Categorias.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            CategoriasController categoriasController = loader.getController();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnswitchWindow7.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        // Asignar identificador a la opción correcta
        btn1.setId("opcion1");
        btn2.setId("opcion2");
        btn3.setId("opcion3");
        btn4.setId("opcion1");
        btn5.setId("opcion2");
        btn6.setId("opcion3");
    }

    @FXML
private void verificarRespuestas2(ActionEvent event) {
    // Verificar la opción seleccionada
    String opcionSeleccionada1 = ((RadioButton) grupo1.getSelectedToggle()).getId();
    String opcionSeleccionada2 = ((RadioButton) grupo2.getSelectedToggle()).getId();

    int puntajeGrupo1 = 0;
    int puntajeGrupo2 = 0;

    // Verificar respuestas para el grupo 1
    if (opcionSeleccionada1.equals("opcion2")) {
        puntajeGrupo1 += 5;
    }

    // Verificar respuestas para el grupo 2
    if (opcionSeleccionada2.equals("opcion3")) {
        puntajeGrupo2 += 5;
    }

    // Calcular el puntaje total sumando los puntajes de los grupos
    int puntajeTotalGrupo = puntajeGrupo1 + puntajeGrupo2;

    // Acumular el puntaje total en la variable puntajeTotal de la ventana actual
    puntaje3 += puntajeTotalGrupo;
    puntajeTotal = puntaje3 + respuesta;


    // Redirigir a otra ventana después de verificar las respuestas
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Final.fxml"));
        Parent root = loader.load();

        FinalController finalController = loader.getController();

        // Pasar el puntaje total acumulado a la siguiente ventana
        finalController.setPuntajeTotal(puntajeTotal);

        Scene scene = new Scene(root);
        Stage stage = (Stage) verificarButton.getScene().getWindow();
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}


