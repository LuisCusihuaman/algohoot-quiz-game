package poo.coders.main.modelo;

import javafx.application.Platform;

import java.util.ArrayList;

public class JuegoMock implements Observable {
	private ArrayList<Observer> observers;
	private ArrayList<Jugador> jugadores;
	private ArrayList<Pregunta> preguntas;
	ArrayList<ArrayList<Opcion>> respuestasDeJugadores;
	int indexJugadorActual;
	int indexPreguntaActual;

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void notifyObservers() {
		observers.forEach(Observer::update);
	}

	public JuegoMock() {
		this.jugadores = new ArrayList<>();
		this.jugadores.add(new Jugador("Jug1"));
		this.jugadores.add(new Jugador("Jug2"));
		this.preguntas = new Parser().parsear();
		this.respuestasDeJugadores = new ArrayList<>();
		this.respuestasDeJugadores.add(new ArrayList<>());
		this.respuestasDeJugadores.add(new ArrayList<>());
		this.indexJugadorActual = 0;
		this.indexPreguntaActual = 0;
		observers = new ArrayList<>();
	}

	public void empezarJuego(String nombreJugador1, String nombreJugador2) {
		this.jugadores.set(0, new Jugador(nombreJugador1));
		this.jugadores.set(1, new Jugador(nombreJugador2));
		this.notifyObservers();
	}

	public void siguienteTurno(ArrayList<Opcion> respuestasJugadorActual) {
		respuestasDeJugadores.set(indexJugadorActual, respuestasJugadorActual);
		indexJugadorActual++;
		indexJugadorActual %= jugadores.size();
		if (indexJugadorActual == 0) {
			//preguntas.get(indexPreguntaActual).darPuntosAJugadores(jugadores.get(0), jugadores.get(1), respuestasDeJugadores.get(0), respuestasDeJugadores.get(1));
			if (preguntas.size() - 1 != indexPreguntaActual) {
				indexPreguntaActual++;
			} else {
				Platform.exit();
			}
		}
		this.notifyObservers();
	}

	public Jugador getJugadorActual() {
		return jugadores.get(indexJugadorActual);
	}

	public Pregunta getPreguntaActual() {
		return preguntas.get(indexPreguntaActual);
	}

	public String getTipoPregunta() {
		return preguntas.get(indexPreguntaActual).getTipoPregunta();
	}

	public Opcion evaluarOpcion(Opcion opcionActual) {
		Opcion opConvertida = this.getPreguntaActual().evaluarOpcion(opcionActual);
		return opConvertida;
	}
}
