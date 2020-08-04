package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoGroupChoiceTest {

	@Test
	public void test01JugadorColocaTodasCorrectasEnElGrupoCorrespondienteYDeberiaRecibir1Punto(){
		ArrayList<String> textoRespuestasCorrectas = new ArrayList<>(List.of("A", "B", "C"));
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice(textoRespuestasCorrectas));
		Jugador jugador = new Jugador("");
		Jugador jugador2 = new Jugador("");

		ArrayList<String> textoRespuestasJugador = new ArrayList<>(List.of("A", "B", "C"));
		ArrayList<String> textoRespuestasJugador2 = new ArrayList<>(List.of("C", "A", "B"));


		jugador.procesarPregunta(pregunta, textoRespuestasJugador);
		jugador2.procesarPregunta(pregunta, textoRespuestasJugador2);

		Assertions.assertEquals(1, jugador.getPuntos());
		Assertions.assertEquals(1, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorColocaMitadDeLasRespuestasCorrectasEnElGrupoCorrespondienteYDeberiaDeRecibir0Puntos(){
	ArrayList<String> textoRespuestasCorrectas = new ArrayList<>(List.of("A", "B", "C", "C", "D"));
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice(textoRespuestasCorrectas));
		Jugador jugador = new Jugador("");

		ArrayList<String> textoRespuestasJugador = new ArrayList<>(List.of("B", "A"));

		jugador.procesarPregunta(pregunta, textoRespuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorColoca2RespuestasCorrectamenteY1IncorrectaEnElGrupoDeLosCorrectos(){
		ArrayList<String> textoRespuestasCorrectas = new ArrayList<>(List.of("A", "B", "C", "C", "D"));
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice(textoRespuestasCorrectas));
		Jugador jugador = new Jugador("");

		ArrayList<String> textoRespuestasJugador = new ArrayList<>(List.of("B", "A", "F"));

		jugador.procesarPregunta(pregunta, textoRespuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test04JugadorColocaTodasIncorrectasEnElGrupoDeLosCorrectos(){
		ArrayList<String> textoRespuestasCorrectas = new ArrayList<>(List.of("A", "B", "C", "C", "D"));
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice(textoRespuestasCorrectas));
		Jugador jugador = new Jugador("");

		ArrayList<String> textoRespuestasJugador = new ArrayList<>(List.of("T", "G", "P"));

		jugador.procesarPregunta(pregunta, textoRespuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
