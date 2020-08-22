package poo.coders.main.vista.componentes.contenedores.modificadores;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;
import poo.coders.main.controlador.botones.SiguienteHandlerBoton;
import poo.coders.main.modelo.Juego;
import poo.coders.main.vista.componentes.JuegoVista;

public class Temporizador extends Label {
	private static final Integer STARTTIME = 30;

	public Temporizador(Juego juego, JuegoVista juegoVista) {
		super();
		this.setLayoutX(27);
		this.setLayoutY(20);
		this.setPrefHeight(28);
		this.setPrefWidth(69);
		this.setFont(Font.font(16));
		this.setStyle("-fx-font-weight: bold");

		IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);
		this.textProperty().bind(timeSeconds.asString());
		Timeline timeline = new Timeline();
		KeyFrame keyFrame = new KeyFrame(Duration.seconds(STARTTIME + 1), new SiguienteHandlerBoton(juego, juegoVista), new KeyValue(timeSeconds, 0));
		timeline.getKeyFrames().add(keyFrame);
		timeline.playFromStart();
	}
}
