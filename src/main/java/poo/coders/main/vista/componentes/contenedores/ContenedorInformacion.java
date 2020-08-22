package poo.coders.main.vista.componentes.contenedores;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;

public class ContenedorInformacion extends AnchorPane {
	Label tipoPregunta;
	Label nombreJugador;
	Label preguntaEnunciado;

	public ContenedorInformacion(String tipoPregunta, String nombreJugador, String preguntaEnunciado) {
		this.setId("ContenedorInformacion");
		this.setPrefHeight(96);
		this.setPrefWidth(360);

		this.tipoPregunta = new Label();
		this.tipoPregunta.setLayoutX(14);
		this.tipoPregunta.setLayoutY(18);
		this.tipoPregunta.setText(tipoPregunta);

		this.nombreJugador = new Label();
		this.nombreJugador.setLayoutX(213);
		this.nombreJugador.setLayoutY(18);
		this.nombreJugador.setText(nombreJugador);

		this.preguntaEnunciado = new Label();
		this.preguntaEnunciado.setLayoutX(20);
		this.preguntaEnunciado.setLayoutY(48);
		this.preguntaEnunciado.setText(preguntaEnunciado);
		this.preguntaEnunciado.setWrapText(true);
		this.preguntaEnunciado.setTextAlignment(TextAlignment.JUSTIFY);
		this.preguntaEnunciado.setMaxWidth(220);

		this.getChildren().addAll(this.tipoPregunta, this.nombreJugador, this.preguntaEnunciado);

	}


}
