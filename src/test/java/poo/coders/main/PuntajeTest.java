package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PuntajeTest {
	@Test
	public void test01PuntajeClasicoDevuelveCeroCuandoSeAnula() {
		PuntajeClasico puntaje = new PuntajeClasico();

		puntaje.accionCorrecta();
		puntaje.accionCorrecta();
		puntaje.accionIncorrecta();

		Assertions.assertEquals(0, puntaje.getPuntajeAcumulado());
	}

	@Test
	public void test02PuntajeClasicoSeIncrementaVariasVecesDevuelve1() {
		PuntajeClasico puntaje = new PuntajeClasico();

		puntaje.accionCorrecta();
		puntaje.accionCorrecta();
		puntaje.accionCorrecta();

		Assertions.assertEquals(1, puntaje.getPuntajeAcumulado());
	}

	@Test
	public void test03PuntajeParcialSeIncrementa3VecesDevuelvePuntaje3() {
		PuntajeParcial puntaje = new PuntajeParcial();

		puntaje.accionCorrecta();
		puntaje.accionCorrecta();
		puntaje.accionCorrecta();

		Assertions.assertEquals(3, puntaje.getPuntajeAcumulado());
	}

	@Test
	public void test04PuntajeParcialSeIncrementa2VecesYSeAnulaUnaVezDevuelvePuntaje0() {
		PuntajeParcial puntaje = new PuntajeParcial();

		puntaje.accionCorrecta();
		puntaje.accionCorrecta();
		puntaje.accionIncorrecta();

		Assertions.assertEquals(0, puntaje.getPuntajeAcumulado());
	}

	@Test
	public void test05PuntajePenalidadSeIncrementa1VezDevuelvePuntaje1() {
		Puntaje puntaje = new PuntajePenalidad();

		puntaje.accionCorrecta();

		Assertions.assertEquals(1, puntaje.getPuntajeAcumulado());
	}

	@Test
	public void test06PuntajePenalidadSeAnulaDevuelvePuntajeMenos1() {
		Puntaje puntaje = new PuntajePenalidad();

		puntaje.accionIncorrecta();

		Assertions.assertEquals(-1, puntaje.getPuntajeAcumulado());
	}
}
