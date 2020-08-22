package poo.coders.main.vista.componentes;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.Jugador;
import poo.coders.main.vista.componentes.contenedores.ContenedorJuego;

public class PuntajeVista {
	Juego juego;
	ContenedorJuego contenedorJuego;

	public PuntajeVista(Juego juego) {
		this.juego = juego;
	}

	private void construirPuntaje(String jugadorGanadorNombre, int jugadorGanadorPuntos, AnchorPane contenedorPuntaje) {
		Label nombreJugador = new Label();
		nombreJugador.setText(jugadorGanadorNombre);
		nombreJugador.setLayoutX(60);
		nombreJugador.setLayoutY(27);
		nombreJugador.setPrefHeight(18);
		nombreJugador.setPrefWidth(85);
		nombreJugador.setStyle("-fx-font-weight: bold");


		Label puntajeJugador = new Label();
		puntajeJugador.setText(String.valueOf(jugadorGanadorPuntos));
		puntajeJugador.setLayoutX(248);
		puntajeJugador.setLayoutY(27);
		puntajeJugador.setPrefHeight(18);
		puntajeJugador.setPrefWidth(85);

		contenedorPuntaje.getChildren().addAll(nombreJugador, puntajeJugador);
	}

	public ContenedorJuego mostrar() {
		Jugador jugadorGanador = this.juego.getGanador();
		String jugadorGanadorNombre = jugadorGanador.getNombre();
		String jugadorPerdedorNombre = jugadorGanador.getJugadorSiguiente().getNombre();
		int jugadorGanadorPuntos = jugadorGanador.getPuntos();
		int jugadorPerdorPuntos = jugadorGanador.getJugadorSiguiente().getPuntos();

		this.contenedorJuego = new ContenedorJuego();
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId("TITULO");
		anchorPane.setPrefHeight(141);
		anchorPane.setPrefWidth(360);

		Label label = new Label();
		label.setText("PUNTAJES");
		label.setLayoutX(103);
		label.setLayoutY(60);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setFont(Font.font(33));

		VBox vBox = new VBox();
		vBox.setId("PUNTAJES_JUGADORES");
		vBox.setStyle("-fx-background-color: #C4C4C4");
		vBox.setMinHeight(124);

		AnchorPane puntajeJ1 = new AnchorPane();
		puntajeJ1.setId("PUNTAJE J1");
		construirPuntaje(jugadorGanadorNombre, jugadorGanadorPuntos, puntajeJ1);

		AnchorPane puntajeJ2 = new AnchorPane();
		puntajeJ2.setId("PUNTAJE J2");
		construirPuntaje(jugadorPerdedorNombre, jugadorPerdorPuntos, puntajeJ2);

		vBox.getChildren().addAll(puntajeJ1, puntajeJ2);
		anchorPane.getChildren().add(label);
		this.contenedorJuego.getChildren().addAll(anchorPane, vBox);
		return this.contenedorJuego;
	}
}
