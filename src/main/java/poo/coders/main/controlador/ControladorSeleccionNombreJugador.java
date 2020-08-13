package poo.coders.main.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import poo.coders.main.modelo.Juego;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class ControladorSeleccionNombreJugador implements ControladorEvento {
	@FXML
	private TextField jugador1id;
	@FXML
	private TextField jugador2id;
	@FXML
	private Button iniciarJuego;
	@FXML
	private Label tituloJuego;
	private Juego juego;
	private Stage ventana;


	public void setearJuego(Juego juego, Stage ventanaPrincipal) {
		this.juego = juego;
		this.ventana = ventanaPrincipal;
	}

	@FXML
	void setearNombre(ActionEvent event) throws IOException {

		juego.empezarJuego(jugador1id.getText(), jugador2id.getText());

		URL url = Objects.requireNonNull(getClass().getClassLoader().getResource(juego.getTipoPregunta() + ".fxml"));
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		ControladorEvento controlador = loader.getController();
		controlador.setearJuego(juego, ventana);
		controlador.setearInformacionPregunta();
		Scene scene = new Scene(root);
		ventana.setScene(scene);
		ventana.show();
	}

	@Override
	public void setearInformacionPregunta() {

	}

	@Override
	public void cargarVentana() {

	}
}
