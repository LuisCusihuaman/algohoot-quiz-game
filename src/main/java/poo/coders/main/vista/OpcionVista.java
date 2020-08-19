package poo.coders.main.vista;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class OpcionVista extends AnchorPane {
	private Label opcionTexto;
	ComboBox opcionSelecion;

	public OpcionVista(String texto) {
		this.setPrefHeight(72);
		this.setPrefWidth(360);

		this.opcionTexto = new Label();
		this.opcionTexto.setLayoutX(60);
		this.opcionTexto.setLayoutY(27);
		this.opcionTexto.setPrefHeight(18);
		this.opcionTexto.setPrefWidth(69);
		this.opcionTexto.setText(texto);

		this.opcionSelecion = new ComboBox();
		this.opcionSelecion.setLayoutX(171);
		this.opcionSelecion.setLayoutY(22);
		this.opcionSelecion.setPrefWidth(120);

		this.getChildren().add(opcionTexto);
		this.getChildren().add(opcionSelecion);
	}
}
