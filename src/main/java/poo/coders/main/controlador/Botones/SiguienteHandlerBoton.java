package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import poo.coders.main.modelo.JuegoMock;

public class SiguienteHandlerBoton implements EventHandler<ActionEvent> {
	JuegoMock juegoMock;

	public SiguienteHandlerBoton(JuegoMock juegoMock) {
		this.juegoMock = juegoMock;

	}

	@Override
	public void handle(ActionEvent event) {
		this.juegoMock.siguienteTurno(null);
	}
}
