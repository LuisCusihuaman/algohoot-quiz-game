package poo.coders.main.modelo;

import java.util.ArrayList;

public class OpcionesGrupales {

	private ArrayList<Grupo> grupos;

	OpcionesGrupales() {
		grupos = new ArrayList<>();
		grupos.add(new Grupo("1"));
		grupos.add(new Grupo("2"));
	}

	public void agregarAGrupo1(Opcion opcion) {
		grupos.get(0).agregarAGrupo(opcion);
	}
	public void agregarAGrupo2(Opcion opcion) {
		grupos.get(1).agregarAGrupo(opcion);
	}

	public ArrayList<Respuesta> verificarRespuestas() {
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		for (Grupo grupo : grupos) {
			respuestas.add(grupo.verificarRespuestas());
		}
		return respuestas;
	}

}
