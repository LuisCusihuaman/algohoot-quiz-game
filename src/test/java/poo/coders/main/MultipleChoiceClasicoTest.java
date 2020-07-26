package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MultipleChoiceClasicoTest{

	@Test
	public void test01JugadorResponde2RespuestasCorrectasYsuma2Puntos(){
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");

		ArrayList<Respuesta> respuestas = new ArrayList<>();
		respuestas.add(new RespuestaCorrecta());
		respuestas.add(new RespuestaCorrecta());

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(2, jugador.getPuntos());
	}
}
