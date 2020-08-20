package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.Juego;
import poo.coders.main.vista.componentes.JuegoVista;

public class MultiplicadorExclusividadHandlerBoton implements EventHandler<ActionEvent> {
	Juego juego;
	private JuegoVista juegoVista;

	public MultiplicadorExclusividadHandlerBoton(Juego juego, JuegoVista juegoVista) {
		this.juego = juego;
		this.juegoVista = juegoVista;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juegoVista.bloquearBoton("BOTONEXCLUSIVIDAD");
		this.juego.activarExclusividad();
	}
}
