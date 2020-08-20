package poo.coders.main.controlador.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.controlador.EntradaUsuario;

import java.util.ArrayList;

public class ControladorEmpezar  implements EventHandler<ActionEvent> {


	ArrayList<EntradaUsuario> entradaJugadores;
	Stage stage;
	Scene proximaEscena;

	public ControladorEmpezar(Stage stage, Scene proximaEscena, ArrayList<EntradaUsuario> entradaJugadores ){
		this.stage = stage;
		this.proximaEscena = proximaEscena;
		this.entradaJugadores = entradaJugadores;
	}

	@Override
	public void handle(ActionEvent actionEvent) {

	}
}
