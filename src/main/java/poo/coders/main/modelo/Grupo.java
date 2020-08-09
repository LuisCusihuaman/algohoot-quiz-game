package poo.coders.main.modelo;

import java.util.ArrayList;

public class Grupo {

	private ArrayList<Opcion> opcionesElegidas;
	private String nombreGrupo;

	Grupo(String nombreGrupo){
		opcionesElegidas = new ArrayList<>();
		this.nombreGrupo = nombreGrupo;
	}

	String getNombreGrupo(){
		return this.nombreGrupo;
	}

	public void agregarAGrupo(Opcion opcion){
		opcionesElegidas.add(opcion);
	}

	public Respuesta verificarRespuestas() {
		for (Opcion opcion : this.opcionesElegidas) {
			if (!opcion.getClave().equals(this.nombreGrupo)) return new RespuestaIncorrecta("Incorrecta");
		}
		return new RespuestaCorrecta("Correcta");
	}

}
