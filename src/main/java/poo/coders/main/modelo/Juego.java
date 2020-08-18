package poo.coders.main.modelo;

import javafx.application.Platform;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;
import poo.coders.main.modelo.modificadores.Exclusividad;
import poo.coders.main.modelo.modificadores.SinExclusividad;

import java.util.ArrayList;

public class Juego {
	//private Turno turno;
	//private Estado estado;
	private Jugador jugadorInicial;
	private Jugador jugadorActual;
	private Pregunta preguntaActual;
	ArrayList<ArrayList<Opcion>> respuestasDeJugadores;
	int indexJugadorActual;
	int indexPreguntaActual;
	Exclusividad exclusividadActual;

	public Juego() {
		//this.turno = new Turno();
		//this.estado = Estado.INICIO;

		this.preguntaActual = new Pregunta("", new ComportamientoMultipleChoiceClasico());
		this.respuestasDeJugadores = new ArrayList<>();
		this.respuestasDeJugadores.add(new ArrayList<>());
		this.respuestasDeJugadores.add(new ArrayList<>());
		this.indexJugadorActual = 0;
		this.indexPreguntaActual = 0;

	}


	public void empezarJuego(String nombreJugador1, String nombreJugador2) {
		Jugador jugador1 = new Jugador(nombreJugador1);
		Jugador jugador2 = new Jugador(nombreJugador2);
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		this.jugadorInicial = jugador1;
		this.jugadorActual = jugadorInicial;
		exclusividadActual = new SinExclusividad();

	}

	private Jugador elegirRespuestasAPreguntaActual(ArrayList<Opcion> respuestasElegidas){
		jugadorActual.elegirRespuestasAPreguntaActual(respuestasElegidas);
		return jugadorActual.getJugadorSiguiente();
	}


	public void siguienteTurno(ArrayList<Opcion> respuestasElegidas) {
		//TODO: Refactorizar modelo para adaptar
		// a cambios en Jugador y Pregunta (Ahora son enlazados)

		this.jugadorActual = this.elegirRespuestasAPreguntaActual(respuestasElegidas);
		if(jugadorActual == jugadorInicial){
			//exclusividadActual.definirPuntosJugadoresEnPregunta(preguntaActual, jugadorActual, jugadorActual.siguienteJugador,
			// jugadorActual.respuestasElegidas(), jugadorActual.siguienteJugador.respuestasElegidas);

			this.preguntaActual = preguntaActual.getSiguientePregunta();
			exclusividadActual = new SinExclusividad();

		}
		//notifyObservers();
		// |--> change() -> if(preguntaActual == Invalida (null, o enunciado == "", u otra alternativa) => mostrarFinDelJuego();

		//this.jugadorActual = jugadorActual.procesarPreguntaActual();


/*
		respuestasDeJugadores.set(indexJugadorActual, respuestasJugadorActual);
		indexJugadorActual++;
		indexJugadorActual %= jugadores.size();

 */
	/*	if (indexJugadorActual == 0) {
			preguntas.get(indexPreguntaActual).darPuntosAJugadores(jugadores.get(0), jugadores.get(1), respuestasDeJugadores.get(0), respuestasDeJugadores.get(1));
			if (preguntas.size() - 1 != indexPreguntaActual) {
				indexPreguntaActual++;
			} else {
				Platform.exit();
			}
		}*/
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	public void activarExclusividad(){
		this.exclusividadActual = preguntaActual.activarExclusividad(exclusividadActual);
	}
/*
	public Pregunta getPreguntaActual() {
		return preguntas.get(indexPreguntaActual);
	}

	public String getTipoPregunta() {
		return preguntas.get(indexPreguntaActual).getTipoPregunta();
	}
 */

}
