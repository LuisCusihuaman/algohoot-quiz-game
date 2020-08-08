package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoGroupChoice extends Comportamiento {


	@Override
	public Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}


}
