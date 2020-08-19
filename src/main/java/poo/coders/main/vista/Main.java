package poo.coders.main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

		VBox juegoContainer = new VBox();
		juegoContainer.setId("JuegoScreen");
		juegoContainer.setStyle("-fx-background-color: FFFFFF");

		/* INFORMACION SECTION */
		AnchorPane informacionContainer = new AnchorPane();
		informacionContainer.setId("Informacion");
		informacionContainer.setPrefHeight(96);
		informacionContainer.setPrefWidth(360);

		Label tipoPregunta = new Label();
		tipoPregunta.setLayoutX(14);
		tipoPregunta.setLayoutY(18);
		tipoPregunta.setText("TIPO PREGUNTA");

		Label nombreJugador = new Label();
		nombreJugador.setLayoutX(213);
		nombreJugador.setLayoutY(18);
		nombreJugador.setText("NOMBRE JUGADOR");

		Label preguntaEnunciado = new Label();
		preguntaEnunciado.setLayoutX(93);
		preguntaEnunciado.setLayoutY(48);
		preguntaEnunciado.setText("PREGUNTA ENUNCIADO");

		informacionContainer.getChildren().add(tipoPregunta);
		informacionContainer.getChildren().add(nombreJugador);
		informacionContainer.getChildren().add(preguntaEnunciado);
		/* INFORMACION SECTION */

		/* MODIFICADOR SECTION */
		AnchorPane modificadoresContainer = new AnchorPane();
		modificadoresContainer.setId("Modificadores");
		modificadoresContainer.setMinHeight(66);
		modificadoresContainer.setPrefWidth(360);

		Label timer = new Label();
		timer.setLayoutX(27);
		timer.setLayoutY(20);
		timer.setPrefHeight(28);
		timer.setPrefWidth(69);
		timer.setText("TIMER");//falta setear su tamaño a 17

		Button btnX2 = new Button();
		btnX2.setLayoutX(120);
		btnX2.setLayoutY(20);
		btnX2.setText("X2");

		Button btnX3 = new Button();
		btnX3.setLayoutX(180);
		btnX3.setLayoutY(20);
		btnX3.setText("X3");

		Button btnExclusividad = new Button();
		btnExclusividad.setLayoutX(237);
		btnExclusividad.setLayoutY(20);
		btnExclusividad.setText("EXCLUSIVIDAD");

		modificadoresContainer.getChildren().add(timer);
		modificadoresContainer.getChildren().add(btnX2);
		modificadoresContainer.getChildren().add(btnX3);
		modificadoresContainer.getChildren().add(btnExclusividad);
		/* MODIFICADOR SECTION */

		/*OPCIONES SECTION*/
		VBox opcionesContainer = new VBox();
		opcionesContainer.setId("Opciones");
		opcionesContainer.setStyle("-fx-background-color: C4C4C4");
		opcionesContainer.setMinHeight(432);

		OpcionVista op1 = new OpcionVista("OPCION 1");
		OpcionVista op2 = new OpcionVista("OPCION 2");
		OpcionVista op3 = new OpcionVista("OPCION 3");
		OpcionVista op4 = new OpcionVista("OPCION 4");
		OpcionVista op5 = new OpcionVista("OPCION 5");
		opcionesContainer.getChildren().add(op1);
		opcionesContainer.getChildren().add(op2);
		opcionesContainer.getChildren().add(op3);
		opcionesContainer.getChildren().add(op4);
		opcionesContainer.getChildren().add(op5);
		/*OPCIONES SECTION*/

		/*SIGUIENTE SECTION*/
		AnchorPane siguienteContainer = new AnchorPane();
		siguienteContainer.setId("SiguienteContainer");
		siguienteContainer.setPrefWidth(80);
		siguienteContainer.setPrefHeight(360);

		Button btnSiguiente = new Button();
		btnSiguiente.setLayoutX(138);
		btnSiguiente.setLayoutY(20);
		btnSiguiente.setText("SIGUIENTE");
		siguienteContainer.getChildren().add(btnSiguiente);
		/*SIGUIENTE SECTION*/

		/*screens added*/
		juegoContainer.getChildren().add(informacionContainer);
		juegoContainer.getChildren().add(modificadoresContainer);
		juegoContainer.getChildren().add(opcionesContainer);
		juegoContainer.getChildren().add(siguienteContainer);

		Scene primaryScene = new Scene(juegoContainer, 360, 640);
		primaryStage.setScene(primaryScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
