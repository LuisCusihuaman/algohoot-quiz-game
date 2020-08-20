package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoVoFPenalidad;

import java.util.ArrayList;

class ComportamientoVoFPenalidadITest {

	@Test
	public void test01ObtenerPuntajeConUnaOpcionCorrectaEnComportamientoVoFPenalidadDevuelveUnPunto() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("Incorrecta", "","1"));

		Assertions.assertEquals(-1, pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}

	@Test
	public void test02ObtenerPuntajeConUnaOpcionIncorrectaEnComportamientoVoFPenalidadDevuelveMenosUnPunto() {
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("2", "","1"));

		Assertions.assertEquals(-1, pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}

	@Test
	public void test03SeIngresanMasDeDosOpcionesEnComportamientoVoFPenalidadLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));
		opcionesOriginales.add(new Opcion("2", ""));
		opcionesOriginales.add(new Opcion("3", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoVoFPenalidad comportamiento = new ComportamientoVoFPenalidad(opcionesOriginales);
		});
	}

	@Test
	public void test04SeIngresanMenosDeDosOpcionesEnComportamientoVoFPenalidadLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoVoFPenalidad comportamiento = new ComportamientoVoFPenalidad(opcionesOriginales);
		});
	}

	@Test
	public void test05SeIngresanDosOpcionesEnComportamientoVoFPenalidadNoLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1",""));
		opcionesOriginales.add(new Opcion("2",""));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoVoFPenalidad comportamiento = new ComportamientoVoFPenalidad(opcionesOriginales);
		});
	}
}
