package poo.coders.main.controlador;

import poo.coders.main.modelo.Juego;

public class ControladorLogica {
	private Juego juego;

	public ControladorLogica(Juego juego) {
		this.juego = juego;
	}

	/*public ControladorInterfaz obtenerControladorActual(){

		switch (game.getState()){
			case INITIAL:
				return startController;
			case IN_GAME:
				return colocateControllerBuilder.getColocateController();
			case FINAL:
				return continueController;
			case EXIT:
			default:
				return null;
		}
	}*/

}
