package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Comportamiento {

	public void correcto(Puntaje puntaje) {
		puntaje.accionCorrecta();
	}

	public void incorrecto(Puntaje puntaje) {
		puntaje.accionIncorrecta();
	}

	public List<Respuesta> verificarOpciones(List<Opcion> opcionesElegidasPorElJugador){
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		for (Opcion opcion : opcionesElegidasPorElJugador ) {
			try {
				respuestas.add(opcion.convertirEnRespuesta());
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return respuestas;
	}

	public abstract Puntaje crearPuntaje();



}
