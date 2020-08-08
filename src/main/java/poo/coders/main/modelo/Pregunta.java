package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
	private Comportamiento tipoComportamiento;
	private String textoPregunta;
	private List<Opcion> respuestas;

	public Pregunta(String textoPregunta, Comportamiento comportamiento) {
		this.tipoComportamiento = comportamiento;
		this.textoPregunta = textoPregunta;
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}


	public int obtenerPuntaje(List<Respuesta> respuestas) {

		Puntaje puntajePregunta = tipoComportamiento.crearPuntaje();

		for (Respuesta unaRespuesta : respuestas) {
			unaRespuesta.aplicarComportamiento(tipoComportamiento, puntajePregunta);
		}
		return puntajePregunta.getPuntajeAcumulado();
	}

	//TODO: Arreglar
	/*
	public void decidirSiAplicarExclusividad(Jugador jugador1, List<Respuesta> respuestasJugador1, Jugador jugador2, List<Respuesta> respuestasJugador2){
		if(this.obtenerPuntaje(respuestasJugador1) > this.obtenerPuntaje(respuestasJugador2)){
			jugador1.aplicarExclusividad(this, respuestasJugador1);
		}
		if(this.obtenerPuntaje())

	}

	 */



}
