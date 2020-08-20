package poo.coders.main.controlador;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class EntradaUsuario {

	HBox hb;
	TextField texto ;

	public EntradaUsuario(String jugador , String textoHover){
		TextField texto = new TextField(textoHover);
		texto.setPrefColumnCount(16);
		Label unTextoVisible = new Label(jugador);
		HBox hbox = new HBox(2);
		hbox.setSpacing(20);
		hbox.getChildren().addAll(unTextoVisible,texto);
		hb= hbox;
	}

	public HBox getHbox() {return hb; }

	public TextField getTexto() { return texto; }
}
