package poo.coders.main.vista.componentes.contenedores.modificadores;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ContenedorModificadores extends AnchorPane {

	public ContenedorModificadores(Temporizador temporizador) {
		this.setId("ContenedorModificadores");
		this.setMinHeight(66);
		this.setPrefWidth(360);
		this.getChildren().add(temporizador);
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
