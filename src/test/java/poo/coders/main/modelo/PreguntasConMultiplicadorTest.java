package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.modificadores.*;

import java.util.ArrayList;

public class PreguntasConMultiplicadorTest {
	@Test
	public void test01JugadorActivaMultiplicadorX2EnVoFClasicoRespondeConOpcionCorrectaGana2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionCorrecta("1","El pulpo loco"));
		opcionesJugador2.add(new OpcionIncorrecta("2", "Es buena onda"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1, jugador2, opcionesJugador1, opcionesJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorActivaMultiplicadorX3EnVoFClasicoRespondeConOpcionCorrectaGana2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionCorrecta("1","El pulpo loco"));
		opcionesJugador2.add(new OpcionIncorrecta("2", "Es buena onda"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1, jugador2, opcionesJugador1, opcionesJugador2);

		Assertions.assertEquals(3, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test03SeAgreganMultiplicadorX2EnAmbosJugadoresEnVoFClasicoRespondenConOpcionCorrectaGanan2Puntos() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, multiplicador);
		preguntaVoF.agregarMultiplicadorAJugador(jugador2, multiplicador);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionCorrecta("1","El pulpo loco"));
		opcionesJugador2.add(new OpcionCorrecta("2", "No es buena onda"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1, jugador2, opcionesJugador1, opcionesJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(2, jugador2.getPuntos());
	}

	@Test
	public void test04SeAgreganMultiplicadorDistintosEnAmbosJugadoresEnVoFClasicoRespondenConOpcionCorrectaGanan2PuntosY3PuntosRespectivamente() {
		Jugador jugador1 = new Jugador("Cthulhu");
		Jugador jugador2 = new Jugador("Nyarlathotep");
		Pregunta preguntaVoF = new Pregunta("La pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opcionesJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesJugador2 = new ArrayList<>();
		preguntaVoF.agregarMultiplicadorAJugador(jugador1, new MultiplicadorX2());
		preguntaVoF.agregarMultiplicadorAJugador(jugador2, new MultiplicadorX3());
		Exclusividad exclusividad = new SinExclusividad();
		opcionesJugador1.add(new OpcionCorrecta("1","El pulpo loco"));
		opcionesJugador2.add(new OpcionCorrecta("2", "No es buena onda"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1, jugador2, opcionesJugador1, opcionesJugador2);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(3, jugador2.getPuntos());
	}
}
