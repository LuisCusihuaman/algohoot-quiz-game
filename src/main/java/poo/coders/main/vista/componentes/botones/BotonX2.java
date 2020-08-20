package poo.coders.main.vista.componentes.botones;

import javafx.scene.control.Button;
import poo.coders.main.controlador.Botones.MultiplicadorX2HandlerBoton;

public class BotonX2 extends Button {
	public BotonX2(MultiplicadorX2HandlerBoton multiplicadorX2HandlerBoton) {
		super();
		this.setId("BOTONX2");
		this.setLayoutX(120);
		this.setLayoutY(20);
		this.setText("X2");
		this.setOnAction(multiplicadorX2HandlerBoton);
	}
}
