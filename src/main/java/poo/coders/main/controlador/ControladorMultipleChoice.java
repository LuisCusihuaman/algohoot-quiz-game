package poo.coders.main.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.OpcionCorrecta;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class ControladorMultipleChoice implements ControladorEvento {

	@FXML
	private Label nombreJugador;
	@FXML
	private Label pregunta;
	@FXML
	private Label tiempo;
	@FXML
	private Button multiplicadorx2;
	@FXML
	private Button btnTerminarTurno;
	@FXML
	private Button multiplicadorx3;
	@FXML
	private Label respuesta1;
	@FXML
	private Label respuesta2;
	@FXML
	private Label respuesta3;
	@FXML
	private Label respuesta4;
	@FXML
	private Label respuesta5;
	@FXML
	private Label respuesta6;
	@FXML
	private Label tipoPregunta;
	private Juego juego;
	private Stage ventana;


	@Override
	public void setearInformacionPregunta() {
		pregunta.setText(juego.getPreguntaActual().getEnunciado());
		nombreJugador.setText(juego.getJugadorActual().getNombre());
		tipoPregunta.setText(juego.getTipoPregunta());
	}

	@FXML
	@Override
	public void cargarVentana() {
		URL url = Objects.requireNonNull(getClass().getClassLoader().getResource(juego.getTipoPregunta() + ".fxml"));
		FXMLLoader loader = new FXMLLoader(url);
		try {
			Parent root = loader.load();
			ControladorEvento controlador = loader.getController();
			controlador.setearJuego(juego, ventana);
			controlador.setearInformacionPregunta();
			Scene scene = new Scene(root);
			ventana.setScene(scene);
			ventana.show();
		} catch (Exception e) {
			System.out.println("Ocurre aca");
			e.printStackTrace();
		}


	}

	@Override
	public void setearJuego(Juego juego, Stage ventanaPrincipal) {
		this.juego = juego;
		this.ventana = ventanaPrincipal;
	}

	public void siguienteTurno(ArrayList<Opcion> respuestasJugador) {
		juego.siguienteTurno(respuestasJugador);
		this.setearInformacionPregunta();
		this.cargarVentana();
	}


	public void seleccionarRespuestas() {
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", "Verdadero"));
		siguienteTurno(respuestasJugador);
	}

}

