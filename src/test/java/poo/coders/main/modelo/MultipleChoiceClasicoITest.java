package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MultipleChoiceClasicoITest {
	@Test
	public void test01JugadorContestaTodoCorrectamenteYRecibe1Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorContesta2CorrectamenteY1IncorrectamenteYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorContesta4CorrectamenteY1IncorrectamenteYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test04JugadorContestaTodoIncorrectamenteYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test05JugadorContesta2CorrectamenteY1IncorrectamenteEnPrimerLugarYRecibe0Punto() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceClasico());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
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
