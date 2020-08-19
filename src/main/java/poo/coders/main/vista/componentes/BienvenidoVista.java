package poo.coders.main.vista.componentes;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import poo.coders.main.controlador.Botones.EmpezarHandlerBoton;
import poo.coders.main.modelo.JuegoMock;

public class BienvenidoVista {
	JuegoVista juegoVista;
	ContenedorJuego contenedorJuego;

	public BienvenidoVista(JuegoVista juegoVista, JuegoMock juegoMock, Stage ventana) {
		this.juegoVista = juegoVista;
		this.juegoVista.setVentana(ventana);
		this.contenedorJuego = new ContenedorJuego();
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId("TITULO");
		anchorPane.setPrefHeight(141);
		anchorPane.setPrefWidth(360);

		Label label = new Label();
		label.setText("ALGOHOOT");
		label.setLayoutX(89);
		label.setLayoutY(58);
		label.setTextAlignment(TextAlignment.CENTER);
		label.setFont(Font.font(33));

		VBox vBox = new VBox();
		vBox.setId("JUGADORES");
		vBox.setStyle("-fx-background-color: #C4C4C4");
		vBox.setMinHeight(124);

		AnchorPane anchorPane1 = new AnchorPane();
		anchorPane1.setId("INPUT J1");

		Label label1 = new Label();
		label1.setText("JUGADOR 1");
		label1.setLayoutX(60);
		label1.setLayoutY(27);
		label1.setPrefHeight(18);
		label1.setPrefWidth(85);
		TextField textField1 = new TextField();
		textField1.setLayoutX(173);
		textField1.setLayoutY(22);
		textField1.setPromptText("Nombre");
		anchorPane1.getChildren().addAll(label1, textField1);

		AnchorPane anchorPane2 = new AnchorPane();
		anchorPane2.setId("INPUT J2");

		Label label2 = new Label();
		label2.setText("JUGADOR 2");
		label2.setLayoutX(60);
		label2.setLayoutY(27);
		label2.setPrefHeight(18);
		label2.setPrefWidth(85);
		TextField textField2 = new TextField();
		textField2.setLayoutX(173);
		textField2.setLayoutY(22);
		textField2.setPromptText("Nombre");
		anchorPane2.getChildren().addAll(label2, textField2);

		AnchorPane anchorPane3 = new AnchorPane();
		anchorPane3.setId("ComenzarContainer");
		anchorPane3.setPrefWidth(360);
		anchorPane3.setPrefHeight(80);
		Button button = new Button();
		button.setLayoutX(135);
		button.setLayoutY(26);
		button.setText("COMENZAR");
		button.setOnAction(new EmpezarHandlerBoton(juegoMock,textField1,textField2));
		anchorPane3.getChildren().add(button);
		vBox.getChildren().addAll(anchorPane1, anchorPane2);
		anchorPane.getChildren().add(label);
		contenedorJuego.getChildren().addAll(anchorPane, vBox, anchorPane3);
	}

	public ContenedorJuego mostrar() {
		return this.contenedorJuego;
	}
}
