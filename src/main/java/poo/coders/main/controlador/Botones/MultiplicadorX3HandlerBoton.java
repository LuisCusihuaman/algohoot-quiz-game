package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import poo.coders.main.modelo.Juego;
import poo.coders.main.modelo.JuegoMock;

public class MultiplicadorX3HandlerBoton implements EventHandler<ActionEvent> {
	Juego juego;

	public MultiplicadorX3HandlerBoton(Juego juego) {
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent event) {
		this.juego.activarMultiplicadorX3();
	}
}
