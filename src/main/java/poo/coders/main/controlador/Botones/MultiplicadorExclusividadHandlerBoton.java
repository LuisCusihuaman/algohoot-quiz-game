package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.JuegoMock;
import poo.coders.main.vista.componentes.JuegoVista;

public class MultiplicadorExclusividadHandlerBoton implements EventHandler<ActionEvent> {
	JuegoMock juegoMock;
	private JuegoVista juegoVista;

	public MultiplicadorExclusividadHandlerBoton(JuegoMock juegoMock, JuegoVista juegoVista) {
		this.juegoMock = juegoMock;
		this.juegoVista = juegoVista;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juegoVista.bloquearBoton("BOTONEXCLUSIVIDAD");
		this.juegoMock.activarMultiplicadorExclusividad();
	}
}
