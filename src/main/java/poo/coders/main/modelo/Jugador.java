package poo.coders.main.modelo;

import poo.coders.main.modelo.modificadores.Multiplicador;

import java.util.ArrayList;
import java.util.List;

public class Jugador{

	private String nombre;
	private int puntajeJugador = 0;
	private ArrayList<Opcion> respuestasElegidas;
	private int multiplicador;
	public Jugador(String nombre) {
		this.nombre = nombre;
		respuestasElegidas = new ArrayList<>();
		multiplicador = 2;

	}

	public void elegirOpcion(Opcion opcion){
		respuestasElegidas.add(opcion);
	}
	public void elegirOpciones(ArrayList<Opcion> respuestasElegidas){
		this.respuestasElegidas = respuestasElegidas;
	}


	public int getPuntos() {
		return puntajeJugador;
	}

	public String getNombre(){
		return nombre;
	}

	public void ganarPuntaje(int puntaje) {
		this.puntajeJugador += puntaje;
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas) {
		puntajeJugador = puntajeJugador + (multiplicador * pregunta.obtenerPuntaje(respuestasElegidas));
	}


	public int puntajeEnPregunta(Pregunta pregunta){
		return multiplicador * pregunta.obtenerPuntaje(this.respuestasElegidas);
	}

}
