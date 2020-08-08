package poo.coders.main.modelo;

import java.util.ArrayList;

public class Grupo {

	private ArrayList<Opcion> opcionesElegidas;
	private int numGrupo;

	Grupo(int numGrupo){
		opcionesElegidas = new ArrayList<>();
		this.numGrupo = numGrupo;
	}

	public void agregarAGrupo(Opcion opcion){
		opcionesElegidas.add(opcion);
	}

	public Respuesta verificarRespuestas() {
		for (Opcion opcion : this.opcionesElegidas) {
			if (opcion.getClave() != this.numGrupo) return new RespuestaIncorrecta("Incorrecta");
		}
		return new RespuestaCorrecta("Correcta");
	}

}
