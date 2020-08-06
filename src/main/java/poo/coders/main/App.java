package poo.coders.main;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {

		// set up the scene
		Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("VOFClasicoDemo.fxml")));
		Scene scene = new Scene(root);

		// set up the stage
		stage.setTitle("Orbit the Camera Around an Object Sample");
		stage.setWidth(800);
		stage.setHeight(700);
		stage.setScene(scene);
		stage.show();
	}
}
