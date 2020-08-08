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

	@Test
	public void test03JugadorUsaDosOpcionesEnUnGrupoYOtrosDosEnOtroGrupoConSusClavesIgualesANumeroGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoMultipleChoiceClasico());
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales(1);
		OpcionesGrupales otrasOpcionesGrupales = new OpcionesGrupales(2);
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		ArrayList<OpcionesGrupales> gruposDeOpciones = new ArrayList<>();
		gruposDeOpciones.add(opcionesGrupales);
		gruposDeOpciones.add(otrasOpcionesGrupales);
		ArrayList<Respuesta> respuestasJugador = opcionesGrupales.verificarRespuestas(gruposDeOpciones);

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test04JugadorUsaOpcionesEnGruposQueNoCorrespondenNoGanaPuntos() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoMultipleChoiceClasico());
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales(1);
		OpcionesGrupales otrasOpcionesGrupales = new OpcionesGrupales(2);
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(1));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		ArrayList<OpcionesGrupales> gruposDeOpciones = new ArrayList<>();
		gruposDeOpciones.add(opcionesGrupales);
		gruposDeOpciones.add(otrasOpcionesGrupales);
		ArrayList<Respuesta> respuestasJugador = opcionesGrupales.verificarRespuestas(gruposDeOpciones);

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
