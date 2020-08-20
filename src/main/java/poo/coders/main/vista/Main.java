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
/*		primaryStage.setTitle("algohoot");
		ContenedorPrimario contenedorPrimario = new ContenedorPrimario();
		Scene escenaPrimaria = new Scene(contenedorPrimario,800,500);
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
		Scene escenaJuego = new Scene(contenedorPrincipal,800,500);

		contenedorPrimario.setBotonJugar(primaryStage,escenaJuego);

		primaryStage.setScene(escenaPrimaria);
		primaryStage.setResizable(false);
		primaryStage.show();*/

		primaryStage.setTitle("algohoot");
		//CREATE MODEL AND CONFIGURE IN FLIGHT
		Juego juego = new Juego();
		//CREATE OBSERVER VIEW OBSERVER
		JuegoVista juegoVista = new JuegoVista(juego);
		juego.addObserver(juegoVista);
		// COMPOSE WITH OTHER VIEWS
		BienvenidoVista bienvenidoVista = new BienvenidoVista(juegoVista, juego, primaryStage);
		ContenedorJuego contenedorJuego = bienvenidoVista.mostrar();
		Scene primaryScene = new Scene(contenedorJuego, 360, 640);
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
