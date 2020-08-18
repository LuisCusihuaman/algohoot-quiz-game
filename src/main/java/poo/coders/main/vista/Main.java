package poo.coders.main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poo.coders.main.modelo.Opcion;
import poo.coders.main.modelo.Parser;
import poo.coders.main.modelo.Pregunta;
import poo.coders.main.vista.componentes.*;
import poo.coders.main.vista.componentes.botones.BotonExclusividad;
import poo.coders.main.vista.componentes.botones.BotonX2;
import poo.coders.main.vista.componentes.botones.BotonX3;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
		List<Pregunta> preguntas = new Parser().parsear();

		Pregunta pregunta = preguntas.get(0);
		String tipoDePregunta = pregunta.getTipoPregunta();
		List<Opcion> opciones = pregunta.getOpciones();
		Set<String> claves = opciones.stream().map(Opcion::getClave).collect(Collectors.toSet());

		ContenedorJuego contenedorJuego = new ContenedorJuego();
		ContenedorInformacion contenedorInformacion = new ContenedorInformacion(tipoDePregunta, "NOMBRE JUGADOR", pregunta.getEnunciado());
		ContenedorModificadores contenedorModificadores = new ContenedorModificadores();

		if (tipoDePregunta.contains("Penalidad")) {
			contenedorModificadores.agregarBoton(new BotonX2());
			contenedorModificadores.agregarBoton(new BotonX3());
		} else {
			contenedorModificadores.agregarBoton(new BotonExclusividad());
		}

		ContenedorOpciones contenedorOpciones = new ContenedorOpciones();

		List<OpcionVista> opcionesVista = new ArrayList<>();

		if (tipoDePregunta.contains("Verdadero o Falso")) {
			OpcionVista opcionVistaVOF = new OpcionVista("OPCIONES");
			opciones.forEach(o -> opcionVistaVOF.agregarOpcionSeleccionBox(o.getTextoOpcion()));
			opcionesVista.add(opcionVistaVOF);

		} else if (tipoDePregunta.contains("Multiple Choice")) {
			for (Opcion opcion : opciones) {
				OpcionVista opcionMCActual = new OpcionVista(opcion.getTextoOpcion());
				// el texto muy largo no se muestra completo
				opcionMCActual.agregarOpcionesSeleccionBox(claves);
				opcionesVista.add(opcionMCActual);
			}
		} else if (tipoDePregunta.contains("Group Choice")) {
			for (Opcion opcion : opciones) {
				OpcionVista opcionGCActual = new OpcionVista(opcion.getTextoOpcion());
				opcionGCActual.agregarOpcionesSeleccionBox(claves);
				opcionesVista.add(opcionGCActual);
			}
		} else {
			for (Opcion opcion : opciones) {
				OpcionVista opcionOCActual = new OpcionVista(opcion.getTextoOpcion());
				opcionOCActual.agregarOpcionesSeleccionBox(claves);
				opcionesVista.add(opcionOCActual);
			}
		}
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
