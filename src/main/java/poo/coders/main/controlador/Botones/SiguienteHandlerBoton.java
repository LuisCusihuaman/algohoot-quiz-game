package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.JuegoMock;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.OpcionConjunto;
import poo.coders.main.vista.componentes.JuegoVista;

import java.util.ArrayList;
import java.util.List;

public class SiguienteHandlerBoton implements EventHandler<ActionEvent> {
	JuegoMock juegoMock;
	JuegoVista juegoVista;

	public SiguienteHandlerBoton(JuegoMock juegoMock, JuegoVista juegoVista) {
		this.juegoMock = juegoMock;
		this.juegoVista = juegoVista;
	}

	@Override
	public void handle(ActionEvent event) {
		ArrayList<Opcion> opcJugActual = (ArrayList<Opcion>) this.juegoVista.obtenerRespuestaJugador();
		this.juegoMock.siguienteTurno(opcJugActual);

	}
}
