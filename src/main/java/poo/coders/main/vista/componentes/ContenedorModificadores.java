package poo.coders.main.vista.componentes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ContenedorModificadores extends AnchorPane {
	Label timer;
	Button btnX2;
	Button btnX3;
	Button btnExclusividad;

	public ContenedorModificadores() {
		this.setId("ContenedorModificadores");
		this.setMinHeight(66);
		this.setPrefWidth(360);

		this.timer = new Label();
		this.timer.setLayoutX(27);
		this.timer.setLayoutY(20);
		this.timer.setPrefHeight(28);
		this.timer.setPrefWidth(69);
		this.timer.setText("TIMER");//falta setear su tamaño a 17

		this.btnX2 = new Button();
		this.btnX2.setLayoutX(120);
		this.btnX2.setLayoutY(20);
		this.btnX2.setText("X2");

		this.btnX3 = new Button();
		this.btnX3.setLayoutX(180);
		this.btnX3.setLayoutY(20);
		this.btnX3.setText("X3");

		this.btnExclusividad = new Button();
		this.btnExclusividad.setLayoutX(237);
		this.btnExclusividad.setLayoutY(20);
		this.btnExclusividad.setText("EXCLUSIVIDAD");

		this.getChildren().addAll(this.timer, this.btnX2, this.btnX3, this.btnExclusividad);
	}
}
