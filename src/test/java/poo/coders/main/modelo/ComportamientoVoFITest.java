package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;

import java.util.ArrayList;

public class ComportamientoVoFITest {
	@Test
	void test01ObtenerPuntajeConUnaOpcionCorrectaEnComportamientoVoFDevuelve1Punto() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("1","","1"));

		Assertions.assertEquals(1, pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}

	@Test
	public void test02ObtenerPuntajeConUnaOpcionIncorrectaEnComportamientoVoFNoDevuelvePuntos() {
		Pregunta pregunta = new Pregunta("Texto de Pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("1", "", "2"));

		Assertions.assertEquals(0,pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}

	@Test
	public void test02SeIngresanMasDeDosOpcionesEnComportamientoVoFYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new OpcionConjunto("1", "","1"));
		opcionesOriginales.add(new OpcionConjunto("2", "","2"));
		opcionesOriginales.add(new OpcionConjunto("3", "","3"));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoVoF comportamiento = new ComportamientoVoF(opcionesOriginales);
		});
	}

	@Test
	public void test03SeIngresanMenosDeDosOpcionesEnComportamientoVoFYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new OpcionConjunto("1", "","1"));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoVoF comportamiento = new ComportamientoVoF(opcionesOriginales);
		});
	}

	@Test
	public void test04SeIngresanDosOpcionesYNoLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new OpcionConjunto("1", "", "1"));
		opcionesOriginales.add(new OpcionConjunto("2", "","2"));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoVoF comportamiento = new ComportamientoVoF(opcionesOriginales);
		});
	}
}
