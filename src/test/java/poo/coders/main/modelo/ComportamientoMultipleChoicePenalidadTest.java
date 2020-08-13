package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ComportamientoMultipleChoicePenalidadTest {
	@Test
	public void test00_1SeCreaElComportamientoCon5OpcionesYNoLanzaException(){
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));
		opcionesOriginales.add(new Opcion("2", ""));
		opcionesOriginales.add(new Opcion("3", ""));
		opcionesOriginales.add(new Opcion("4", ""));
		opcionesOriginales.add(new Opcion("5", ""));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoMultipleChoicePenalidad comportamiento = new ComportamientoMultipleChoicePenalidad(opcionesOriginales);
		});

	}

	@Test
	public void test00_2SeCreaElComportamientoCon1OpcionYLanzaException(){
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoicePenalidad comportamiento = new ComportamientoMultipleChoicePenalidad(opcionesOriginales);
		});
	}
	@Test
	public void test00_3SeCreaElComportamientoCon6OpcionesYLanzaException(){
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));
		opcionesOriginales.add(new Opcion("2", ""));
		opcionesOriginales.add(new Opcion("3", ""));
		opcionesOriginales.add(new Opcion("4", ""));
		opcionesOriginales.add(new Opcion("5", ""));
		opcionesOriginales.add(new Opcion("6", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoicePenalidad comportamiento = new ComportamientoMultipleChoicePenalidad(opcionesOriginales);
		});
	}


	@Test
	public void test01JugadorResponde3OpcionesCorrectasYRecibe3Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(3, jugador.getPuntos());
	}

	@Test
	public void test02JugadorResponde2OpcionesCorrectasY2IncorrectasRecibe2Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionCorrecta("Correcta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorResponde4OpcionesIncorrectamenteYDeberiaTenerMenos4Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> respuestas = new ArrayList<>();

		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestas.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestas);

		Assertions.assertEquals((-4), jugador.getPuntos());
	}


}
