package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoVoFPenalidad extends Comportamiento {
	public ComportamientoVoFPenalidad(){

	}
	public ComportamientoVoFPenalidad(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajePenalidad();
	}

	@Override
	protected String getTipoPregunta() {
		return "Verdadero o Falso Penalidad";
	}

	public int activarMultiplicadorX2(){
		return 2;
	}
	public int activarMultiplicadorX3(){
		return 3;
	}
	public void activarExclusividad(Exclusividad exclusividad){
		throw new RuntimeException();
	}
}
