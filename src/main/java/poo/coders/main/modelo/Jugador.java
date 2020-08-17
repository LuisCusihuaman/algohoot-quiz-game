package poo.coders.main.modelo;

import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorBasico;

import java.util.ArrayList;
import java.util.List;

public class Jugador{

	private String nombre;
	private int puntajeJugador = 0;
	private ArrayList<Opcion> respuestasElegidas;
	private int multiplicador;
	private Multiplicador multiplicadorClase;

	public Jugador(String nombre) {
		this.nombre = nombre;
		respuestasElegidas = new ArrayList<>();
		multiplicador = 2;
		this.multiplicadorClase = new MultiplicadorBasico();
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
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas) {
		puntajeJugador = puntajeJugador + (multiplicador * pregunta.obtenerPuntaje(respuestasElegidas));
	}


	public int puntajeEnPregunta(Pregunta pregunta){
		return multiplicador * pregunta.obtenerPuntaje(this.respuestasElegidas);
	}

}
