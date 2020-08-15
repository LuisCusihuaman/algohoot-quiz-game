package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoicePenalidad;
import poo.coders.main.modelo.comportamientos.ComportamientoVoFPenalidad;

import java.util.ArrayList;

public class JugadorITest {
	@Test
	public void test01JugadorUsaMutiplicadorX2YContestaConRespuestaCorrectaGana2Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", ""));

		jugador.usarMultiplicadorX2EnPregunta(pregunta);
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(2, jugador.getPuntos());
	}

	@Test
	public void test02JugadorUsaMultiplicadorX3YContestaConRespuestaIncorrectaTieneMenos3Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.usarMultiplicadorX3EnPregunta(pregunta);
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(-3, jugador.getPuntos());
	}

	@Test
	public void test03JugadorUsaMultiplicadorPor3YContestaCon3RespuestasCorrectasGana9Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", ""));
		respuestasJugador.add(new OpcionCorrecta("Correcta", ""));
		respuestasJugador.add(new OpcionCorrecta("Correcta", ""));

		jugador.usarMultiplicadorX3EnPregunta(pregunta);
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(9, jugador.getPuntos());
	}

	@Test
	public void test04JugadorUsaMultiplicadorPor2YContestaCon3RespuestasIncorrectasTieneMenos6Puntos() {
		Pregunta pregunta = new Pregunta("", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("");
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestasJugador.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestasJugador.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.usarMultiplicadorX2EnPregunta(pregunta);
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(-6, jugador.getPuntos());
	}
}
