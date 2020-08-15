package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoGroupChoice;

import java.util.ArrayList;

public class PreguntaConRespuestasGrupalesITest {
	@Test
	public void test01JugadorUsaDosOpcionesConClaveIgualANumeroGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();

		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorUsaDosOpcionesConClavesDistintasANumeroGrupoNoGanaPunto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();

		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "2"));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorUsaDosOpcionesEnUnGrupoYOtrosDosEnOtroGrupoConSusClavesIgualesANumeroGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();

		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("2", "chihuahua"), "2"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("2", "chihuahua"), "2"));


		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test04JugadorUsaOpcionesEnGruposQueNoCorrespondenNoGanaPuntos() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Opcion> respuestasJugador = new ArrayList<>();

		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "1"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("1", "chihuahua"), "2"));
		respuestasJugador.add(new OpcionConjunto( new Opcion("2", "chihuahua"), "2"));

		jugador.procesarPregunta(pregunta, respuestasJugador);
		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
