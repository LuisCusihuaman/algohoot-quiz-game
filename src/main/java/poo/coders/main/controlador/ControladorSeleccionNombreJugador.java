package poo.coders.main.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControladorSeleccionNombreJugador {
	@FXML
	private TextField jugardor1id;
	@FXML
	private TextField jugardor2id;
	@FXML
	private Button setjugador;

	@FXML
	void setearNombre(ActionEvent event) {
		System.out.println("Clickeaste wacho.");
	}
}
