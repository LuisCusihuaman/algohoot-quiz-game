package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import poo.coders.main.modelo.JuegoMock;

public class EmpezarHandlerBoton implements EventHandler<ActionEvent> {
	private final TextField t2;
	private final TextField t1;
	JuegoMock juegoMock;

	public EmpezarHandlerBoton(JuegoMock juegoMock, TextField t1, TextField t2) {
		this.juegoMock = juegoMock;
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void handle(ActionEvent event) {
		juegoMock.empezarJuego(t1.getText(), t2.getText());
	}
}
