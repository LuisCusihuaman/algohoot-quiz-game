package poo.coders.main.modelo.builders;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.comportamientos.Comportamiento;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceClasico;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoiceParcial;
import poo.coders.main.modelo.comportamientos.ComportamientoMultipleChoicePenalidad;
import poo.coders.main.modelo.data.OpcionSerializada;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceBuilder implements Builder {
	Comportamiento comportamiento;
	private String textoPregunta;
	private List<Opcion> opciones;

	@Override
	public void asignarComportamiento(String tipoPuntaje) {
		switch (tipoPuntaje) {
			case "Clasico":
				comportamiento = new ComportamientoMultipleChoiceClasico();
				break;
			case "Parcial":
				comportamiento = new ComportamientoMultipleChoiceParcial();
				break;
			case "Penalidad":
				comportamiento = new ComportamientoMultipleChoicePenalidad();
				break;
		}
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
