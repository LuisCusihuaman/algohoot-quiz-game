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
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionCorrecta("Correcta", "Verdadero"));
		respuestasJugador2.add(new OpcionIncorrecta("Incorrecta", "Falso"));

		jugador1.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionCorrectaYSuRivalLaCorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());

		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();
		respuestasJugador1.add(new OpcionCorrecta("Correcta", "Verdadero"));
		respuestasJugador2.add(new OpcionCorrecta("Correcta", "Verdadero"));

		jugador1.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test03JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionIncorrectaYSuRivalLaIncorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionIncorrecta("Incorrecta", "Falso"));
		respuestasJugador2.add(new OpcionIncorrecta("Incorrecta", "Falso"));
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}
	@Test
	public void test04JugadorUsaExclusivdadEnPreguntaVoFEligeLaOpcionIncorrectaYSuRivalLaCorrectaYElRivalGanaDosPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();
		respuestasJugador1.add(new OpcionIncorrecta("Incorrecta", "Falso"));
		respuestasJugador2.add(new OpcionCorrecta("Correcta", "Verdadero"));

		jugador2.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(2, jugador2.getPuntos());
	}

	@Test
	public void test05JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionCorrectaYSuRivalLaIncorrectaGanaDosPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaMC = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionCorrecta("Correcta", ""));
		respuestasJugador2.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador2.activarExclusividadEnPregunta(preguntaMC);
		preguntaMC.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test06JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionCorrectaYSuRivalLaCorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaMC = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionCorrecta("Correcta", ""));
		respuestasJugador2.add(new OpcionCorrecta("Correcta", ""));

		jugador2.activarExclusividadEnPregunta(preguntaMC);
		preguntaMC.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test07JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionIncorrectaYSuRivalLaIncorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaMC = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestasJugador2.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador2.activarExclusividadEnPregunta(preguntaMC);
		preguntaMC.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test08JugadorUsaExclusivdadEnPreguntaMultipleChoiceParcialEligeLaOpcionIncorrectaYSuRivalLaCorrectaYElRivalGanaDosPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaMC = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestasJugador2.add(new OpcionCorrecta("Correcta", ""));


		jugador2.activarExclusividadEnPregunta(preguntaMC);
		preguntaMC.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(2, jugador2.getPuntos());
	}

	@Test
	public void test09JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionCorrectaYSuRivalLaIncorrectaGanaCuatroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionCorrecta("Correcta", ""));
		respuestasJugador2.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador1.activarExclusividadEnPregunta(preguntaVoF);
		jugador2.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(4, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test10JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionCorrectaYSuRivalLaCorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionCorrecta("Correcta", ""));
		respuestasJugador2.add(new OpcionCorrecta("Correcta", ""));

		jugador1.activarExclusividadEnPregunta(preguntaVoF);
		jugador2.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test11JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionIncorrectaYSuRivalLaIncorrectaGanaCeroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestasJugador2.add(new OpcionIncorrecta("Incorrecta", ""));

		jugador1.activarExclusividadEnPregunta(preguntaVoF);
		jugador2.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}
	@Test
	public void test12JugadoresUsanExclusivdadEnPreguntaVoFJugadorEligeLaOpcionIncorrectaYSuRivalLaCorrectaYElRivalGanaCuatroPuntos(){
		Jugador jugador1 = new Jugador("1");
		Jugador jugador2 = new Jugador("2");
		Pregunta preguntaVoF = new Pregunta("", new ComportamientoVoF());
		ArrayList<Opcion> respuestasJugador1 = new ArrayList<>();
		ArrayList<Opcion> respuestasJugador2 = new ArrayList<>();

		respuestasJugador1.add(new OpcionIncorrecta("Incorrecta", ""));
		respuestasJugador2.add(new OpcionCorrecta("Correcta", ""));

		jugador1.activarExclusividadEnPregunta(preguntaVoF);
		jugador2.activarExclusividadEnPregunta(preguntaVoF);
		preguntaVoF.aplicarConJugadores(jugador1, jugador2, respuestasJugador1, respuestasJugador2);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(4, jugador2.getPuntos());
	}
}
