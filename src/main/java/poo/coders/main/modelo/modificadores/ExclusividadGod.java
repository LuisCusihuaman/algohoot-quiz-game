package poo.coders.main.modelo.modificadores;

import poo.coders.main.modelo.Jugador;
import poo.coders.main.modelo.ModificadorGod;
import poo.coders.main.modelo.Pregunta;

import java.util.ArrayList;

public class ExclusividadGod extends ModificadorGod {
	private ArrayList<Jugador> jugadores;
	private int multiplicadorExclusividad;

	public ExclusividadGod(Jugador jugador1, Jugador jugador2){
		this.jugadores = new ArrayList<>();
		jugadores.add(jugador1);
		jugadores.add(jugador2);
		multiplicadorExclusividad = 1;
	}

	public void agregarJugador(Jugador jugador){
		jugadores.add(jugador);
	}

	public void activarExclusividad(){
		//TODO: if(this.multiplicadorExclusividad == 4) throw new ExclusividadActivadaDemasiadasVecesException();
		this.multiplicadorExclusividad *= 2;
	}

	public void aplicarModificador(Pregunta pregunta){
		int puntajeJugador1 = jugadores.get(0).puntajeEnPregunta(pregunta);
		int puntajeJugador2 = jugadores.get(1).puntajeEnPregunta(pregunta);
		if(puntajeJugador1 == puntajeJugador2){
			jugadores.get(0).ganarPuntaje(puntajeJugador1);
			jugadores.get(1).ganarPuntaje(puntajeJugador2);
			return;
		}
		if(puntajeJugador1 > puntajeJugador2){
			jugadores.get(0).ganarPuntaje(puntajeJugador1*multiplicadorExclusividad);
		}else{
			jugadores.get(1).ganarPuntaje(puntajeJugador1*multiplicadorExclusividad);
		}
	}
}
	/*
	private int multiplicadorExclusividad;


	Exclusividad(){
		this.multiplicadorExclusividad = 1;
	}

	public int aplicar(int puntajeOriginal){
		return puntajeOriginal * multiplicadorExclusividad;
	}

	public void activarExclusividad(){
		this.multiplicadorExclusividad *= 2;
		if(this.multiplicadorExclusividad > 4) throw new RuntimeException();
	}

	public void darPuntosAJugadores(Jugador jugador1, Jugador jugador2, int puntajeJugador1, int puntajeJugador2) {
		if(this.multiplicadorExclusividad == 1){
			jugador1.ganarPuntaje(puntajeJugador1);
			jugador2.ganarPuntaje(puntajeJugador2);
		}else {
			if (puntajeJugador1 != puntajeJugador2) {
				if (puntajeJugador1 > puntajeJugador2) {
					jugador1.ganarPuntaje(multiplicadorExclusividad * puntajeJugador1);
				} else {
					jugador2.ganarPuntaje(multiplicadorExclusividad * puntajeJugador2);
				}
			}
		}

	}

	 */
