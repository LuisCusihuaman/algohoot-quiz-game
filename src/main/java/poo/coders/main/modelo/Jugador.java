package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador{

	private String nombre;
	private int puntajeJugador = 0;
	private ArrayList<Opcion> respuestasElegidas;
	private Multiplicador multiplicador;

	public Jugador(String nombre) {
		this.nombre = nombre;
		respuestasElegidas = new ArrayList<>();
		multiplicador = new SinMultiplicador(this);

	}
	public void elegirOpcion(Opcion opcion){
		respuestasElegidas.add(opcion);
	}
	public void elegirOpciones(ArrayList<Opcion> respuestasElegidas){
		this.respuestasElegidas = respuestasElegidas;
	}

	public void procesarPregunta(Pregunta pregunta, List<Opcion> respuestas) {
		puntajeJugador = puntajeJugador + (multiplicador.aplicarMultiplicador(pregunta.obtenerPuntaje(respuestas)));
	}


	public void activarExclusividad(Exclusividad exclusividad) {
		exclusividad.activarExclusividad();
		//TODO: exclusividad.agregarJugadores(this, this.siguienteJugador);

	}

	public void usarMultiplicadorX2EnPregunta(Pregunta pregunta) {
		try {
			MultiplicadorX2 multiplicador = pregunta.crearMultiplicadorX2();
			multiplicador.agregarJugador(this);
			this.multiplicador = multiplicador;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void usarMultiplicadorX3EnPregunta(Pregunta pregunta) {
		try {
			MultiplicadorX3 multiplicador = pregunta.crearMultiplicadorX3();
			multiplicador.agregarJugador(this);
			this.multiplicador = multiplicador;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}


	public int getPuntos() {
		return puntajeJugador;
	}

	public String getNombre(){
		return nombre;
	}

	public int puntajeEnPregunta(Pregunta pregunta){
		return multiplicador.aplicarMultiplicador(pregunta.obtenerPuntaje(this.respuestasElegidas));
	}
	public void ganarPuntaje(int puntajeAGanar) {
		this.puntajeJugador += puntajeAGanar;
	}
	public void siguientePregunta(){
		respuestasElegidas.clear();
	}

}
