package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;

import java.util.ArrayList;

public class MultipleChoiceClasicoITest {
	@Test
	public void test01JugadorContestaTodoCorrectamenteYDevuelve1Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "1")); // Correcta
		respuestas.add(new OpcionConjunto("2", "", "2")); // Correcta
		respuestas.add(new OpcionConjunto("3", "", "3")); // Correcta

		Assertions.assertEquals(1, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test02JugadorContesta2CorrectamenteY1IncorrectamenteYDevuelve0Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "1")); // Correcta
		respuestas.add(new OpcionConjunto("2", "", "1")); // Incorrecta
		respuestas.add(new OpcionConjunto("3", "", "3")); // Correcta

		Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test03JugadorContesta4CorrectamenteY1IncorrectamenteYDevuelve0Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "1")); // Correcta
		respuestas.add(new OpcionConjunto("2", "", "1")); // Incorrecta
		respuestas.add(new OpcionConjunto("3", "", "3")); // Correcta
		respuestas.add(new OpcionConjunto("4", "", "4")); // Correcta
		respuestas.add(new OpcionConjunto("5", "", "5")); // Correcta

		Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test04JugadorContestaTodoIncorrectamenteYDevuelve0Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "2")); // Incorrecta
		respuestas.add(new OpcionConjunto("2", "", "1")); // Incorrecta
		respuestas.add(new OpcionConjunto("3", "", "1")); // Incorrecta
		respuestas.add(new OpcionConjunto("4", "", "1")); // Incorrecta
		respuestas.add(new OpcionConjunto("5", "", "1")); // Incorrecta

		Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test05JugadorContesta2CorrectamenteY1IncorrectamenteEnPrimerLugarYDevuelve0Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "2")); // Incorrecta
		respuestas.add(new OpcionConjunto("2", "", "2")); // Correcta
		respuestas.add(new OpcionConjunto("3", "", "3")); // Correcta


		Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test06SeIngresanMasDe5OpcionesEnComportamientoMultipleChoiceClasicoYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1",""));
		opcionesOriginales.add(new Opcion("2",""));
		opcionesOriginales.add(new Opcion("3",""));
		opcionesOriginales.add(new Opcion("4",""));
		opcionesOriginales.add(new Opcion("5",""));
		opcionesOriginales.add(new Opcion("6",""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoiceClasico comportamiento = new ComportamientoMultipleChoiceClasico(opcionesOriginales);
		});
	}

	@Test
	public void test07SeIngresanMenosDe2OpcionesEnComportamientoMultipleChoiceClasicoYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoiceClasico comportamiento = new ComportamientoMultipleChoiceClasico(opcionesOriginales);
		});
	}

	@Test
	public void test08SeIngresan2OpcionesEnComportamientoMultipleChoiceClasicoYNoLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1",""));
		opcionesOriginales.add(new Opcion("2",""));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoMultipleChoiceClasico comportamiento = new ComportamientoMultipleChoiceClasico(opcionesOriginales);
		});
	}
}
