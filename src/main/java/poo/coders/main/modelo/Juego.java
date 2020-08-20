package poo.coders.main.modelo;

import javafx.application.Platform;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;
import poo.coders.main.modelo.modificadores.Exclusividad;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;
import poo.coders.main.modelo.modificadores.MultiplicadorX3;
import poo.coders.main.modelo.modificadores.SinExclusividad;

import java.util.ArrayList;

public class Juego implements Observable{
	//private Turno turno;
	//private Estado estado;
	private Jugador jugadorInicial;
	private Jugador jugadorActual;
	private Pregunta preguntaActual;
	ArrayList<ArrayList<Opcion>> respuestasDeJugadores;
	int indexJugadorActual;
	int indexPreguntaActual;
	Exclusividad exclusividadActual;
	private ArrayList<Observer> observers;

	public Juego() {
		//this.turno = new Turno();
		//this.estado = Estado.INICIO;

		this.preguntaActual = new Parser().parsear();
		this.respuestasDeJugadores = new ArrayList<>();
		this.respuestasDeJugadores.add(new ArrayList<>());
		this.respuestasDeJugadores.add(new ArrayList<>());
		this.indexJugadorActual = 0;
		this.indexPreguntaActual = 0;
		observers = new ArrayList<>();
	}


	public void empezarJuego(String nombreJugador1, String nombreJugador2) {
		Jugador jugador1 = new Jugador(nombreJugador1);
		Jugador jugador2 = new Jugador(nombreJugador2);
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		this.jugadorInicial = jugador1;
		this.jugadorActual = jugadorInicial;
		exclusividadActual = new SinExclusividad();
		this.notifyObservers();
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
		this.notifyObservers();
	}

	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	public void activarExclusividad(){
		this.exclusividadActual = preguntaActual.activarExclusividad(exclusividadActual);
	}

	public void activarMultiplicadorX2() {
		jugadorActual.setMultiplicador(new MultiplicadorX2());
	}
	public void activarMultiplicadorX3() {
		jugadorActual.setMultiplicador(new MultiplicadorX3());
	}

	public Pregunta getPreguntaActual() {
		return this.preguntaActual;
	}

	public String getTipoPregunta() {
		return this.preguntaActual.getTipoPregunta();
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(Observer::update);
	}
	public Jugador getGanador(){
		if(jugadorActual.getPuntos() > jugadorActual.getJugadorSiguiente().getPuntos()) return jugadorActual;
		return jugadorActual.getJugadorSiguiente();
	}
}
