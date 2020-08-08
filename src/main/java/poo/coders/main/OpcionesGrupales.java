package poo.coders.main;

import java.util.ArrayList;

public class OpcionesGrupales {
	private ArrayList<Opcion> grupoOpciones;
	private int numGrupo;

	OpcionesGrupales(int numGrupo){
		this.numGrupo = numGrupo;
		grupoOpciones = new ArrayList<>();
	}

	public void agregarAGrupo(Opcion opcion) {
		grupoOpciones.add(opcion);
	}

	public Respuesta verificarRespuestas(){
		for (Opcion opcion : this.grupoOpciones) {
			if(opcion.getClave() != this.numGrupo) return new RespuestaIncorrecta("Incorrecta");
		}
		return new RespuestaCorrecta("Correcta");
	}
}
