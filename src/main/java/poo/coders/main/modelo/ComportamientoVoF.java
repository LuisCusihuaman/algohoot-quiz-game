package poo.coders.main.modelo;

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
	protected String getTipoPregunta() {
		return "Verdadero o Falso";
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
