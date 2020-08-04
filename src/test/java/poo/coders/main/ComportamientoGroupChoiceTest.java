package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComportamientoGroupChoiceTest {

	@Test
	public void test01JugadorColocaTodasCorrectasYDeberiaRecibir1Punto(){
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		Jugador jugador = new Jugador("");

		List<String> textoRespuestas = List.of("A", "B", "C");
		List<String> textoRespuestasJugador = List.of("A", "B", "C");
		InterpretadorGroupChoice interpretador = new InterpretadorGroupChoice(textoRespuestas);

		jugador.procesarPregunta(pregunta, interpretador.evaluarRespuestas(textoRespuestasJugador));

		Assertions.assertEquals(1, jugador.getPuntos());
	}



	//jugador coloca 3 correctas y 0 incorrecta y debe recibir 1 punto
	//jugador coloca 2 correctas y 1 incorrecta y no da puntos
	//jugador coloca 3 opciones incorrectamente y no da puntos
	//jugador coloca 2 opciones incorrectas y 1 correcta y no da puntos


}
