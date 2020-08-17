package poo.coders.main.modelo.comportamientos;

import poo.coders.main.modelo.*;

import java.util.List;

public class ComportamientoVoF extends Comportamiento {
	public ComportamientoVoF(){

	}
	public ComportamientoVoF(List<Opcion> opciones){
		if(opciones.size() != 2 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	public String getTipoPregunta() {
		return "Verdadero o Falso";
	}

}