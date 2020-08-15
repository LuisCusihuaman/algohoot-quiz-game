package poo.coders.main.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import poo.coders.main.controlador.Botones.ControladorEmpezar;
import poo.coders.main.controlador.EntradaUsuario;

import java.util.ArrayList;

public class ContenedorPrimario extends VBox {

	ArrayList<EntradaUsuario> jugadores = new ArrayList<>();
	ControladorEmpezar controladorInicio ;

	ContenedorPrimario(){
		super();
		this.setAlignment(Pos.CENTER);
		this.setSpacing(20);
		this.setPadding(new Insets(25));

		EntradaUsuario entrada1 = new EntradaUsuario("jugador 1","Nombre1") ;
		EntradaUsuario entrada2 = new EntradaUsuario("jugador 2","Nombre2");
		jugadores.add(entrada1);
		jugadores.add(entrada2);

		VBox verticalBox = new VBox(2);

		verticalBox.setSpacing(25);
		verticalBox.setAlignment(Pos.CENTER);
		verticalBox.getChildren().addAll(entrada1.getHbox(), entrada2.getHbox());
		Label titulo = new Label("Algo-HOOT");
		titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 65));
		titulo.setTextAlignment(TextAlignment.CENTER);
		titulo.setTextFill(Color.web("000000"));

		this.getChildren().addAll(titulo,verticalBox);

	}

	public void setBotonJugar(Stage stage, Scene proximaEscena){
		controladorInicio = new ControladorEmpezar(stage,proximaEscena,jugadores);//(stage,proximaEscena, jugadores);
		Boton botonEntrar = new Boton("JUGAR", controladorInicio);
		this.getChildren().add( botonEntrar);
	}
}
