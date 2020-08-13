package poo.coders.main.controlador;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.OpcionCorrecta;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class ControladorVerdaderoFalso implements ControladorInterfaz{

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

	@Override
	public void setearInformacionPregunta(Juego juego) {
		this.juego = juego;
		pregunta.setText(juego.getPreguntaActual().getEnunciado());
		jugador.setText(juego.getJugadorActual().getNombre());
		tipoPregunta.setText(juego.getTipoPregunta());
	}

	@FXML @Override
	public void cargarVentana(Juego juego) {
		this.juego = juego;
		URL url = Objects.requireNonNull(getClass().getClassLoader().getResource(juego.getTipoPregunta()+".fxml"));
		FXMLLoader loader = new FXMLLoader(url);
		try {
			Parent root = loader.load();
			ControladorInterfaz controlador = loader.getController();
			controlador.setearInformacionPregunta(juego);
			Stage window = new Stage();
			Scene scene = new Scene(root);
			window.setScene(scene);
			window.show();
		} catch (Exception e){ System.out.println("Ocurre aca");
		e.printStackTrace();}


	}

	@Override
	public void setearJuego(Juego juego) {
		this.juego = juego;
	}
	@FXML
	public void siguienteTurno(ArrayList<Opcion> respuestasJugador, ActionEvent event){
		juego.siguienteTurno(respuestasJugador);
		this.setearInformacionPregunta(juego);
		this.cargarVentana(juego);
	}

	@FXML
	public void seleccionarRespuestas(ActionEvent event){
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", "Verdadero"));
		siguienteTurno(respuestasJugador, event);
	}

}

