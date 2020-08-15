package poo.coders.main.modelo.builders;

import poo.coders.main.modelo.comportamientos.Comportamiento;
import poo.coders.main.modelo.comportamientos.ComportamientoOrderedChoice;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.modelo.data.OpcionSerializada;

import java.util.ArrayList;
import java.util.List;

public class OrderedChoiceBuilder implements Builder {
	Comportamiento comportamiento;
	private String textoPregunta;
	private List<Opcion> opciones;

	@Override
	public void asignarComportamiento(String tipoPuntaje) {
		if (!tipoPuntaje.equals("Clasico")) throw new RuntimeException();
		comportamiento = new ComportamientoOrderedChoice();
	}


	@Override
	public void setEnunciado(String enunciado) {
		this.textoPregunta = enunciado;
	}

	@Override
	public void setOpciones(List<OpcionSerializada> opciones) {
		this.opciones = new ArrayList<>();
		opciones.forEach(opcionSerializada -> this.opciones.add(new Opcion(opcionSerializada.getClave(), opcionSerializada.getTexto())));
	}

	@Override
	public Pregunta construirPregunta() {
		return new Pregunta(textoPregunta, comportamiento, opciones);
	}
}
