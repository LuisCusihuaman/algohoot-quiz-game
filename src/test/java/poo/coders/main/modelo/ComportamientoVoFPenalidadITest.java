package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

class ComportamientoVoFPenalidadITest {
	/*
		@Test
		void deberiaPreguntaVoFPenalidadCrearseCorrectamenteIndicandoleCualEsLaRespuestaCorrecta() {
			Pregunta             pregunta        = new Pregunta("Este es el mejor TP.", new ComportamientoVoFPenalidad());
			RespuestaCorrecta    correcta        = new RespuestaCorrecta();
			ArrayList<Respuesta> listaRespuestas = new ArrayList<>();
			listaRespuestas.add(correcta);
			Puntos diferencialPuntos = pregunta.obtenerPuntaje(listaRespuestas);
			Assertions.assertEquals(1, diferencialPuntos.getCantidadPuntos());
		}

		@Test
		void jugadorCon5puntosRespondeIncorrectamente2vecesYSuPuntajeDeberiaSer3() {
			Jugador              jugador          = new Jugador("Alan");
			Pregunta             pregunta         = new Pregunta("El software es tangible.", new ComportamientoVoFPenalidad());
			ArrayList<Respuesta> respuestaJugador = new ArrayList<>();
			respuestaJugador.add(new RespuestaIncorrecta(""));
			respuestaJugador.add(new RespuestaIncorrecta(""));
			jugador.procesarPregunta(pregunta, respuestaJugador);
			Assertions.assertEquals(3, jugador.getPuntos());
		}
	*/
	@Test
	public void test01JugadorRespondeConUnaIncorrectaTienePuntajeMenos1() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(-1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorRespondeCon1CorrectaTienePuntaje1() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(new OpcionCorrecta("Correcta", ""));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
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
