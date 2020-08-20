package poo.coders.main.modelo;

import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorBasico;

import java.util.ArrayList;
import java.util.List;

public class Jugador{

	private String nombre;
	private int puntajeJugador = 0;
	private int multiplicador;
	private Multiplicador multiplicadorClase;
	private ArrayList<Opcion> respuestasElegidas;
	private Jugador jugadorSiguiente;


	public Jugador(String nombre) {
		this.nombre = nombre;
		respuestasElegidas = new ArrayList<>();
		multiplicador = 2;
		this.multiplicadorClase = new MultiplicadorBasico();
	}

	public void setJugadorSiguiente(Jugador jugadorSiguiente){
		this.jugadorSiguiente = jugadorSiguiente;
	}
	public Jugador getJugadorSiguiente(){
		return this.jugadorSiguiente;
	}

	public void elegirOpcion(Opcion opcion){
		respuestasElegidas.add(opcion);
	}
	public void elegirOpciones(ArrayList<Opcion> respuestasElegidas){
		this.respuestasElegidas = respuestasElegidas;
	}
	public void setMultiplicador(Multiplicador multiplicadorClase) {
		this.multiplicadorClase = multiplicadorClase;
	}

	public int getPuntos() {
		return puntajeJugador;
	}

	public String getNombre(){
		return nombre;
	}

	public void ganarPuntaje(int puntaje) {
		this.puntajeJugador += this.multiplicadorClase.modificarPuntos(puntaje);
		this.setMultiplicador(new MultiplicadorBasico());
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas) {
		this.ganarPuntaje(pregunta.obtenerPuntaje(respuestas));
	}


	public int puntajeEnPregunta(Pregunta pregunta){
		return multiplicador * pregunta.obtenerPuntaje(this.respuestasElegidas);
	}

	public void elegirRespuestasAPreguntaActual(ArrayList<Opcion> respuestasElegidas){
		this.respuestasElegidas = respuestasElegidas;
	}

	public ArrayList<Opcion> getRespuestasElegidas() {
		return this.respuestasElegidas;
	}
}
