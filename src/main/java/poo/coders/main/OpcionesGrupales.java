package poo.coders.main;

import java.util.ArrayList;

public class OpcionesGrupales {
	ArrayList<Opcion> grupoOpciones = new ArrayList<>();
	public void agregarAGrupo(Opcion opcion) {
		grupoOpciones.add(opcion);
	}

	public boolean esIgualA(OpcionesGrupales grupoOpciones) {
		for (Opcion opcion: this.grupoOpciones) {
			if (!grupoOpciones.contieneA(opcion)) {
				return false;
			}
		}
		return true;
	}

	public boolean contieneA(Opcion opcion) {
		for (Opcion opcionDelGrupo : grupoOpciones) {
			if (!opcionDelGrupo.esIgualA(opcion)) {
				return false;
			}
		}
		return true;
	}

	public boolean elementosSonDelMismoGrupo() {
		Opcion opcion = grupoOpciones.get(0);
		for (Opcion otraOpcion : grupoOpciones) {
			if (!opcion.esIgualA(otraOpcion)) {
				return false;
			}
		}
		return true;
	}
}
