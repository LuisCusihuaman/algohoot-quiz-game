package poo.coders.main.modelo;

public interface Observable {

	void agregarObservador(Observador observador);

	void notificarObservadores();
}
