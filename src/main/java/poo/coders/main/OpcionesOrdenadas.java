package poo.coders.main;

import java.util.ArrayList;

public class OpcionesOrdenadas {
	ArrayList<Opcion> opciones;
	public OpcionesOrdenadas() {
		opciones = new ArrayList<>();
	}
	public boolean estaOrdenada() {
		Opcion opcionAnterior = opciones.get(0);
		for (int i = 1; i < opciones.size(); i++) {
			if(opcionAnterior.esMayorQue(opciones.get(i))) {
				return false;
			}
			opcionAnterior = opciones.get(i);
		}
		return true;
	}

	public void agregarOpcion(Opcion opcion) {
		this.opciones.add(opcion);
	}

	public Respuesta verificarRespuestas(){
		if(this.estaOrdenada()) return new RespuestaCorrecta("Correcta");
		return new RespuestaIncorrecta("Incorrecta");
	}
}
