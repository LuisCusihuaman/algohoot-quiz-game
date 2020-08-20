package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceParcial;
import poo.coders.main.modelo.modificadores.Exclusividad;
import poo.coders.main.modelo.modificadores.SinExclusividad;

import java.util.ArrayList;

public class MultipleChoiceParcialITest {

	@Test
	public void test01JugadorContestaCon3RespuestasCorrectasDevuelve3Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "1")); // Correcta
		respuestas.add(new OpcionConjunto("2", "", "2")); // Correcta
		respuestas.add(new OpcionConjunto("3", "", "3")); // Correcta

		Assertions.assertEquals(3, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test02JugadorContestaCon2RespuestasCorrectasYUnaIncorrectaAlFinalTienePuntos0() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "1")); // Correcta
		respuestas.add(new OpcionConjunto("2", "", "2")); // Correcta
		respuestas.add(new OpcionConjunto("3", "", "1")); // Incorrecta

		Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test03JugadorContestaPrimeroConRespuestaIncorrectaYLuegoCon2RespuestasCorrectasYDevuelve0Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestas = new ArrayList<>();
		respuestas.add(new OpcionConjunto("1", "", "2")); // Incorrecta
		respuestas.add(new OpcionConjunto("2", "", "2")); // Correcta
		respuestas.add(new OpcionConjunto("3", "", "3")); // Correcta

		Assertions.assertEquals(0, pregunta.obtenerPuntaje(respuestas));
	}

	@Test
	public void test04JuegoEntreDosJugadoresCon3Preguntas() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoiceParcial());
		Jugador jugador1 = new Jugador("Jugador 1");
		Jugador jugador2 = new Jugador("Jugador 2");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Exclusividad exclusividad = new SinExclusividad();

		ArrayList<Opcion> respuestasDeJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasDeJugador2 = new ArrayList<>();

		//	Multiple Choice con 2 respuestas y una respuesta incorrecta
		respuestasDeJugador1.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador1.add(new OpcionConjunto("Correcta", "", "Correcta"));

		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Incorrecta"));

		jugador1.elegirRespuestasAPreguntaActual(respuestasDeJugador1);
		jugador2.elegirRespuestasAPreguntaActual(respuestasDeJugador2);

		exclusividad.definirPuntosJugadoresEnPregunta(pregunta, jugador1);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());

		respuestasDeJugador1.clear();
		respuestasDeJugador2.clear();

		// Jugador 1 responde una correcta y Jugador 2 responde 3 correctas
		respuestasDeJugador1.add(new OpcionConjunto("Correcta", "", "Correcta"));

		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));

		jugador1.elegirRespuestasAPreguntaActual(respuestasDeJugador1);
		jugador2.elegirRespuestasAPreguntaActual(respuestasDeJugador2);

		exclusividad.definirPuntosJugadoresEnPregunta(pregunta, jugador1);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(3, jugador2.getPuntos());

		respuestasDeJugador1.clear();
		respuestasDeJugador2.clear();


		respuestasDeJugador1.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador1.add(new OpcionConjunto("Correcta", "", "Incorrecta"));

		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));
		respuestasDeJugador2.add(new OpcionConjunto("Correcta", "", "Correcta"));

		jugador1.elegirRespuestasAPreguntaActual(respuestasDeJugador1);
		jugador2.elegirRespuestasAPreguntaActual(respuestasDeJugador2);

		exclusividad.definirPuntosJugadoresEnPregunta(pregunta, jugador1);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(6, jugador2.getPuntos());
	}

	@Test
	public void test05SeIngresanMasDe5OpcionesEnComportamientoMultipleChoiceParcialYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1",""));
		opcionesOriginales.add(new Opcion("2",""));
		opcionesOriginales.add(new Opcion("3",""));
		opcionesOriginales.add(new Opcion("4",""));
		opcionesOriginales.add(new Opcion("5",""));
		opcionesOriginales.add(new Opcion("6",""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoiceParcial comportamiento = new ComportamientoMultipleChoiceParcial(opcionesOriginales);
		});
	}

	@Test
	public void test06SeIngresanMenosDe2OpcionesEnComportamientoMultipleChoiceParcialYLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoiceParcial comportamiento = new ComportamientoMultipleChoiceParcial(opcionesOriginales);
		});
	}

	@Test
	public void test07SeOpciones2OpcionesEnComportamientoMultipleChoiceParcialYNoLanzaExcepcion() {
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1",""));
		opcionesOriginales.add(new Opcion("2", ""));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoMultipleChoiceParcial comportamiento = new ComportamientoMultipleChoiceParcial(opcionesOriginales);
		});
	}


}
