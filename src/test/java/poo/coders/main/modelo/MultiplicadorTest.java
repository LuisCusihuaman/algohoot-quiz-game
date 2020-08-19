package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.*;
import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;
import poo.coders.main.modelo.modificadores.MultiplicadorX3;

import java.util.ArrayList;

public class MultiplicadorTest {
	@Test
	public void test01ActivarMultiplicadorX2ConOpcionCorrectaEnVoFPenalidadDevuelve2EnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));

		Assertions.assertEquals(2, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test02ActivarMultiplicadorX3ConOpcionCorrectaEnVoFClasicoDevuelve3EnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));

		Assertions.assertEquals(3, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test03ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceParcialDevuelveElDobleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaMultipleChoicePenalidad = new Pregunta("La Pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));
		opciones.add(new OpcionCorrecta("2","Esta opción es correcta"));

		Assertions.assertEquals(4, preguntaMultipleChoicePenalidad.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test03ActivarMultiplicadorX3ConVariasOpcionesCorrectasEnMultipleChoicePenalidadDevuelveElTripleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));
		opciones.add(new OpcionCorrecta("2","Esta opción es correcta"));

		Assertions.assertEquals(6, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test04ActivarMultiplicadorX2ConOpcionIncorrectaEnVoFPenalidadDevuelveMenosElDobleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionIncorrecta("1","Esta opción es correcta, minga"));

		Assertions.assertEquals(-2, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test05ActivarMultiplicadorX3ConOpcionIncorrectaEnVoFPenalidadDevuelveMenosElTripleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoFPenalidad());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionIncorrecta("1","Esta opción es correcta, minga"));

		Assertions.assertEquals(-3, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

}
