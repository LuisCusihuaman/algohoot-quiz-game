package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ExclusividadTest {
	@Test
	public void test01JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionCorrectaYSuRivalLaIncorrectaGanaDosPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		Exclusividad exclusividad = new Exclusividad();

		ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
		ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new RespuestaCorrecta(""));
		respuestasJugador2.add(new RespuestaIncorrecta(""));

		jugador1.activarExclusividad(exclusividad);

		jugador1.procesarPregunta(preguntaVoF, respuestasJugador1, exclusividad);
		jugador2.procesarPregunta(preguntaVoF, respuestasJugador2, exclusividad);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionCorrectaYSuRivalLaCorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		Exclusividad exclusividad = new Exclusividad();

		ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
		ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new RespuestaCorrecta(""));
		respuestasJugador2.add(new RespuestaCorrecta(""));

		jugador1.activarExclusividad(exclusividad);

		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test03JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionIncorrectaYSuRivalLaIncorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		Exclusividad exclusividad = new Exclusividad();

		ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
		ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new RespuestaIncorrecta(""));
		respuestasJugador2.add(new RespuestaIncorrecta(""));

		jugador1.activarExclusividad(exclusividad);

		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}
	@Test
	public void test04JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionIncorrectaYSuRivalLaCorrectaYElRivalGanaDosPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
		ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
		respuestasJugador1.add(new RespuestaIncorrecta(""));
		respuestasJugador2.add(new RespuestaCorrecta(""));

		jugador2.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(2, jugador2.getPuntos());
	}

	@Test
	public void test05JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionCorrectaYSuRivalLaIncorrectaGanaDosPuntos(){

	}

	@Test
	public void test06JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionCorrectaYSuRivalLaCorrectaGanaCeroPuntos(){

	}

	@Test
	public void test07JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionIncorrectaYSuRivalLaIncorrectaGanaCeroPuntos(){

	}
	@Test
	public void test08JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionIncorrectaYSuRivalLaCorrectaYElRivalGanaDosPuntos(){

	}

	@Test
	public void test09JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionCorrectaYSuRivalLaIncorrectaGanaCuatroPuntos(){

	}

	@Test
	public void test10JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionCorrectaYSuRivalLaCorrectaGanaCeroPuntos(){

	}

	@Test
	public void test11JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionIncorrectaYSuRivalLaIncorrectaGanaCeroPuntos(){

	}
	@Test
	public void test12JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionIncorrectaYSuRivalLaCorrectaYElRivalGanaCuatroPuntos(){

	}
}
