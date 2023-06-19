
package juego.Controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InicioController {
   
    @FXML
    private TextField txtUsuario;
      @FXML
    private Button btnSwitchWindow1;

    @FXML
    void switchWindow1(ActionEvent event) {
        try {
            String usuario = txtUsuario.getText();
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Categorias.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            CategoriasController CategoriasController = loader.getController();

               // Pasar el usuario a la ventana "Categorías"
           CategoriasController.setUsuario("Bienvenido "+ usuario + " escoge una categoria");

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnSwitchWindow1.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        @FXML
    void Usuario(ActionEvent event) {
        String usuario = txtUsuario.getText().trim();

        if (usuario.isEmpty()) {
            mostrarMensajeError("Error", "Falta el usuario");
        } else {
            // Guardar el usuario
            System.out.println("Usuario ingresado: " + usuario);
            // Aquí puedes realizar otras acciones con el usuario ingresado
        }

    }
        private void mostrarMensajeError(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
            public void initialize() {
        btnSwitchWindow1.setDisable(true);

        txtUsuario.textProperty().addListener((observable, oldValue, newValue) -> {
            btnSwitchWindow1.setDisable(newValue.trim().isEmpty());
        });
    }
            

}
