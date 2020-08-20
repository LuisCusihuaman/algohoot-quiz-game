package poo.coders.main.vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class Boton extends Button {


	public Boton (String texto, javafx.event.EventHandler<ActionEvent> controlador){
		setTexto(texto);
		setControlador(controlador);
	}

	public void setTexto(String texto){
		setText(texto);
	}

	public void setControlador(javafx.event.EventHandler<ActionEvent> controlador) {
		setOnAction(controlador);
	}


}
