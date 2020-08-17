package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.modificadores.Exclusividad;
import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;
import poo.coders.main.modelo.modificadores.SinExclusividad;

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
}
