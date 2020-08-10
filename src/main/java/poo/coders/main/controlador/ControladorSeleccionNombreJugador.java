package poo.coders.main.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControladorSeleccionNombreJugador {
	@FXML
	private TextField jugardor1id;
	@FXML
	private TextField jugardor2id;
	@FXML
	private Button iniciarJuego;
	@FXML
	private Label tituloJuego;

	@FXML
	void setearNombre(ActionEvent event) throws IOException {

		System.out.println("Clickeaste wacho.");
		Parent view2 = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("groupChoice.fxml")));
		Scene scene2 = new Scene(view2);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
	}
}
