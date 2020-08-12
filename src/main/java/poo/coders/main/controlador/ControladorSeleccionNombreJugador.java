package poo.coders.main.controlador;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
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
import poo.coders.main.modelo.Juego;

import java.io.IOException;
import java.util.Objects;

public class ControladorSeleccionNombreJugador implements Observable, ControladorInterfaz {
	@FXML
	private TextField jugador1id;
	@FXML
	private TextField jugador2id;
	@FXML
	private Button iniciarJuego;
	@FXML
	private Label tituloJuego;
	private Juego juego;


	public void setearJuego(Juego juego){
		this.juego = juego;
	}

	@FXML
	void setearNombre(ActionEvent event) throws IOException {


		String nombreJugador1 = jugador1id.getText();
		String nombreJugador2 = jugador2id.getText();
		juego.inicializar(nombreJugador1, nombreJugador2);
		Parent view2 = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("verdaderoFalso.fxml")));
		Scene scene2 = new Scene(view2);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(scene2);
		window.show();
	}


	@Override
	public void addListener(InvalidationListener invalidationListener) {

	}

	@Override
	public void removeListener(InvalidationListener invalidationListener) {

	}
}
