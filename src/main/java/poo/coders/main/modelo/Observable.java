package poo.coders.main.modelo;

public interface Observable {
	void addObserver(Observer observer);

	void notifyObservers();
}
