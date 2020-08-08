package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntaConRespuestasGrupalesITest {
	@Test
	public void test01JugadorUsaDosOpcionesConClaveIgualANumeroGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Respuesta> respuestasJugador;

		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));

		respuestasJugador = opcionesGrupales.verificarRespuestas();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorUsaDosOpcionesConClavesDistintasANumeroGrupoNoGanaPunto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Respuesta> respuestasJugador;

		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo1(new Opcion(2, ""));

		respuestasJugador = opcionesGrupales.verificarRespuestas();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

	@Test
	public void test03JugadorUsaDosOpcionesEnUnGrupoYOtrosDosEnOtroGrupoConSusClavesIgualesANumeroGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Respuesta> respuestasJugador;

		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo2(new Opcion(2, ""));
		opcionesGrupales.agregarAGrupo2(new Opcion(2, ""));

		respuestasJugador = opcionesGrupales.verificarRespuestas();
		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test04JugadorUsaOpcionesEnGruposQueNoCorrespondenNoGanaPuntos() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoGroupChoice());
		ArrayList<Respuesta> respuestasJugador;

		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo1(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo2(new Opcion(1, ""));
		opcionesGrupales.agregarAGrupo2(new Opcion(2, ""));

		respuestasJugador = opcionesGrupales.verificarRespuestas();
		jugador.procesarPregunta(pregunta, respuestasJugador);
		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
