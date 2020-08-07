package poo.coders.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OpcionesOrdenadasTest {
	@Test
	public void test01OpcionesDeUnicaOpcionYaEstaOrdenada() {
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(1));
		Assertions.assertTrue(opciones.estaOrdenada());
	}

	@Test
	public void test02OpcionesConIdentificadoresAscendentesEstaOrdenada() {
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(1));
		opciones.agregarOpcion(new Opcion(2));
		opciones.agregarOpcion(new Opcion(3));

		Assertions.assertTrue(opciones.estaOrdenada());
	}

	@Test
	public void test03OpcionesConIdentificadoresNoOrdenadosEstaDesordenada() {
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(1));
		opciones.agregarOpcion(new Opcion(3));
		opciones.agregarOpcion(new Opcion(2));

		boolean estaOrdenada = opciones.estaOrdenada();
		Assertions.assertFalse(estaOrdenada);
	}
}
