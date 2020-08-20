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
			exclusividadActual.definirPuntosJugadoresEnPregunta(preguntaActual, jugadorActual);

			this.preguntaActual = preguntaActual.getSiguientePregunta();
			exclusividadActual = new SinExclusividad();

		}
		//notifyObservers();
		// |--> change() -> if(preguntaActual == Invalida (null, o enunciado == "", u otra alternativa) => mostrarFinDelJuego();

	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	public void activarExclusividad(){
		this.exclusividadActual = preguntaActual.activarExclusividad(exclusividadActual);
	}

	public Pregunta getPreguntaActual() {
		return this.preguntaActual;
	}

	public String getTipoPregunta() {
		return this.preguntaActual.getTipoPregunta();
	}


}
