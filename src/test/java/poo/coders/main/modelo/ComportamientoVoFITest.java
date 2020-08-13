package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ComportamientoVoFITest {
	@Test
	void test01PreguntaVoFRecibeListaDeRespuestasYAsignaPuntosCorrectamente() {
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

	@Test
	public void test02SeIngresanMasDeDosOpcionesEnComportamientoVoFYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));
		opcionesOriginales.add(new Opcion("2",""));
		opcionesOriginales.add(new Opcion("3",""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoVoF comportamiento = new ComportamientoVoF(opcionesOriginales);
		});
	}

	@Test
	public void test03SeIngresanMenosDeDosOpcionesEnComportamientoVoFYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoVoF comportamiento = new ComportamientoVoF(opcionesOriginales);
		});
	}

	@Test
	public void test04SeIngresanDosOpcionesYNoLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));
		opcionesOriginales.add(new Opcion("2", ""));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoVoF comportamiento = new ComportamientoVoF(opcionesOriginales);
		});
	}
}
