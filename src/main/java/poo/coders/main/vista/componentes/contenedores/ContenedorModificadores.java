package poo.coders.main.vista.componentes.contenedores;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class ContenedorModificadores extends AnchorPane {
	Label timer;

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
		this.getChildren().add(this.timer);
	}

	public void agregarBoton(Button button) {
		this.getChildren().add(button);
	}

	public void bloquearBoton(String botonID) {
		Button botonBuscado = (Button) this.lookup("#" + botonID);
		botonBuscado.setStyle("-fx-opacity: 0.5");
		botonBuscado.setDisable(true);
	}
}
