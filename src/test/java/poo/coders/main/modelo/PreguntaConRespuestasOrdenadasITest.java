package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoOrderedChoice;

import java.util.ArrayList;

public class PreguntaConRespuestasOrdenadasITest {
	@Test
	public void test01JugadorRespondeCon3RespuestasQueEstanOrdenadasGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoOrderedChoice());

		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionConjunto(new Opcion("1", ""), "1"));
		respuestasJugador.add(new OpcionConjunto(new Opcion("2", ""), "2"));
		respuestasJugador.add(new OpcionConjunto(new Opcion("3", ""), "3"));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorRespondeCon3RespuestasDesordenadasNoGanaPuntos() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoOrderedChoice());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionConjunto(new Opcion("1", ""), "1"));
		respuestasJugador.add(new OpcionConjunto(new Opcion("2", ""), "3"));
		respuestasJugador.add(new OpcionConjunto(new Opcion("3", ""), "2"));


		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
