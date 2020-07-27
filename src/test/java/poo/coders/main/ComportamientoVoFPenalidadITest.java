package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ComportamientoVoFPenalidadITest {

	@Test
	void CreoPreguntaVoFPenalidadIndicandoCualEsLaRespuestaCorrecta() {
		Pregunta             pregunta        = new Pregunta("Este es el mejor TP.", new ComportamientoVoFPenalidad());
		RespuestaCorrecta    correcta        = new RespuestaCorrecta();
		ArrayList<Respuesta> listaRespuestas = new ArrayList<>();
		listaRespuestas.add(correcta);
		Puntos diferencialPuntos = pregunta.obtenerPuntaje(listaRespuestas);
		Assertions.assertEquals(1, diferencialPuntos.getCantidadPuntos());
	}
}
