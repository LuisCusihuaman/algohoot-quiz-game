package poo.coders.main.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
		primaryStage.setTitle("algohoot");
		ContenedorPrimario contenedorPrimario = new ContenedorPrimario();
		Scene escenaPrimaria = new Scene(contenedorPrimario);
		ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal();
		Scene escenaJuego = new Scene(contenedorPrincipal);

		contenedorPrimario.setBotonJugar(primaryStage,escenaJuego);

		primaryStage.setScene(escenaPrimaria);
		primaryStage.setResizable(false);
		primaryStage.show();
    }
}
