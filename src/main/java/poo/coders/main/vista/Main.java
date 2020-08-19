package poo.coders.main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.vista.componentes.*;

import java.util.ArrayList;
import java.util.List;

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
		ContenedorJuego contenedorJuego = new ContenedorJuego();

		ContenedorInformacion contenedorInformacion = new ContenedorInformacion("TIPO PREGUNTA", "NOMBRE JUGADOR", "PREGUNTA ENUNCIADO");

		ContenedorModificadores contenedorModificadores = new ContenedorModificadores();

		ContenedorOpciones contenedorOpciones = new ContenedorOpciones();
		List<OpcionVista> opcionesVista = new ArrayList<>();
		opcionesVista.add(new OpcionVista("OPCION 1"));
		opcionesVista.add(new OpcionVista("OPCION 2"));
		opcionesVista.add(new OpcionVista("OPCION 3"));
		opcionesVista.add(new OpcionVista("OPCION 4"));
		opcionesVista.add(new OpcionVista("OPCION 5"));
		opcionesVista.forEach(contenedorOpciones::agregarOpcion);

		ContenedorSiguiente contenedorSiguiente = new ContenedorSiguiente();

		contenedorJuego.getChildren().add(contenedorInformacion);
		contenedorJuego.getChildren().add(contenedorModificadores);
		contenedorJuego.getChildren().add(contenedorOpciones);
		contenedorJuego.getChildren().add(contenedorSiguiente);

		Scene primaryScene = new Scene(contenedorJuego, 360, 640);
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
