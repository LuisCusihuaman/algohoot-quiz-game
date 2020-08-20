package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoicePenalidad;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.comportamientos.ComportamientoVoFPenalidad;
import poo.coders.main.modelo.modificadores.*;

import java.util.ArrayList;

public class PreguntasConMultiplicadorTest {
	@Test
	public void test01JugadorActivaMultiplicadorX2EnVoFPenalidadRespondeConOpcionCorrectaGana2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionConjunto("1","El pulpo loco", "1"));
		opcionesJugador2.add(new OpcionConjunto("2", "Es buena onda","1"));
		jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2);

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(-1, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorActivaMultiplicadorX3EnVoFPenalidadRespondeConOpcionCorrectaGana2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionConjunto("1","El pulpo loco", "1"));
		opcionesJugador2.add(new OpcionConjunto("2", "Es buena onda", "1"));
		jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2);

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(-1, jugador2.getPuntos());
	}

	@Test
	public void test03SeAgreganMultiplicadorX2EnAmbosJugadoresEnVoFPenalidadRespondenConOpcionCorrectaGanan2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador);
		preguntaVoF.agregarMultiplicadorAJugador(jugador2, multiplicador);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionConjunto("1","El pulpo loco", "1"));
		opcionesJugador2.add(new OpcionConjunto("2", "No es buena onda", "2"));
		jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2);

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(2, jugador2.getPuntos());
	}

	@Test
	public void test04SeAgreganMultiplicadorDistintosEnAmbosJugadoresEnVoFPenalidadRespondenConOpcionCorrectaGanan2PuntosY3PuntosRespectivamente() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2);
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, new MultiplicadorX2());
		preguntaVoF.agregarMultiplicadorAJugador(jugador2, new MultiplicadorX3());
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionConjunto("1","El pulpo loco","1"));
		opcionesJugador2.add(new OpcionConjunto("2", "No es buena onda","2"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(3, jugador2.getPuntos());
	}

	@Test
	public void test05UnJugadorUsaMultiplicadorx2EnMultipleChoicePenalidadRespondenConOpcionesIncorrectasTieneMenos2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2);
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, new MultiplicadorX2());
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionConjunto("1","El pulpo loco","2"));
		opcionesJugador2.add(new OpcionConjunto("2", "No es buena onda","1"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(-2, jugador1.getPuntos());
		Assertions.assertEquals(-1, jugador2.getPuntos());
	}

	@Test
	public void test06UnJugadorUsaMultiplicadorx3EnMultipleChoicePenalidadRespondenConOpcionesIncorrectasTieneMenos3Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesJugador2);
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, new MultiplicadorX3());
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionConjunto("1","El pulpo loco","2"));
		opcionesJugador2.add(new OpcionConjunto("2", "No es buena onda","1"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(-3, jugador1.getPuntos());
		Assertions.assertEquals(-1, jugador2.getPuntos());
	}
}
