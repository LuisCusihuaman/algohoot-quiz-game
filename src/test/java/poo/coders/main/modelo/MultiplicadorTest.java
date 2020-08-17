package poo.coders.main.modelo;

import org.junit.jupiter.api.Test;
import poo.coders.main.modelo.comportamientos.ComportamientoVoF;
import poo.coders.main.modelo.modificadores.Multiplicador;
import poo.coders.main.modelo.modificadores.MultiplicadorX2;

import java.util.ArrayList;

public class MultiplicadorTest {
	@Test
	public void test01JugadorActivaMultiplicadorX2RespondeConOpcionCorrectaEnVoFClasicaGanaPuntos() {
		Jugador jugador = new Jugador("Kevin");
		Pregunta preguntaVoF = new Pregunta("La Pregunta", new ComportamientoVoF());
		ArrayList<Opcion> opcionesJugador = new ArrayList<>();
		Multiplicador multiplicador = new MultiplicadorX2();
		opcionesJugador.add(new OpcionCorrecta("1","Esta opción es correcta"));



	}
}
