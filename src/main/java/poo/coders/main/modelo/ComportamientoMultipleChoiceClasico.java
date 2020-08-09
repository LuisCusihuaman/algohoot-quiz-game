package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {

	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public List<Respuesta> verificarOpciones(List<Opcion> opcionesElegidasPorElJugador){
		ArrayList<Respuesta> respuestas = new ArrayList<>();
		for (Opcion opcion : opcionesElegidasPorElJugador ) {
			try {
				respuestas.add(opcion.convertirEnRespuesta());
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return respuestas;
	}

}
