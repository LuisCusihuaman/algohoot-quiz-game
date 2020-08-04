package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoOrderedChoiceITest {
	@Test
	public void test01OrdenCorrectoEsABCYElJugadorRespondeConABCEntoncesTienePuntaje1() {
		ArrayList<String> textoRespuestasOrdenadas = new ArrayList<>(List.of("A", "B", "C"));
		Pregunta pregunta = new Pregunta("", new ComportamientoOrderedChoice(textoRespuestasOrdenadas));
		Jugador jugador = new Jugador("");

		ArrayList<String> textoRespuestasJugador = new ArrayList<>(List.of("A", "B", "C"));

		jugador.procesarPregunta(pregunta, textoRespuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02OrdenCorrectoEsABCYJugadorRespondeConACBEntoncesTienePuntaje0() {
		ArrayList<String> textoRespuestasOrdenadas = new ArrayList<>(List.of("A", "B", "C"));
		Pregunta pregunta = new Pregunta("", new ComportamientoOrderedChoice(textoRespuestasOrdenadas));
		Jugador jugador = new Jugador("");

		ArrayList<String> textoRespuestasJugador = new ArrayList<>(List.of("A", "C", "B"));

		jugador.procesarPregunta(pregunta, textoRespuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
