package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceParcial;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;
import poo.coders.main.modelo.modificadores.MultiplicadorX3;

import java.util.ArrayList;

public class MultiplicadorTest {
	@Test
	public void test01ActivarMultiplicadorX2ConOpcionCorrectaEnVoFClasicoDevuelve2EnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));

		Assertions.assertEquals(2, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test02ActivarMultiplicadorX3ConOpcionCorrectaEnVoFClasicoDevuelve3EnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));

		Assertions.assertEquals(3, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test03ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceParcialDevuelveElDobleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));
		opciones.add(new OpcionCorrecta("2","Esta opción es correcta"));

		Assertions.assertEquals(4, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test03ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceParcialDevuelveElTripleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoMultipleChoiceParcial());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));
		opciones.add(new OpcionCorrecta("2","Esta opción es correcta"));

		Assertions.assertEquals(6, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test04ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceClasicoDevuelveElDobleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));
		opciones.add(new OpcionCorrecta("2","Esta opción es correcta"));

		Assertions.assertEquals(2, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

	@Test
	public void test05ActivarMultiplicadorX2ConVariasOpcionesCorrectasEnMultipleChoiceClasicoDevuelveElTripleDePuntosEnObtenerPuntaje() {
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> opciones = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX3();
		opciones.add(new OpcionCorrecta("1","Esta opción es correcta"));
		opciones.add(new OpcionCorrecta("2","Esta opción es correcta"));

		Assertions.assertEquals(3, preguntaVoF.obtenerPuntaje(opciones, multiplicador));
	}

}
