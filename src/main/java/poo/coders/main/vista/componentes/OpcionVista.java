package poo.coders.main.vista.componentes;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.OpcionConjunto;

import java.util.Set;

public class OpcionVista extends AnchorPane {
	private Label opcionTexto;
	ComboBox opcionSelecion;
	String claveOriginal;

	public OpcionVista(String claveOriginal,String texto) {
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
		String opcionSelecion = (String) this.opcionSelecion.getValue();
		String opcionTexto = this.opcionTexto.getText();
		OpcionConjunto opc = new OpcionConjunto(new Opcion(this.claveOriginal, opcionTexto), opcionSelecion);
		return opc;
	}
	public void setearPrimeraOpcion(){
		this.opcionSelecion.getSelectionModel().selectFirst();
	}
}
