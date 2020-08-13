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

public class ControladorVerdaderoFalso implements ControladorEvento {

	@FXML
	private Label pregunta;
	@FXML
	private Label tiempo;
	@FXML
	private Button btnTerminarTurno;
	@FXML
	private Label jugador;
	@FXML
	private Label tipoPregunta;
	@FXML
	private Button multiplicadorx2;
	@FXML
	private Button multiplicadorx3;
	@FXML
	private Label verdadero;
	@FXML
	private Label falso;
	private Juego juego;
	private Stage ventana;

	@Override
	public void setearInformacionPregunta() {
		pregunta.setText(this.juego.getPreguntaActual().getEnunciado());
		jugador.setText(this.juego.getJugadorActual().getNombre());
		tipoPregunta.setText(this.juego.getTipoPregunta());
	}

	@FXML
	@Override
	public void cargarVentana() {
		URL url = Objects.requireNonNull(getClass().getClassLoader().getResource(juego.getTipoPregunta() + ".fxml"));
		FXMLLoader loader = new FXMLLoader(url);
		try {
			Parent root = loader.load();
			ControladorEvento controlador = loader.getController();
			controlador.setearJuego(this.juego, ventana);
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
		this.juego.siguienteTurno(respuestasJugador);
		this.setearInformacionPregunta();
		this.cargarVentana();
	}


	public void seleccionarRespuestas() {
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", "Verdadero"));
		siguienteTurno(respuestasJugador);
	}

}

