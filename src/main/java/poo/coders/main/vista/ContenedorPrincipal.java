package poo.coders.main.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import poo.coders.main.controlador.Botones.ControladorExclusividad;
import poo.coders.main.controlador.Botones.ControladorFinalizar;
import poo.coders.main.controlador.Botones.ControladorMultX2;
import poo.coders.main.controlador.Botones.ControladorMultX3;

import java.util.Timer;
import java.util.TimerTask;

public class ContenedorPrincipal extends BorderPane {

	/*static Visor visorActual;
	Tablero tablero;
	VBox contenedorCentral;

	static ArrayList<VistaJugador> vistaJugadores = new ArrayList<>();
	static ArrayList<Jugador> jugadores = new ArrayList<>();
	static VistaTablero vistaTablero;*/
	static Canvas fondo;
	static Pane centro;
	int time_initial;
	public ContenedorPrincipal() {
		this.setFondo();
		this.setBotonera();

		//this.setCentro(tablero);
		//this.setConsola();

	}

	public void setFondo() {
		fondo = new Canvas(800, 500);
		fondo.getGraphicsContext2D().setFill(Color.rgb(0,0,0));
		fondo.getGraphicsContext2D().fillRect(0, 0, 0, 0);
		centro = new Pane(fondo);
	}
	private void setBotonera() {
		Label tiempo = new Label("tiempo");
		tiempo.setAlignment(Pos.TOP_CENTER);

		//tiempo.setStyle("-fx-background-color: #;");
		Boton multiplicadorX2 = new Boton("X2", null);
		Boton multiplicadorx3 = new Boton("X3",null );
		Boton exclusividad = new Boton("EXCUSIV",null
		);
		Boton finalizar = new Boton("finalizar", null);

		//multiplicadorX2.setControlador( new ControladorMultiplicador(multiplicadorX2));

		VBox contenedorVertical = new VBox( tiempo ,multiplicadorX2, multiplicadorx3,exclusividad,finalizar);

		contenedorVertical.setPrefWidth(150);
		contenedorVertical.setPrefWidth(150);
		contenedorVertical.setSpacing(40);
		contenedorVertical.setAlignment(Pos.BOTTOM_CENTER);

		contenedorVertical.setPadding(new Insets(30));
		contenedorVertical.setStyle("-fx-background-color: #FFFFFFFF;");
		this.setRight(contenedorVertical);

		//botonTirarDados.textoAlPasarMouse("Truquito: Doble click termina el turno");
		/*Boton botonComprar = new Boton("Comprar", new ControladorComprar());
		Boton botonVender = new Boton("Vender", new ControladorVender());
		Boton botonPagarFianza = new Boton("Pagar Fianza", new ControladorPagarFianza());
		Boton botonEdificarCasa = new Boton("Edificar Casa", new ControladorEdificar());
		Boton botonEdificarHotel = new Boton("Edificar Hotel", new ControladorEdificarHotel());*/


	}





}
