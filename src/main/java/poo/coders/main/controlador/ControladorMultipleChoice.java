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

public class ControladorMultipleChoice implements ControladorInterfaz{

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


	@Override
	public void setearInformacionPregunta(Juego juego) {
		this.juego = juego;
		pregunta.setText(juego.getPreguntaActual().getEnunciado());
		nombreJugador.setText(juego.getJugadorActual().getNombre());
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

	public void siguienteTurno(ArrayList<Opcion> respuestasJugador){
		juego.siguienteTurno(respuestasJugador);
		this.setearInformacionPregunta(juego);
		this.cargarVentana(juego);
	}


	public void seleccionarRespuestas(){
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", "Verdadero"));
		siguienteTurno(respuestasJugador);
	}

}

