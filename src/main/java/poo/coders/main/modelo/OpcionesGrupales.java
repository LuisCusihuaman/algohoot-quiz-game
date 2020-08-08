package poo.coders.main.modelo;

import java.util.ArrayList;

public class OpcionesGrupales {
	private ArrayList<Opcion> grupoOpciones;
	private int numGrupo;

	OpcionesGrupales(int numGrupo) {
		this.numGrupo = numGrupo;
		grupoOpciones = new ArrayList<>();
	}

	public void agregarAGrupo(Opcion opcion) {
		grupoOpciones.add(opcion);
	}

	public Respuesta verificarRespuestas() {
		for (Opcion opcion : this.grupoOpciones) {
			if (opcion.getId() != this.numGrupo) return new RespuestaIncorrecta("Incorrecta");
		}
		return new RespuestaCorrecta("Correcta");
	}

	public ArrayList<Respuesta> verificarRespuestas(ArrayList<OpcionesGrupales> opcionesGrupales) {
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		for (OpcionesGrupales opciones : opcionesGrupales) {
			respuestas.add(opciones.verificarRespuestas());
		}
		return respuestas;
	}
	//TODO: Borrar este metodo
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
