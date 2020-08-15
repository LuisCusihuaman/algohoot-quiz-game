package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.Exclusividad;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Puntaje;
import poo.coders.main.modelo.Respuesta;

import java.util.ArrayList;
import java.util.List;

public abstract class Comportamiento {



	public void correcto(Puntaje puntaje) {
		puntaje.accionCorrecta();
	}

	public void incorrecto(Puntaje puntaje) {
		puntaje.accionIncorrecta();
	}


	private List<Respuesta> verificarOpciones(List<Opcion> opcionesElegidasPorElJugador){
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		for (Opcion opcion : opcionesElegidasPorElJugador ) {
				respuestas.add(opcion.convertirEnRespuesta());
		}

		return respuestas;
	}

	public int obtenerPuntaje(List<Opcion> opcionesElegidasPorElJugador){
		List<Respuesta> respuestas = this.verificarOpciones(opcionesElegidasPorElJugador);
		Puntaje puntaje = this.crearPuntaje();
		for (Respuesta respuesta: respuestas){
			respuesta.aplicarComportamiento(this, puntaje);
		}
		return puntaje.getPuntajeAcumulado();
	}

	public abstract String getTipoPregunta();

	protected abstract Puntaje crearPuntaje();

	public abstract int activarMultiplicadorX2();
	public abstract int activarMultiplicadorX3();
	public abstract void activarExclusividad(Exclusividad exclusividad);



}
