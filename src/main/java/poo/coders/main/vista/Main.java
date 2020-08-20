package poo.coders.main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.modelo.Juego;
import poo.coders.main.vista.componentes.BienvenidoVista;
import poo.coders.main.vista.componentes.ContenedorJuego;
import poo.coders.main.vista.componentes.JuegoVista;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		primaryStage.setTitle("algohoot");
		Juego juego = new Juego();
		JuegoVista juegoVista = new JuegoVista(juego);
		juego.addObserver(juegoVista);
		BienvenidoVista bienvenidoVista = new BienvenidoVista(juegoVista, juego, primaryStage);
		ContenedorJuego contenedorJuego = bienvenidoVista.mostrar();
		Scene primaryScene = new Scene(contenedorJuego, 360, 640);
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
