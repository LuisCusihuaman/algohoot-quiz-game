package poo.coders.main.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("/home/matias/Escritorio/tp2-algo3/src/main/java/poo/coders/main/vista/seleccionNombreJugador.fxml")));
		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
