package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class Juego {

	private Turno turno;
	private List<Jugador> jugadores;
	private List<Pregunta> preguntas;
	private Estado estado;

	public Juego() {
		this.turno = new Turno();
		this.jugadores = new ArrayList<>();
		this.preguntas = new Parser().parsear();
		this.estado = Estado.INICIO;
	}


	public void inicializar(String nombreJugador1, String nombreJugador2){
		this.jugadores.add(new Jugador(nombreJugador1));
		this.jugadores.add(new Jugador(nombreJugador2));
		this.turno.asignarJugadores(this.jugadores);
		this.estado = Estado.EN_JUEGO;

	}

	public String getPregunta(){
		return preguntas.get(0).getEnunciado();
	}

	public String getNombre(){
		return jugadores.get(0).getNombre();
	}

	public String getTipoPregunta(){
		return preguntas.get(0).getTipoPregunta();
	}


}
