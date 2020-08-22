package poo.coders.main.vista.componentes.contenedores;

import javafx.scene.layout.VBox;
import poo.coders.main.vista.componentes.contenedores.modificadores.ContenedorModificadores;
import poo.coders.main.vista.componentes.contenedores.opciones.ContenedorOpciones;

public class ContenedorJuego extends VBox {
	public ContenedorJuego() {
		this.setId("ContenedorJuego");
		this.setStyle("-fx-background-color: FFFFFF");
	}

	public void limpiar() {
		this.getChildren().removeAll();
	}

	public void construir(ContenedorInformacion contenedorInformacion, ContenedorModificadores contenedorModificadores, ContenedorOpciones contenedorOpciones, ContenedorSiguiente contenedorSiguiente) {
		this.getChildren().addAll(contenedorInformacion, contenedorModificadores, contenedorOpciones, contenedorSiguiente);
	}
}
