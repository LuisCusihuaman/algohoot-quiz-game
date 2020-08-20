package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoicePenalidad;

import java.util.ArrayList;

public class ComportamientoMultipleChoicePenalidadTest {
	@Test
	public void test01SeCreaElComportamientoCon5OpcionesYNoLanzaException(){
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new OpcionConjunto("1", "","1"));
		opcionesOriginales.add(new OpcionConjunto("2", "","2"));
		opcionesOriginales.add(new OpcionConjunto("3", "","3"));
		opcionesOriginales.add(new OpcionConjunto("4", "","4"));
		opcionesOriginales.add(new OpcionConjunto("5", "","5"));

		Assertions.assertDoesNotThrow(() -> {
			ComportamientoMultipleChoicePenalidad comportamiento = new ComportamientoMultipleChoicePenalidad(opcionesOriginales);
		});

	}

	@Test
	public void test02SeCreaElComportamientoCon1OpcionYLanzaException(){
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new Opcion("1", ""));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoicePenalidad comportamiento = new ComportamientoMultipleChoicePenalidad(opcionesOriginales);
		});
	}
	@Test
	public void test03SeCreaElComportamientoCon6OpcionesYLanzaException(){
		ArrayList<Opcion> opcionesOriginales = new ArrayList<>();
		opcionesOriginales.add(new OpcionConjunto("1", "","1"));
		opcionesOriginales.add(new OpcionConjunto("2", "","2"));
		opcionesOriginales.add(new OpcionConjunto("3", "","3"));
		opcionesOriginales.add(new OpcionConjunto("4", "","4"));
		opcionesOriginales.add(new OpcionConjunto("5", "","5"));
		opcionesOriginales.add(new OpcionConjunto("6", "","6"));

		Assertions.assertThrows(RuntimeException.class, () -> {
			ComportamientoMultipleChoicePenalidad comportamiento = new ComportamientoMultipleChoicePenalidad(opcionesOriginales);
		});
	}


	@Test
	public void test04ObtenerPuntajeCon3OpcionesCorrectasEnMultipleChoicePenalidadDevuelve3Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		//Jugador jugador = new Jugador("Pepe");
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("1", "Opcion 1", "1"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("1", "Opcion 2", "1"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("1", "Opcion 3", "1"));

		Assertions.assertEquals(3, pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}

	@Test
	public void test05ObtenerPuntajeCon3OpcionesCorrectasYUnaIncorrectaEnMultipleChoicePenalidadDevuelve2Puntos() {

		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("1", "Opcion Correcta","1"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("2","Opcion Correcta", "2"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("3", "Opcion Correcta","3"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("4","OpcionIncorrecta","3"));

		Assertions.assertEquals(2, pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}

	@Test
	public void test05ObtenerPuntajeCon4OpcionesIncorrectasEnMultipleChoicePenalidadDevuelveMenos4Puntos() {
		Pregunta pregunta = new Pregunta("Pregunta", new ComportamientoMultipleChoicePenalidad());
		ArrayList<Opcion> opcionesElegidasPorJugador = new ArrayList<>();
		opcionesElegidasPorJugador.add(new OpcionConjunto("1", "","2"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("2", "","1"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("3", "","4"));
		opcionesElegidasPorJugador.add(new OpcionConjunto("4", "","3"));

		Assertions.assertEquals((-4), pregunta.obtenerPuntaje(opcionesElegidasPorJugador));
	}
}
