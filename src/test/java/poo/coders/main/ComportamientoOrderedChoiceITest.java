package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComportamientoOrderedChoiceITest {
	@Test
	public void test01OrdenCorrectoEsABCYElJugadorRespondeConABCEntoncesTienePuntaje1() {
		Pregunta pregunta = new Pregunta("", new ComportamientoOrderedChoice());
		Jugador jugador = new Jugador("");
		List<String> textoRespuestasOrdenadas = List.of("A", "B", "C");
		List<String> textoRespuestasJugador = List.of("A", "B", "C");
		InterpretadorOrderedChoice interpretador = new InterpretadorOrderedChoice(textoRespuestasOrdenadas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02OrdenCorrectoEsABCYJugadorRespondeConACBEntoncesTienePuntaje0() {
		Pregunta pregunta = new Pregunta("", new ComportamientoOrderedChoice());
		Jugador jugador = new Jugador("");
		List<String> textoRespuestasOrdenadas = List.of("A", "B", "C");
		List<String> textoRespuestasJugador = List.of("A", "C", "B");
		InterpretadorOrderedChoice interpretador = new InterpretadorOrderedChoice(textoRespuestasOrdenadas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
