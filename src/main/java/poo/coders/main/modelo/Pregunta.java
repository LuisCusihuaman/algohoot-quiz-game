package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
	private Comportamiento tipoComportamiento;
	private String textoPregunta;
	private List<Opcion> respuestas;
	Exclusividad exclusividad;
	public Pregunta(String textoPregunta, Comportamiento comportamiento) {
		this.tipoComportamiento = comportamiento;
		this.textoPregunta = textoPregunta;
		this.exclusividad = new Exclusividad();
	}

	public String getTextoPregunta() {
		return textoPregunta;
	}


	public int obtenerPuntaje(List<Respuesta> respuestas) {
		Puntaje puntajePregunta = tipoComportamiento.crearPuntaje();

		for (Respuesta unaRespuesta : respuestas) {
			unaRespuesta.aplicarComportamiento(tipoComportamiento, puntajePregunta);
		}
		exclusividad.reiniciarExclusividad();
		return puntajePregunta.getPuntajeAcumulado();
	}

	public void activarExclusividadEnPregunta() {
		exclusividad.activarExclusividad();
	}

	public void aplicarConJugadores(Jugador jugador1, Jugador jugador2, ArrayList<Respuesta>respuestasJugador1, ArrayList<Respuesta> respuestasJugador2) {
		int puntajeJugador1 = this.obtenerPuntaje(respuestasJugador1);
		int puntajeJugador2 = this.obtenerPuntaje(respuestasJugador2);
		exclusividad.determinarPuntosGanados(jugador1, jugador2, puntajeJugador1, puntajeJugador2);
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
