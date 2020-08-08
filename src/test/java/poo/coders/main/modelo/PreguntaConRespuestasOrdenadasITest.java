package poo.coders.main.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PreguntaConRespuestasOrdenadasITest {
	@Test
	public void test01JugadorRespondeCon3RespuestasQueEstanOrdenadasGana1Punto() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(1));
		opciones.agregarOpcion(new Opcion(2));
		opciones.agregarOpcion(new Opcion(3));
		RespuestasOrdenadasFactory respuestasFactory = new RespuestasOrdenadasFactory();
		Respuesta respuesta = respuestasFactory.crearRespuestaEnBaseA(opciones);
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(respuesta);

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(1, jugador.getPuntos());
	}

	@Test
	public void test02JugadorRespondeCon3RespuestasDesordenadasNoGanaPuntos() {
		Jugador jugador = new Jugador("");
		Pregunta pregunta = new Pregunta("", new ComportamientoVoF());
		OpcionesOrdenadas opciones = new OpcionesOrdenadas();
		opciones.agregarOpcion(new Opcion(1));
		opciones.agregarOpcion(new Opcion(3));
		opciones.agregarOpcion(new Opcion(2));
		RespuestasOrdenadasFactory respuestasFactory = new RespuestasOrdenadasFactory();
		Respuesta respuesta = respuestasFactory.crearRespuestaEnBaseA(opciones);
		ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
		respuestasJugador.add(respuesta);

		jugador.procesarPregunta(pregunta, respuestasJugador);

		Assertions.assertEquals(0, jugador.getPuntos());
	}
}
