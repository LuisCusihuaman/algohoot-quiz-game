package poo.coders.Main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class PreguntaVoFTests {

	@Test
	void test01CreoPreguntaVoFIndicandoCualEsLaRespuestaCorrecta(){
		Jugador jugador = new Jugador("Pepito");
		Puntos diferencialPuntos = new Puntos();

		Pregunta pregunta = new Pregunta("Este es el mejor TP.", new ComportamientoVoF());
		RespuestaCorrecta correcta = new RespuestaCorrecta();

		ArrayList<Respuesta> listaRespuestas = new ArrayList<Respuesta>();
		listaRespuestas.add(correcta);
		pregunta.calcularPuntaje(listaRespuestas);

		Assertions.assertEquals(1, diferencialPuntos.getCantidadPuntos());

	}
}
