package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuntajeTests {
	@Test
	public void test01PuntajeClasicoDevuelveCeroCuandoSeAnula() {
		PuntajeClasico puntaje = new PuntajeClasico();

		puntaje.incrementarPuntaje();
		puntaje.incrementarPuntaje();
		puntaje.anularPuntaje();

		Assertions.assertEquals(0, puntaje.getPuntajeAcumulado());
	}

}
