package poo.coders.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import poo.coders.main.controlador.ControladorInterfaz;
import poo.coders.main.controlador.ControladorSeleccionNombreJugador;
import poo.coders.main.modelo.Juego;

import java.net.URL;
import java.util.Objects;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		Juego juego = new Juego();
		URL url = Objects.requireNonNull(getClass().getClassLoader().getResource("seleccionNombreJugador.fxml"));
		FXMLLoader loader = new FXMLLoader(url);
		Parent root = loader.load();
		ControladorInterfaz controladorNombreJugador = loader.getController();
		controladorNombreJugador.setearJuego(juego);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
