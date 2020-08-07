package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OpcionesGrupalesTest {
	@Test
	public void test01GruposConElementosDeMismoIDSonIguales() {
		OpcionesGrupales grupoDeOpciones = new OpcionesGrupales();
		OpcionesGrupales otroGrupoDeOpciones = new OpcionesGrupales();
		Opcion opcion = new Opcion(1);
		grupoDeOpciones.agregarAGrupo(opcion);
		otroGrupoDeOpciones.agregarAGrupo(opcion);

		Assertions.assertTrue(grupoDeOpciones.esIgualA(otroGrupoDeOpciones));
	}

	@Test
	public void test02GruposConElementoDeDistintoIDSonDistintos() {
		OpcionesGrupales grupoDeOpciones = new OpcionesGrupales();
		grupoDeOpciones.agregarAGrupo(new Opcion(1));
		grupoDeOpciones.agregarAGrupo(new Opcion(2));

		Assertions.assertFalse(grupoDeOpciones.elementosSonDelMismoGrupo());
	}

	@Test
	public void test03GruposCon2ElementosDeMismoIDSonIguales() {
		OpcionesGrupales grupoOpciones = new OpcionesGrupales();
		OpcionesGrupales otroGrupoOpciones = new OpcionesGrupales();
		grupoOpciones.agregarAGrupo(new Opcion(1));
		grupoOpciones.agregarAGrupo(new Opcion(1));
		otroGrupoOpciones.agregarAGrupo(new Opcion(1));
		otroGrupoOpciones.agregarAGrupo(new Opcion(1));

		Assertions.assertTrue(grupoOpciones.esIgualA(otroGrupoOpciones));
	}

	@Test
	public void test04GruposCon2ElementosDeDistintoIDSonDistintos() {
		OpcionesGrupales grupoOpciones = new OpcionesGrupales();
		OpcionesGrupales otroGrupoOpciones = new OpcionesGrupales();
		grupoOpciones.agregarAGrupo(new Opcion(1));
		grupoOpciones.agregarAGrupo(new Opcion(1));
		otroGrupoOpciones.agregarAGrupo(new Opcion(2));
		otroGrupoOpciones.agregarAGrupo(new Opcion(2));

		Assertions.assertFalse(grupoOpciones.esIgualA(otroGrupoOpciones));
	}
}
