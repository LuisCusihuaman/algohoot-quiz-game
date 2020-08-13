package poo.coders.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.controlador.ControladorEvento;
import poo.coders.main.modelo.Juego;

import java.net.URL;
import java.util.Objects;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventanaPrincipal) throws Exception {

		Juego juego = new Juego();
		URL url = Objects.requireNonNull(getClass().getClassLoader().getResource("seleccionNombreJugador.fxml"));
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		ControladorEvento controladorNombreJugador = loader.getController();
		controladorNombreJugador.setearJuego(juego, ventanaPrincipal);
		Scene scene = new Scene(root);
		ventanaPrincipal.setScene(scene);
		ventanaPrincipal.show();
	}

}
