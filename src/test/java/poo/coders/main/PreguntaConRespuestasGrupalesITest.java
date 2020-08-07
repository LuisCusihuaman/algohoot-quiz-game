package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntaConRespuestasGrupalesITest {
	@Test
	public void test01JugadorRespondeCon2GruposConElementosDeSuMismoGrupoGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		OpcionesGrupales grupoOpciones = new OpcionesGrupales();
		OpcionesGrupales otroGrupoOpciones = new OpcionesGrupales();
		grupoOpciones.agregarAGrupo(new Opcion(1));
		grupoOpciones.agregarAGrupo(new Opcion(1));
		otroGrupoOpciones.agregarAGrupo(new Opcion(2));
		otroGrupoOpciones.agregarAGrupo(new Opcion(2));
		RespuestasGrupalesFactory respuestasFactory = new RespuestasGrupalesFactory();
		ArrayList<OpcionesGrupales> opciones = new ArrayList<>();
		opciones.add(grupoOpciones);
		opciones.add(otroGrupoOpciones);
		respuestasJugador.add(respuestasFactory.crearRespuestasSegun(opciones));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorRespondeCon2GruposConElementosDeDistintosGruposNoGanaPunto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		OpcionesGrupales grupoOpciones = new OpcionesGrupales();
		OpcionesGrupales otroGrupoOpciones = new OpcionesGrupales();
		grupoOpciones.agregarAGrupo(new Opcion(1));
		grupoOpciones.agregarAGrupo(new Opcion(2));
		otroGrupoOpciones.agregarAGrupo(new Opcion(2));
		otroGrupoOpciones.agregarAGrupo(new Opcion(2));
		RespuestasGrupalesFactory respuestasFactory = new RespuestasGrupalesFactory();
		ArrayList<OpcionesGrupales> opciones = new ArrayList<>();
		opciones.add(grupoOpciones);
		opciones.add(otroGrupoOpciones);
		respuestasJugador.add(respuestasFactory.crearRespuestasSegun(opciones));

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
