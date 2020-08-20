package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.JuegoMock;

public class MultiplicadorExclusividadHandlerBoton implements EventHandler<ActionEvent> {
	JuegoMock juegoMock;

	public MultiplicadorExclusividadHandlerBoton(JuegoMock juegoMock) {
		this.juegoMock = juegoMock;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juegoMock.activarMultiplicadorExclusividad();
	}
}
