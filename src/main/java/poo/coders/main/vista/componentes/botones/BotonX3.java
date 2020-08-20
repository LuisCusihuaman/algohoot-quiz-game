package poo.coders.main.vista.componentes.botones;

import javafx.scene.control.Button;
import poo.coders.main.controlador.Botones.MultiplicadorX3HandlerBoton;

public class BotonX3 extends Button {
	public BotonX3(MultiplicadorX3HandlerBoton multiplicadorX3HandlerBoton) {
		super();
		this.setId("BOTONX3");
		this.setLayoutX(180);
		this.setLayoutY(20);
		this.setText("X3");
		this.setOnAction(multiplicadorX3HandlerBoton);
	}
}
