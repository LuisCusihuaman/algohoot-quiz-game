package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class RespuestasFactoryTest {
	@Test
	public void test01FactoryRespuestasOrdenadasRecibeOpcionesOrdenadas() {
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(1));
		opciones.agregarOpcion(new Opcion(2));
		RespuestasOrdenadasFactory respuestasFactory = new RespuestasOrdenadasFactory();

		Respuesta respuesta = respuestasFactory.crearRespuestaEnBaseA(opciones);

		Assertions.assertEquals("Correcta", respuesta.getTextoRespuesta());
	}

	@Test
	public void test02FactoryRespuestaConOpcionesDesordenadasTieneTextoRespuestaIncorrecto() {
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(2));
		opciones.agregarOpcion(new Opcion(1));
		RespuestasOrdenadasFactory respuestasFactory = new RespuestasOrdenadasFactory();

		Respuesta respuesta = respuestasFactory.crearRespuestaEnBaseA(opciones);

		Assertions.assertEquals("Incorrecta", respuesta.getTextoRespuesta());
	}

	@Test
	public void test03FactoryRespuestaConOpcionesDelMismoGrupoTieneTextoCorrecto() {
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		ArrayList<OpcionesGrupales> grupoOpciones = new ArrayList<>();
		RespuestasGrupalesFactory respuestasFactory = new RespuestasGrupalesFactory();

		Respuesta respuesta = respuestasFactory.crearRespuestasSegun(grupoOpciones);

		Assertions.assertEquals("Correcto", respuesta.getTextoRespuesta());
	}

	@Test
	public void test04RespuestaConOpcionesDeGruposDistintosTieneTextoIncorrecto() {
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(2));
		ArrayList<OpcionesGrupales> grupoOpciones = new ArrayList<>();
		grupoOpciones.add(opcionesGrupales);
		RespuestasGrupalesFactory respuestasFactory = new RespuestasGrupalesFactory();

		Respuesta respuesta = respuestasFactory.crearRespuestasSegun(grupoOpciones);

		Assertions.assertEquals("Incorrecto", respuesta.getTextoRespuesta());
	}

	@Test
	public void test05RespuestasFactoryGrupalesConElementosEnSusGruposDevuelveRespuestaCorrecta() {
		RespuestasGrupalesFactory respuestasFactory = new RespuestasGrupalesFactory();
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		OpcionesGrupales otrasOpcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		ArrayList<OpcionesGrupales> grupoOpciones = new ArrayList<>();
		grupoOpciones.add(opcionesGrupales);
		grupoOpciones.add(otrasOpcionesGrupales);

		Respuesta respuesta = respuestasFactory.crearRespuestasSegun(grupoOpciones);

		Assertions.assertEquals("Correcto", respuesta.getTextoRespuesta());
	}

	@Test
	public void test06RespuestasFactoryGrupalesRecibeGruposConElementosQueSonDeDistintoGrupoDevuelveRespuestaIncorrecta() {
		RespuestasGrupalesFactory respuestasFactory = new RespuestasGrupalesFactory();
		OpcionesGrupales opcionesGrupales = new OpcionesGrupales();
		OpcionesGrupales otrasOpcionesGrupales = new OpcionesGrupales();
		opcionesGrupales.agregarAGrupo(new Opcion(1));
		opcionesGrupales.agregarAGrupo(new Opcion(2));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		otrasOpcionesGrupales.agregarAGrupo(new Opcion(2));
		ArrayList<OpcionesGrupales> grupoOpciones = new ArrayList<>();
		grupoOpciones.add(opcionesGrupales);
		grupoOpciones.add(otrasOpcionesGrupales);

		Respuesta respuesta = respuestasFactory.crearRespuestasSegun(grupoOpciones);

		Assertions.assertEquals("Incorrecto", respuesta.getTextoRespuesta());
	}
}
