package poo.coders.main.modelo.builders;

import poo.coders.main.modelo.*;
import poo.coders.main.modelo.comportamientos.Comportamiento;
import poo.coders.main.modelo.comportamientos.ComportamientoGroupChoice;
import poo.coders.main.modelo.data.OpcionSerializada;
import poo.coders.main.modelo.excepciones.DiferenteTipoPreguntaException;

import java.util.ArrayList;
import java.util.List;

public class GroupChoiceBuilder implements Builder {
	Comportamiento comportamiento;
	private String textoPregunta;
	private List<Opcion> opciones;

	@Override
	public void asignarComportamiento(String tipoPuntaje) {
		if (!tipoPuntaje.equals("Clasico")) throw new DiferenteTipoPreguntaException();
		comportamiento = new ComportamientoGroupChoice();
	}

	@Override
	public void setEnunciado(String enunciado) {
		this.textoPregunta = enunciado;
	}

	// TODO: Separar en grupos, ver claveElegida en constructor?
	@Override
	public void setOpciones(List<OpcionSerializada> opciones) {
		this.opciones = new ArrayList<>();
		opciones.forEach(opcionSerializada -> this.opciones.add(new OpcionConjunto(opcionSerializada.getClave(), opcionSerializada.getTexto())));
	}

	@Override
	public Pregunta construirPregunta() {
		return new Pregunta(textoPregunta, comportamiento, opciones);
	}
}
