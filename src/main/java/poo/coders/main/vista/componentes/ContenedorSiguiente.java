package poo.coders.main.vista.componentes;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import poo.coders.main.controlador.botones.SiguienteHandlerBoton;
import poo.coders.main.modelo.Juego;

public class ContenedorSiguiente extends AnchorPane {
	Button btnSiguiente;

	public ContenedorSiguiente(Juego juego, JuegoVista juegoVista) {
		this.setId("ContenedorSiguiente");
		this.setPrefWidth(80);
		this.setPrefHeight(100);

		this.btnSiguiente = new Button();
		this.btnSiguiente.setLayoutX(138);
		this.btnSiguiente.setLayoutY(20);
		this.btnSiguiente.setText("SIGUIENTE");
		this.btnSiguiente.setOnAction(new SiguienteHandlerBoton(juego,juegoVista));
		this.getChildren().add(btnSiguiente);
	}
}
