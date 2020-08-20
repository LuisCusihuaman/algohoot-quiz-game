package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceParcial;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.comportamientos.ComportamientoVoFPenalidad;

import java.util.ArrayList;

public class JuegoConDiferentesTiposDePreguntasITests {
	@Test
	public void test01JugadorContestaCon3RespuestasCorrectasDeMultipleChoiceParcialYVoFPenalidadConUnaIncorrectaTienePuntaje2() {
		Jugador jugador = new Jugador("marcos");
		Pregunta preguntaMultipleChoice = new Pregunta("cuales son personajes anime??", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasDeJugador = new ArrayList<>();
		respuestasDeJugador.add(new OpcionConjunto("Correcta", "naruto", "Correcta"));
		respuestasDeJugador.add(new OpcionConjunto("Correcta", "saske", "Correcta"));
		respuestasDeJugador.add(new OpcionConjunto("Correcta", "jiraiya", "Correcta"));
		jugador.procesarPregunta(preguntaMultipleChoice, respuestasDeJugador);
		respuestasDeJugador.clear();
		Pregunta preguntaVoFPenalidad = new Pregunta("", new ComportamientoVoFPenalidad());
		respuestasDeJugador.add(new OpcionConjunto("Incorrecta", "", "Correcta"));
		jugador.procesarPregunta(preguntaVoFPenalidad, respuestasDeJugador);

		Assertions.assertEquals(2, jugador.getPuntos());
	}

	@Test
	public void test02JugadorContestaCon2CorrectasDeChoiceClasicoYUnaIncorrectaDeVoFTienePuntaje1() {
		Jugador jugador = new Jugador("");
		Pregunta preguntaMultipleChoiceClasico = new Pregunta("", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasJugador.add(new OpcionConjunto("Correcta", "", "Correcta"));
		jugador.procesarPregunta(preguntaMultipleChoiceClasico, respuestasJugador);
		respuestasJugador.clear();
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		respuestasJugador.add(new OpcionConjunto("Correcta", "", "Incorrecta"));
		jugador.procesarPregunta(preguntaVoF, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}
}
