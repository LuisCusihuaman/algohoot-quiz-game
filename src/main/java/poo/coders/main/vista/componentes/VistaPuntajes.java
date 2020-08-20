package poo.coders.main.vista.componentes;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.JuegoMock;
import poo.coders.main.modelo.Jugador;

import java.util.ArrayList;

public class VistaPuntajes {
	Juego juego;
	ContenedorJuego contenedorJuego;

	public VistaPuntajes(Juego juego) {
		this.juego = juego;
	}

	public ContenedorJuego mostrar() {
		Jugador jugadorGanador = this.juego.getGanador();
		String jugadorGanadorNombre =jugadorGanador.getNombre();
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

		AnchorPane anchorPane1 = new AnchorPane();
		anchorPane1.setId("PUNTAJE J1");

		Label label1 = new Label();
		label1.setText(jugadorGanadorNombre);
		label1.setLayoutX(60);
		label1.setLayoutY(27);
		label1.setPrefHeight(18);
		label1.setPrefWidth(85);

		Label p1 = new Label();
		p1.setText(String.valueOf(jugadorGanadorPuntos));
		p1.setLayoutX(248);
		p1.setLayoutY(27);
		p1.setPrefHeight(18);
		p1.setPrefWidth(85);

		anchorPane1.getChildren().addAll(label1, p1);

		AnchorPane anchorPane2 = new AnchorPane();
		anchorPane2.setId("PUNTAJE J2");

		Label label2 = new Label();
		label2.setText(jugadorPerdedorNombre);
		label2.setLayoutX(60);
		label2.setLayoutY(27);
		label2.setPrefHeight(18);
		label2.setPrefWidth(85);

		Label p2 = new Label();
		p2.setText(String.valueOf(jugadorPerdorPuntos));
		p2.setLayoutX(248);
		p2.setLayoutY(27);
		p2.setPrefHeight(18);
		p2.setPrefWidth(85);

		anchorPane2.getChildren().addAll(label2, p2);


		vBox.getChildren().addAll(anchorPane1, anchorPane2);
		anchorPane.getChildren().add(label);
		this.contenedorJuego.getChildren().addAll(anchorPane, vBox);
		return this.contenedorJuego;
	}
}
