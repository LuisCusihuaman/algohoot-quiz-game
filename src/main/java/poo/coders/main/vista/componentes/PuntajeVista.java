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
		int jugadorPerdedorPuntos = jugadorGanador.getJugadorSiguiente().getPuntos();

		this.contenedorJuego = new ContenedorJuego();
		AnchorPane contenedorTitulo = new AnchorPane();
		contenedorTitulo.setId("TITULO");
		contenedorTitulo.setPrefHeight(141);
		contenedorTitulo.setPrefWidth(360);

		Label titulo = new Label();
		titulo.setText("PUNTAJES");
		titulo.setLayoutX(103);
		titulo.setLayoutY(60);
		titulo.setTextAlignment(TextAlignment.CENTER);
		titulo.setFont(Font.font(33));

		VBox puntajes = new VBox();
		puntajes.setId("PUNTAJES_JUGADORES");
		puntajes.setStyle("-fx-background-color: #C4C4C4");
		puntajes.setMinHeight(124);

		AnchorPane puntajeJ1 = new AnchorPane();
		puntajeJ1.setId("PUNTAJE J1");
		construirPuntaje(jugadorGanadorNombre, jugadorGanadorPuntos, puntajeJ1);

		AnchorPane puntajeJ2 = new AnchorPane();
		puntajeJ2.setId("PUNTAJE J2");
		construirPuntaje(jugadorPerdedorNombre, jugadorPerdedorPuntos, puntajeJ2);

		puntajes.getChildren().addAll(puntajeJ1, puntajeJ2);
		contenedorTitulo.getChildren().add(titulo);
		this.contenedorJuego.getChildren().addAll(contenedorTitulo, puntajes);
		return this.contenedorJuego;
	}
}
