package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComportamientoGroupChoiceTest {

	@Test
	public void test01JugadorColocaTodasCorrectasEnElGrupoCorrespondienteYDeberiaRecibir1Punto(){
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		Jugador jugador = new Jugador("");
		Jugador jugador2 = new Jugador("");

		List<String> textoRespuestasCorrectas = List.of("A", "B", "C");
		List<String> textoRespuestasJugador = List.of("A", "B", "C");
		List<String> textoRespuestasJugador2 = List.of("C", "A", "B");
		InterpretadorGroupChoice interpretador = new InterpretadorGroupChoice(textoRespuestasCorrectas);
		InterpretadorGroupChoice interpretador2 = new InterpretadorGroupChoice(textoRespuestasCorrectas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));
		jugador2.procesarPregunta(pregunta, interpretador2.evaluarRespuestas(textoRespuestasJugador2));

		Assertions.assertEquals(1, jugador.getPuntos());
		Assertions.assertEquals(1, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorColocaMitadDeLasRespuestasCorrectasEnElGrupoCorrespondienteYDeberiaDeRecibir0Puntos(){
		//jugador coloca 2 correctas y 1 incorrecta y no da puntos
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		Jugador jugador = new Jugador("");

		List<String> textoRespuestasCorrectas = List.of("A", "B", "C", "D");
		List<String> textoRespuestasJugador = List.of("B", "A");
		InterpretadorGroupChoice interpretador = new InterpretadorGroupChoice(textoRespuestasCorrectas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorColoca2RespuestasCorrectamenteY1IncorrectaEnElGrupoDeLosCorrectos(){
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		Jugador jugador = new Jugador("");

		List<String> textoRespuestasCorrectas = List.of("A", "B", "C", "D");
		List<String> textoRespuestasJugador = List.of("B", "A", "F");
		InterpretadorGroupChoice interpretador = new InterpretadorGroupChoice(textoRespuestasCorrectas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test04JugadorColocaTodasIncorrectasEnElGrupoDeLosCorrectos(){
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		Jugador jugador = new Jugador("");

		List<String> textoRespuestasCorrectas = List.of("A", "B", "C", "D");
		List<String> textoRespuestasJugador = List.of("T", "G", "P");
		InterpretadorGroupChoice interpretador = new InterpretadorGroupChoice(textoRespuestasCorrectas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
