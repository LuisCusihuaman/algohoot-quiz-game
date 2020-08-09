package poo.coders.main.modelo;

import java.util.ArrayList;
import java.util.List;

public class ComportamientoVoF extends Comportamiento {


	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeParcial();
	}


}
