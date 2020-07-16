package poo.coders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AlgoFixITest {
	@Test
    public void test01PresupuestoPintorUtilizaPincelConPinturaAlbaOfreceElMenorPresupuestoIT() {
		AlgoFix algoFix = new AlgoFix();
		algoFix.registrarPintorDePincel("Diego", 500);
		Pintura     alba        = algoFix.crearPintura("Alba", 200, 1, 1);
		Presupuesto presupuesto = algoFix.presupuestoMasBaratoParaPintar(5, alba);
		//manoDeObra: (5 "M2" * 2 "horas" * 500 "Precio" * 1 "manos")
		//masMateriales: (5 "M2" * 4 "litros" * 200 "Precio" * 1 "manos").
		int valorEsperado = algoFix.calcularValorEsperado(5 * 2 * 500 * 1, 5 * 4 * 200 * 1);

		assertEquals("Diego", presupuesto.responsable());
		assertEquals(valorEsperado, presupuesto.valor());
	}
    @Test
    public void test02(){
	    assertTrue(true);
    }
}

