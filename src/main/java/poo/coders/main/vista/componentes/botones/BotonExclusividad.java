package poo.coders.main.vista.componentes.botones;

import javafx.scene.control.Button;
import poo.coders.main.controlador.botones.MultiplicadorExclusividadHandlerBoton;

public class BotonExclusividad extends Button {

	public BotonExclusividad(MultiplicadorExclusividadHandlerBoton multiplicadorExclusividadHandlerBoton) {
		super();
		this.setId("BOTONEXCLUSIVIDAD");
		this.setLayoutX(237);
		this.setLayoutY(20);
		this.setText("EXCLUSIVIDAD");
		this.setOnAction(multiplicadorExclusividadHandlerBoton);
	}
}
