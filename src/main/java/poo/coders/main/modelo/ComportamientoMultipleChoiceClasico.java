package poo.coders.main.modelo;

import java.util.List;

public class ComportamientoMultipleChoiceClasico extends Comportamiento {
	public ComportamientoMultipleChoiceClasico(){
	}
	public ComportamientoMultipleChoiceClasico(List<Opcion> opciones){
		if(opciones.size() < 2 || opciones.size() > 5 ) throw new RuntimeException();
	}
	@Override
	protected Puntaje crearPuntaje() {
		return new PuntajeClasico();
	}

	@Override
	protected String getTipoPregunta() {
		return "Multiple Choice Clasico";
	}

	public int activarMultiplicadorX2(){
		throw new RuntimeException();
	}
	public int activarMultiplicadorX3(){
		throw new RuntimeException();
	}
	public void activarExclusividad(Exclusividad exclusividad){
		exclusividad.activarExclusividad();
	}
}
