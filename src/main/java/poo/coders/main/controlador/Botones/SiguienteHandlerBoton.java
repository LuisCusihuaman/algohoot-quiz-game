package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.vista.componentes.JuegoVista;

import java.util.ArrayList;

public class SiguienteHandlerBoton implements EventHandler<ActionEvent> {
	Juego juego;
	JuegoVista juegoVista;

	public SiguienteHandlerBoton(Juego juego, JuegoVista juegoVista) {
		this.juego = juego;
		this.juegoVista = juegoVista;
	}

	@Override
	public void handle(ActionEvent event) {
		ArrayList<Opcion> opcJugActual = (ArrayList<Opcion>) this.juegoVista.obtenerRespuestaJugador();
		this.juego.siguienteTurno(opcJugActual);

	}
}
