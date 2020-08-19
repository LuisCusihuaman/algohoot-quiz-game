package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.modelo.JuegoMock;
import poo.coders.main.vista.componentes.JuegoVista;

public class EmpezarHandlerBoton implements EventHandler<ActionEvent> {
	private Stage ventana;
	JuegoVista juegoVista;
	JuegoMock juegoMock;

	public EmpezarHandlerBoton(Stage ventana, JuegoVista juegoVista, JuegoMock juegoMock) {
		this.ventana = ventana;
		this.juegoVista = juegoVista;
		this.juegoMock = juegoMock;
	}

	@Override
	public void handle(ActionEvent event) {
		juegoMock.empezarJuego("pedrin", "pedron");
		Scene scene = new Scene(this.juegoVista.mostrar());
		ventana.setScene(scene);
		ventana.show();
	}
}
