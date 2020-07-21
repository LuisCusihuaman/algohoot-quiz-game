package poo.coders.Main;

public class Puntos {

	private int cantidadPuntos;
	private int multiplicador;

	public Puntos(){
		cantidadPuntos = 0;
		multiplicador = 1;
	}

	public void sumar (){
		cantidadPuntos++;
	}
	public void anular (){
		cantidadPuntos = 0;
	}
	public void restar(){
		cantidadPuntos--;
	}
	public void setMultiplicador(int multiplicador ){
		this.multiplicador = multiplicador;
	}
}
