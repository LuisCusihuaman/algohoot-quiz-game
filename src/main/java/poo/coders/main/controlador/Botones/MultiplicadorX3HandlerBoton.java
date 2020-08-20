package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.JuegoMock;

public class MultiplicadorX3HandlerBoton implements EventHandler<ActionEvent> {
	JuegoMock juegoMock;

	public MultiplicadorX3HandlerBoton(JuegoMock juegoMock) {
		this.juegoMock = juegoMock;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juegoMock.activarMultiplicadorX3();
	}
}
