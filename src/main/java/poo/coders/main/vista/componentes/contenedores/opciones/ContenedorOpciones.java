package poo.coders.main.vista.componentes.contenedores.opciones;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.OpcionConjunto;

import java.util.ArrayList;
import java.util.List;

public class ContenedorOpciones extends VBox {

	public ContenedorOpciones() {
		this.setId("ContenedorOpciones");
		this.setStyle("-fx-background-color: C4C4C4");
		this.setMinHeight(422);
	}

	public void agregarOpcion(ContenedorOpcion contenedorOpcion) {
		this.getChildren().add(contenedorOpcion);
	}

	public List<Opcion> obtenerRespuestas() {
		List<Opcion> opcionModelo = new ArrayList<>();
		ObservableList<Node> opcionesVista = this.getChildren();
		for (Node opcion : opcionesVista) {
			ContenedorOpcion opc = (ContenedorOpcion) opcion;
			if (laOpcionNoEstaVacia(opc)) {
				opcionModelo.add(opc.obtenerOpcionActual());
			}
		}
		return opcionModelo;
	}

	private boolean laOpcionNoEstaVacia(ContenedorOpcion opc) {
		OpcionConjunto temp = opc.obtenerOpcionActual();
		return temp.getClaveElegida() != null;
	}
}
