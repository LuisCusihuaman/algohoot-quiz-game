package poo.coders.main.controlador;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EntradaUsuario {

	HBox hbox;
	TextField texto ;

	public EntradaUsuario(String jugador , String textoHover){
		TextField texto = new TextField(textoHover);
		texto.setPrefColumnCount(16);
		Label unTextoVisible = new Label(jugador);
		HBox hbox = new HBox(2);
		hbox.setSpacing(20);
		hbox.getChildren().addAll(unTextoVisible,texto);
		hbox.setAlignment(Pos.CENTER);
		this.hbox =hbox;
		this.texto = texto;
	}

	public HBox getHbox() {return hbox; }

	public TextField getTexto() { return texto; }
}
