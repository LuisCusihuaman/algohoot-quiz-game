package poo.coders.main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.modelo.Juego;
import poo.coders.main.vista.componentes.BienvenidoVista;
import poo.coders.main.vista.componentes.JuegoVista;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) {

		ventana.setTitle("ALGOHOOT");
		Juego juego = new Juego();
		JuegoVista juegoVista = new JuegoVista(juego);
		juego.addObserver(juegoVista);
		BienvenidoVista bienvenidoVista = new BienvenidoVista(juegoVista, juego, ventana);
		Scene escena = new Scene(bienvenidoVista.mostrar(), 360, 640);
		escena.getStylesheets().add(String.valueOf(getClass().getClassLoader().getResource("styles.css")));
		ventana.setScene(escena);
		ventana.setResizable(false);
		ventana.show();
	}
}
