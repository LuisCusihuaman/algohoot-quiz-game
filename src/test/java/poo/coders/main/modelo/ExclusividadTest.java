package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoicePenalidad;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.comportamientos.ComportamientoVoFPenalidad;
import poo.coders.main.modelo.modificadores.Exclusividad;
import poo.coders.main.modelo.modificadores.SinExclusividad;

import java.util.ArrayList;

public class ExclusividadTest {

	@Test
	public void test01JugadorActivaExclusividadUnaVezYGana2PuntosEnVOFClasico() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA", "1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker", "1"));
		jugador1.elegirOpciones(opcionesElegidasPorJugador1);
		jugador1.getJugadorSiguiente().elegirOpciones(opcionesElegidasPorJugador2);
		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test02JugadorActivaExclusividadUnaVezYAmbosRespondenConOpcionesCorrectasEnVoFClasicoYNoGananPuntos() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA", "1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker","2"));
		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test03JugadorNoActivaExclusividadYAmbosRespondenConOpcionesCorrectasEnVoFClasicoRecibenPuntosComoSiNoTuvieranExclusividadActivado() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		Exclusividad exclusividad = new SinExclusividad();
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA","1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker","2"));
		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(1, jugador1.getPuntos());
		Assertions.assertEquals(1, jugador2.getPuntos());
	}
	@Test
	public void test04JugadorActivaExclusividadDosVecesYGana4PuntosEnPreguntaVoFClasico() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA","1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker","1"));
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(4, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test05JugadorActivaExclusividadDosVecesYAmbosRespondenConOpcionesCorrectasEnPreguntaConVoFClasicoNoGananPuntos() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoVoF());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA","1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker","2"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test06JugadorActivaExclusividadUnaVezEnMultipleChoiceClasicoRespondeConOpcionesCorrectasRecibeElDobleDePuntos() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA","1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker","1"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(2, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

	@Test
	public void test07JugadorActivaExclusividadUnaVezEnMultipleChoiceClasicoYAmbosRespondenConOpcionesCorrectasNoRecibenPuntos() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA", "1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "Es hacker", "2"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(0, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}
	@Test
	public void test08JugadorActivaExclusividadDosVecesEnMultipleChoiceClasicoRespondeConOpcionesCorrectasRecibe4VecesSusPuntos() {
		Jugador jugador1 = new Jugador("Kevin");
		Jugador jugador2 = new Jugador("Mitnick");
		jugador1.setJugadorSiguiente(jugador2);
		jugador2.setJugadorSiguiente(jugador1);
		Pregunta preguntaVoF = new Pregunta("Testing", new ComportamientoMultipleChoiceClasico());
		ArrayList<Opcion> opcionesElegidasPorJugador1 = new ArrayList<>();
		ArrayList<Opcion> opcionesElegidasPorJugador2 = new ArrayList<>();
		jugador1.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador1);
		jugador2.elegirRespuestasAPreguntaActual(opcionesElegidasPorJugador2);
		Exclusividad exclusividad = new SinExclusividad();
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		exclusividad = preguntaVoF.activarExclusividad(exclusividad);
		opcionesElegidasPorJugador1.add(new OpcionConjunto("1", "Es QA", "1"));
		opcionesElegidasPorJugador2.add(new OpcionConjunto("2", "No es hacker", "1"));

		exclusividad.definirPuntosJugadoresEnPregunta(preguntaVoF, jugador1);

		Assertions.assertEquals(4, jugador1.getPuntos());
		Assertions.assertEquals(0, jugador2.getPuntos());
	}

}
