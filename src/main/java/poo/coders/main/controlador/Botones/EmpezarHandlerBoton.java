package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import poo.coders.main.modelo.Juego;

public class EmpezarHandlerBoton implements EventHandler<ActionEvent> {
	private final TextField t2;
	private final TextField t1;
	Juego juego;

	public EmpezarHandlerBoton(Juego juego, TextField t1, TextField t2) {
		this.juego = juego;
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void handle(ActionEvent event) {
		juego.empezarJuego(t1.getText(), t2.getText());
	}
}
