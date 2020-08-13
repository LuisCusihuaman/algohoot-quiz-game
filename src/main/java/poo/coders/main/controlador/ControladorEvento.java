package poo.coders.main.controlador;

import javafx.stage.Stage;
import poo.coders.main.modelo.Juego;

public interface ControladorEvento {

	void setearInformacionPregunta();

	void cargarVentana();

	void setearJuego(Juego juego, Stage ventanaPrincipal);
}
