package poo.coders.main.vista.componentes;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.vista.OpcionVista;

import java.util.ArrayList;
import java.util.List;

public class ContenedorOpciones extends VBox {

	public ContenedorOpciones() {
		this.setId("ContenedorOpciones");
		this.setStyle("-fx-background-color: C4C4C4");
		this.setMinHeight(422);
	}

	public void agregarOpcion(OpcionVista opcionVista) {
		this.getChildren().add(opcionVista);
	}

	public List<Opcion> obtenerRespuestas() {
		List<Opcion> opcionModelo = new ArrayList<>();
		ObservableList<Node> opcionesVista = this.getChildren();
		for (Node opcion : opcionesVista) {
			OpcionVista opc = (OpcionVista) opcion;
			if(laOpcionNoEstaVacia(opc)){
				opcionModelo.add(opc.obtenerOpcionActual());
			}
		}
		return opcionModelo;
	}

	private boolean laOpcionNoEstaVacia(OpcionVista opc) {
		OpcionConjunto temp = opc.obtenerOpcionActual();
		return temp.getClaveElegida() != null;
	}
}
