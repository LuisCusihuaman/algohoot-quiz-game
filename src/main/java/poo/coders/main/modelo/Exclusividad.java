package poo.coders.main.modelo;

public class Exclusividad {
	private int multiplicadorExclusividad;

	Exclusividad(){
		this.multiplicadorExclusividad = 1;
	}

	public int aplicar(int puntajeOriginal){
		return puntajeOriginal * multiplicadorExclusividad;
	}

	public void activarExclusividad(){
		this.multiplicadorExclusividad *= 2;
	}

}
