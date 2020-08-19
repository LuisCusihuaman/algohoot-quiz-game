package poo.coders.main.vista.componentes;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import poo.coders.main.controlador.Botones.SiguienteHandlerBoton;
import poo.coders.main.modelo.JuegoMock;

public class ContenedorSiguiente extends AnchorPane {
	Button btnSiguiente;

	public ContenedorSiguiente(JuegoMock juegoMock) {
		this.setId("ContenedorSiguiente");
		this.setPrefWidth(80);
		this.setPrefHeight(360);

		this.btnSiguiente = new Button();
		this.btnSiguiente.setLayoutX(138);
		this.btnSiguiente.setLayoutY(20);
		this.btnSiguiente.setText("SIGUIENTE");
		this.btnSiguiente.setOnAction(new SiguienteHandlerBoton(juegoMock));
		this.getChildren().add(btnSiguiente);
	}
}
