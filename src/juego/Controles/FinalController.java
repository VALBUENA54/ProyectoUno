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

public class FinalController {

    @FXML
    private Text puntajeText;

    private int puntajeTotal = 0;

    @FXML
    private Button btnswitchWindow8;

    @FXML
    public void initialize() {
        mostrarPuntajeTotal();
    }

    public void mostrarPuntajeTotal() {
        puntajeText.setText("PUNTAJE: " + puntajeTotal);
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
        mostrarPuntajeTotal();
    }

    @FXML
    void switchWindow8(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/juego/Ventanas/Categorias.fxml"));
            Parent root = loader.load();

            CategoriasController categoriasController = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = (Stage) btnswitchWindow8.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
