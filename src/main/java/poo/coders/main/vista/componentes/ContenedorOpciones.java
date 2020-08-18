package poo.coders.main.vista.componentes;

import javafx.scene.layout.VBox;
import poo.coders.main.vista.OpcionVista;

public class ContenedorOpciones extends VBox {

	public ContenedorOpciones() {
		this.setId("ContenedorOpciones");
		this.setStyle("-fx-background-color: C4C4C4");
		this.setMinHeight(422);
	}

	public void agregarOpcion(OpcionVista opcionVista) {
		this.getChildren().add(opcionVista);
	}
}
