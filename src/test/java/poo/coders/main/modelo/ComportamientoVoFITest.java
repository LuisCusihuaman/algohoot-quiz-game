package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ComportamientoVoFITest {
	@Test
	void test02PreguntaVoFRecibeListaDeRespuestasYAsignaPuntosCorrectamente() {
		Jugador tomas = new Jugador("Tomas");
		Jugador kevin = new Jugador("Kevin");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		ArrayList<Opcion> respuestasTomas = new ArrayList<>();
		ArrayList<Opcion> respuestasKevin = new ArrayList<>();
		respuestasTomas.add(new OpcionCorrecta("Correcta", ""));
		respuestasKevin.add(new OpcionIncorrecta("Incorrecta", ""));

		tomas.procesarPregunta(pregunta, respuestasTomas);
		kevin.procesarPregunta(pregunta, respuestasKevin);

		Assertions.assertEquals(1, tomas.getPuntos());
		Assertions.assertEquals(0, kevin.getPuntos());
	}
}
