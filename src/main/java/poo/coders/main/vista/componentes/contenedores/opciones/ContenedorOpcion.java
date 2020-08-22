package poo.coders.main.vista.componentes.contenedores.opciones;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.OpcionConjunto;

import java.util.Set;

public class ContenedorOpcion extends AnchorPane {
	private final Label opcionTexto;
	ComboBox opcionSelecion;
	String claveOriginal;

	public ContenedorOpcion(String claveOriginal, String texto) {
		this.setPrefHeight(72);
		this.setPrefWidth(360);

		this.opcionTexto = new Label();
		this.opcionTexto.setPrefWidth(100);
		this.opcionTexto.setPrefHeight(39);
		this.opcionTexto.setWrapText(true);
		this.opcionTexto.setTextAlignment(TextAlignment.LEFT);

		this.opcionTexto.setLayoutX(36);
		this.opcionTexto.setLayoutY(17);
		this.opcionTexto.setText(texto);

		this.opcionSelecion = new ComboBox();
		this.opcionSelecion.setLayoutX(171);
		this.opcionSelecion.setLayoutY(22);
		this.opcionSelecion.setPrefWidth(150);

		this.claveOriginal = claveOriginal;
		this.getChildren().add(opcionTexto);
		this.getChildren().add(opcionSelecion);
	}

	public void agregarOpcionSeleccionBox(String opcionSeleccion) {
		opcionSelecion.getItems().add(opcionSeleccion);
	}

	public void agregarOpcionesSeleccionBox(Set<String> opcionesSeleccion) {
		opcionSelecion.getItems().addAll(opcionesSeleccion);
	}

	public OpcionConjunto obtenerOpcionActual() {
		String opcionSelecionUsuario = (String) this.opcionSelecion.getValue();
		String opcionTextoUI = this.opcionTexto.getText();
		return new OpcionConjunto(new Opcion(this.claveOriginal, opcionTextoUI), opcionSelecionUsuario);
	}

	public void setearPrimeraOpcion() {
		this.opcionSelecion.getSelectionModel().selectFirst();
	}
}
