package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntaConRespuestasGrupalesITest {
	@Test
	public void test01JugadorUsaDosOpcionesConClaveIgualANumeroGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales(1);
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		respuestasJugador.add(opcionesGrupales.verificarRespuestas());

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorUsaDosOpcionesConClavesDistintasANumeroGrupoNoGanaPunto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales(1);
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(2));
		respuestasJugador.add(opcionesGrupales.verificarRespuestas());

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}

}
