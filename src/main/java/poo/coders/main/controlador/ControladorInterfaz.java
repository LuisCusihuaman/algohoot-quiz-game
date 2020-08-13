package poo.coders.main.controlador;

import javafx.event.ActionEvent;
import poo.coders.main.modelo.Juego;

public interface ControladorInterfaz {

	void setearInformacionPregunta(Juego juego);

	void cargarVentana(Juego juego);

	void setearJuego(Juego juego);
}
