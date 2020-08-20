package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoicePenalidad;
import poo.coders.main.modelo.comportamientos.ComportamientoVoFPenalidad;
import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;
import poo.coders.main.modelo.modificadores.MultiplicadorX3;

import java.util.ArrayList;

public class MultiplicadorTest {
	@Test
	public void test01ActivarMultiplicadorX2ConOpcionIncorrectaEnVoFPenalidadDevuelveMenos2EnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionConjunto("Incorrecta", "", "1"));
		Assertions.assertEquals(-2, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test02ActivarMultiplicadorX3ConOpcionCorrectaEnVoFClasicoDevuelve3EnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionConjunto("1", "", "1"));

		Assertions.assertEquals(3, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test03ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceParcialDevuelveElDobleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaMultipleChoicePenalidad = new Pregunta("La Pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionConjunto("1", "", "1"));
		opciones.add(new OpcionConjunto("2", "", "2"));
		Assertions.assertEquals(4, preguntaMultipleChoicePenalidad.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test03ActivarMultiplicadorX3ConVariasOpcionesCorrectasEnMultipleChoicePenalidadDevuelveElTripleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionConjunto("1", "", "1"));
		opciones.add(new OpcionConjunto("2", "", "2"));

		Assertions.assertEquals(6, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test04ActivarMultiplicadorX2ConOpcionIncorrectaEnVoFPenalidadDevuelveMenosElDobleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionConjunto("Incorrecta", "", "1"));

		Assertions.assertEquals(-2, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test05ActivarMultiplicadorX3ConOpcionIncorrectaEnVoFPenalidadDevuelveMenosElTripleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionConjunto("Incorrecta", "", "1"));

		Assertions.assertEquals(-3, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

}
