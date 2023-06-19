package juego.Controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CategoriasController {
     @FXML
    private Label lblUsuario;

    private String usuario;
    @FXML
    private Button btnSwitchWindow5;
    @FXML
    private Button btnSwitchWindow4;
    @FXML
    private Button btnSwitchWindow3;
    @FXML
    private Button btnSwitchWindow2;
    @FXML
    private Label lblDatos;

    public void setDatos(String datos) {
        lblDatos.setText(datos);
    }

    @FXML
    private void switchWindow2(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Inicio.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal actual
            Stage stage = (Stage) btnSwitchWindow2.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchWindow3(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Teoria.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnSwitchWindow3.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     @FXML
   private void switchWindow4(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Componentes.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnSwitchWindow4.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     @FXML
    private void switchWindow5(ActionEvent event) {
        try {
            // Cargar la vista de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Circuitos.fxml"));
            Parent root = loader.load();

            // Crear una nueva escena con la vista cargada
            Scene scene = new Scene(root);

            // Obtener el escenario principal (ventana) actual
            Stage stage = (Stage) btnSwitchWindow5.getScene().getWindow();

            // Establecer la nueva escena en el escenario principal
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void setUsuario(String usuario) {
        this.usuario = usuario;
        mostrarUsuario();
    }

    private void mostrarUsuario() {
        lblUsuario.setText(usuario); // Mostrar el usuario en un Label 
    
}}
